package com.cadians.techserver.domain.dto.request;
import com.cadians.techserver.domain.entity.Authentication;
import com.cadians.techserver.domain.entity.User;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqPostUser {
    @NotNull
    private String id;
    @NotNull
    private String pwd;
    @NotNull
    private String email;
    @NotNull
    private String type;
    @NotNull
    private String productKey;

    public User toEntity()
    {
        return new User(this.id , this.pwd , this.email,this.type);
    }
    public User toEntity(Authentication auth)
    {
        return new User(this.id , this.pwd , this.email,this.type,auth);
    }
}
