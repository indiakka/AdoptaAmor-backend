package com.adoptaamor.adoptaamor.services;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class FileStorageService {

    private final Cloudinary cloudinary;

    public FileStorageService(
            @Value("${cloudinary.cloud_name}") String cloudName,
            @Value("${cloudinary.api_key}") String apiKey,
            @Value("${cloudinary.api_secret}") String apiSecret) {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret));

        System.out.println("name: " + cloudName);
        System.out.println("key: " + apiKey);
        System.out.println("secret: " + apiSecret);
    }

    public String storeFile(MultipartFile file) {

        if (file == null || file.isEmpty()) {
            return null;
        }

        try {

            String fileName = UUID.randomUUID().toString().replace("-", "");
            fileName = fileName.replaceAll("[^a-zA-Z0-9]", "");
            fileName = fileName + "_" + UUID.randomUUID().toString().replace("-", "").substring(0, 15);

            Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap(
                            "resource_type", "auto",
                            "public_id", fileName));

            String publicUrl = uploadResult.get("secure_url").toString();
            return publicUrl;
        } catch (IOException e) {
            throw new RuntimeException("Error al subir el archivo a Cloudinary", e);
        }
    }
}
