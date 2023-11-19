package com.team.MailRestVariant.services;

import com.team.MailRestVariant.models.dtos.UserDTO;
import com.team.MailRestVariant.models.entities.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private List<User> userList = new ArrayList<>(List.of(
            new User(1, "Laur", "Iulian", "mail@gmail.com", LocalDateTime.now()),
            new User(2, "Eric", "Cartman", "ericisevil@gmail.com", LocalDateTime.now())
    ));

    @Override
    public User createUser(UserDTO userDTO) {
        User user = new User();
        //add validation

        //assigned userDTO values to user
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());

        //set db properties
        user.setCreatedAt(LocalDateTime.now());
        assignId(user);

        //add to database
        userList.add(user);

        return user;
    }

    @Override
    public List<User> getUserList() {
        return userList;
    }

    @Override
    public User getUserById(long id) {
        for (int index = 0; index < userList.size(); index++) {
            if (userList.get(index).getId() == id) {
                return userList.get(index);
            }
        }

        throw new RuntimeException();
    }

    private void assignId(User user) {
        if (userList.isEmpty()) {
            user.setId(1L);
        } else {
            long maxId = 0;
            for (User element : userList) {
                if (element.getId() > maxId) {
                    maxId = element.getId();
                }
            }

            user.setId(maxId + 1L);
        }
    }
}
