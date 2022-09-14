package com.cadians.techserver.domain.service;

import com.cadians.techserver.domain.entity.Authentication;
import com.cadians.techserver.domain.repository.AuthenticationRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationRepository authenticationRepository;
    @Transactional(readOnly = true)
    public Authentication verifiProductKey(String key) {
        return authenticationRepository.findById(key).orElse(null);
    }

}
