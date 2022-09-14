package com.cadians.techserver.domain.dto.request;
import com.sun.istack.NotNull;

public class ReqPostLogin {

    @NotNull
    private String id;
    @NotNull
    private String pwd;
    private String email;
    private String type;

    public String getID(){return id;}
    public String getPwd(){return pwd;}
    public String getEmail(){return email;}
    public String getType(){return type;}

    public void setID(String id){this.id = id;}
    public void setPwd(String pwd){this.pwd = pwd;}
    public void setEmail(String email){this.email = id;}
    public void setType(String type){this.type = type;}

}
