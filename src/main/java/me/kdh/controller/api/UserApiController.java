package me.kdh.controller.api;

import lombok.RequiredArgsConstructor;
import me.kdh.dto.AddUserRequest;
import me.kdh.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;
}