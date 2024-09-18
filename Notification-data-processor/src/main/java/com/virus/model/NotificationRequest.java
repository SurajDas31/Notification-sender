package com.virus.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Document
@Getter
@Setter
@ToString
public class NotificationRequest {

    private UUID id = UUID.randomUUID();

    @NotBlank(message = "username is mandatory")
    private String username;

    @NotBlank(message = "user email is mandatory")
    @Email(message = "Email id is not valid")
    private String userEmail;

    @NotBlank(message = "user contact number is mandatory")
    private String userContactNumber;

    private NotificationType notificationType;

    private Status status = Status.OPEN;

}
