package com.virus.exception_handler;

import com.virus.model.NotificationType;
import com.virus.model.API_Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class RestControllerExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException e) {
        API_Error api_error = new API_Error();
        e.getBindingResult().getAllErrors().forEach(err -> {
            String defaultMessage = err.getDefaultMessage();
//            String field = ((FieldError) err).getField();
            api_error.setStatus_code(400);
            api_error.setMessage(defaultMessage);

        });

        return new ResponseEntity(api_error, HttpStatus.BAD_REQUEST);
    }

    // Handling for Notification type field
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleNotificationTypeExceptionHandler(HttpMessageNotReadableException e) {
        API_Error api_error = null;
        if (e.getMessage().contains("JSON parse error: Cannot deserialize value of type `" + NotificationType.class.getName())) {
            // Handle invalid sort direction
            api_error = new API_Error();
            api_error.setStatus_code(400);
            api_error.setMessage("Invalid input in 'notificationType' field. Please type 'M' (Mail) or 'S' (SMS)");
        }
        return new ResponseEntity(api_error, HttpStatus.BAD_REQUEST);
    }
}
