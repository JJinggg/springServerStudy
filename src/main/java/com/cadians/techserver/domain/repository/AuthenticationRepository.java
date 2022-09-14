package com.cadians.techserver.domain.repository;

import com.cadians.techserver.domain.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthenticationRepository extends JpaRepository<Authentication,String> {
    @Override
    Optional<Authentication> findById(String s);
}
