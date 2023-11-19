package com.team.MailRestVariant.services;

import com.team.MailRestVariant.models.dtos.UserDTO;

public interface UserDTOService {

    UserDTO creteUserDTO();

    boolean validateUserDTO(UserDTO userDTO);
}
