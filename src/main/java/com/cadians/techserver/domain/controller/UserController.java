package com.cadians.techserver.domain.controller;

import com.cadians.techserver.domain.dto.response.ResUser;
import com.cadians.techserver.domain.dto.request.ReqPostUser;
import com.cadians.techserver.domain.entity.User;
import com.cadians.techserver.domain.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService _userService)
    {
        this.userService = _userService;
    }

    @GetMapping
    public List<ResUser> getUser()
    {
        return userService.getUser();
    }

    @PostMapping
    public User initUser(@RequestBody @Valid ReqPostUser _reqPostUser)
    {
        return userService.initUser(_reqPostUser);
    }

    @GetMapping("/info")
    public ResUser getUserInfo(@RequestParam String id){return userService.getUser(id);}
}
