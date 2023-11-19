package com.team.MailRestVariant.services;

import com.team.MailRestVariant.models.dtos.UserDTO;
import com.team.MailRestVariant.models.entities.User;

import java.util.List;

public interface UserService {

    User createUser(UserDTO userDTO);

    List<User> getUserList();

    User getUserById(long id);
}
