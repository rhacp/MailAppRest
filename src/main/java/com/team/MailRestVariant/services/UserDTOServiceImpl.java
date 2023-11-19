package com.team.MailRestVariant.services;

import com.team.MailRestVariant.models.ValidDomain;
import com.team.MailRestVariant.models.dtos.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserDTOServiceImpl implements UserDTOService{

    @Override
    public UserDTO creteUserDTO() {
        return new UserDTO();
    }

    @Override
    public boolean validateUserDTO(UserDTO userDTO) {
        //Check mail
        if (!userDTO.getEmail().contains("@")) return false;
        String[] mailArray = userDTO.getEmail().split("@");
        if (mailArray[0].length() < 3) return false;
        if (!mailArray[1].equals(ValidDomain.YAHOO.getValue()) && !mailArray[1].equals(ValidDomain.GMAIL.getValue())) return false;

        //Check first and last name
        if (userDTO.getFirstName() == null || userDTO.getLastName() == null) return false;
        if (userDTO.getFirstName().length() < 3 || userDTO.getLastName().length() < 3) return false;

        return true;
    }
}
