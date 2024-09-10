// package com.adoptaamor.adoptaamor.exceptions;


// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import java.util.List;
// import java.util.stream.Collectors;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(MethodArgumentNotValidException.class)
//     public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
//         // Capturar todos los errores de validación y devolverlos como lista
//         List<String> errors = ex.getBindingResult().getFieldErrors().stream()
//                 .map(error -> error.getField() + ": " + error.getDefaultMessage()) // Campo + mensaje de error
//                 .collect(Collectors.toList());
//         return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//     }
// }
