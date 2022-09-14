package com.cadians.techserver.domain.dto.response;
import com.cadians.techserver.domain.entity.Authentication;
import com.cadians.techserver.domain.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResUser {

    private final String id;
    private final String pwd;
    private final String email;
    private final String type;
    private final Authentication auth;

    public ResUser(User _user)
    {
        this.id = _user.getId();
        this.pwd= _user.getPwd();
        this.type =_user.getType();
        this.email = _user.getEmail();
        this.auth = _user.getAuthentication();
    }
}
