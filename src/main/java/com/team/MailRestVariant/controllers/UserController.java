package com.team.MailRestVariant.controllers;

import com.team.MailRestVariant.models.dtos.UserDTO;
import com.team.MailRestVariant.models.entities.User;
import com.team.MailRestVariant.services.MailService;
import com.team.MailRestVariant.services.UserDTOService;
import com.team.MailRestVariant.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserDTOService userDTOService;
    private final MailService mailService;

    public UserController(UserService userService, UserDTOService userDTOService, MailService mailService) {
        this.userService = userService;
        this.userDTOService = userDTOService;
        this.mailService = mailService;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        User user = userService.getUserById(id);

        userService.getUserList().remove(user);
        log.info("User Deleted.");

        return ResponseEntity.ok("User deleted: " + user.getFirstName() + ", ID: " + user.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = userService.getUserById(id);
        log.info("Shown User By ID.");
        return ResponseEntity.ok(user);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        log.info("Displayed User List.");
        return ResponseEntity.ok(userService.getUserList());
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        if (!userDTOService.validateUserDTO(userDTO)) {
            log.error("Invalid input.");

            return null;
        }

        User user = userService.createUser(userDTO);
        mailService.sendMail(user.getEmail(), mailService.prepareMail(user));
        log.info("User Created!");

        return ResponseEntity.ok(user);
    }
}
