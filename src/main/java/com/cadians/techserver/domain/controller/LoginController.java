package com.cadians.techserver.domain.controller;

import com.cadians.techserver.domain.dto.request.ReqPostLogin;
import com.cadians.techserver.domain.dto.response.ResLogin;
import com.cadians.techserver.domain.service.LoginService;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final  LoginService loginService;
    public LoginController(LoginService _loginService)
    {
        this.loginService = _loginService;
    }

    @PostMapping
    @ResponseBody
    public ResLogin VerificationUser(@RequestBody @Valid ReqPostLogin _reqPostLogin)
    {
        return loginService.getLoginResult(_reqPostLogin);
    }

}