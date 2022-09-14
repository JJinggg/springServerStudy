package com.cadians.techserver.domain.repository;

import com.cadians.techserver.domain.entity.FriendShipCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FriendShipCompanyRepository extends JpaRepository<FriendShipCompany,String> {
    @Override
    Optional<FriendShipCompany>findById(String s);
}
