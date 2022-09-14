package com.cadians.techserver.domain.service;

import com.cadians.techserver.domain.dto.request.ReqPostUser;
import com.cadians.techserver.domain.dto.response.ResUser;
import com.cadians.techserver.domain.entity.Authentication;
import com.cadians.techserver.domain.entity.User;
import com.cadians.techserver.domain.repository.AuthenticationRepository;
import com.cadians.techserver.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;
    @Transactional(readOnly = true)
    public List<ResUser> getUser()
    {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC,User.COL_ID)).stream()
                .map(ResUser::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ResUser getUser(String _id)
    {
        User user = userRepository.findById(_id).orElse(null);
        if(user==null){return null;}
        return new ResUser(user);
    }


    @Transactional
    public User initUser(ReqPostUser _reqPostUser)
    {
        var auth = authenticationService.verifiProductKey(_reqPostUser.getProductKey());
        if(auth==null) return null;

        userRepository.save(_reqPostUser.toEntity(auth));
        return _reqPostUser.toEntity(auth);
    }

}
