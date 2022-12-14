package com.cadians.techserver.domain.service;

import com.cadians.techserver.domain.dto.request.ReqPostLogin;
import com.cadians.techserver.domain.dto.response.ResLogin;
import com.cadians.techserver.domain.dto.response.ResUser;
import com.cadians.techserver.domain.entity.User;
import com.cadians.techserver.domain.repository.UserRepository;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    private final UserRepository userRepository;

    public LoginService(UserRepository _userreqository)
    {
        this.userRepository = _userreqository;
    }

    @Transactional(readOnly = true)
    private User getUserRep(String _id)
    {
        return userRepository.findById(_id).orElse(null);
    }

    public boolean VaildUser(String _id,String _pwd)
    {
        User _userRep = getUserRep(_id);
        if(_userRep!=null&& _userRep.getPwd().equals(_pwd)) return true;
        return false;
    }

    public ResLogin getLoginResult(ReqPostLogin _reqPostLogin)
    {
        ResLogin resLogin = new ResLogin(VaildUser(_reqPostLogin.getID(),_reqPostLogin.getPwd()));
        return resLogin;
    }
}
