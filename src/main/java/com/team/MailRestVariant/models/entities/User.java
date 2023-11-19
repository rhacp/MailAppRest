package com.team.MailRestVariant.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime createdAt;
}
