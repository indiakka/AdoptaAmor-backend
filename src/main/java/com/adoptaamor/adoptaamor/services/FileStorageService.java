package com.adoptaamor.adoptaamor.services;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import io.github.cdimascio.dotenv.Dotenv;

@Service
public class FileStorageService {

    private final Cloudinary cloudinary;

    public FileStorageService() {
        Dotenv dotenv = Dotenv.load();
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", dotenv.get("CLOUDINARY_CLOUD_NAME"),
                "api_key", dotenv.get("CLOUDINARY_API_KEY"),
                "api_secret", dotenv.get("CLOUDINARY_API_SECRET")));
    }

    @SuppressWarnings("unchecked")
    public String storeFile(MultipartFile file) {

        if (file == null || file.isEmpty()) {
            return null;
        }

        try {
            String fileName = UUID.randomUUID().toString().replace("-", "")
                    + "_" + UUID.randomUUID().toString().replace("-", "").substring(0, 15);

            Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap(
                            "resource_type", "auto",
                            "public_id", fileName));

            return uploadResult.get("secure_url").toString();
        } catch (IOException e) {
            throw new RuntimeException("Error al subir el archivo a Cloudinary", e);
        }
    }
}