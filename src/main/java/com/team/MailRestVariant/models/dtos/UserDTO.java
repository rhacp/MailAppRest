package com.team.MailRestVariant.models.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String firstName;
    private String lastName;
    private String email;
}
