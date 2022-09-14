package com.cadians.techserver.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = User.TABLE_NAME)
@Getter
@Setter
public class User {

    public static final String TABLE_NAME = "User";
    public static final String COL_ID = "id";
    public static final String COL_PWD = "pwd";
    public static final String COL_EMAIL = "email";
    public static final String COL_Type ="type";
    public static final String COL_ProductKey = "productkey";
    public User()
    {
    }


    public User(String _id , String _pwd , String _email,String _type,Authentication _auth)
    {
        this.id = _id;
        this.pwd = _pwd;
        this.email = _email;
        this.type = _type;
        this.authentication = _auth;
    }
    public User(String _id , String _pwd , String _email,String _type)
    {
        this.id = _id;
        this.pwd = _pwd;
        this.email = _email;
        this.type = _type;
    }

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GenericGenerator(name = "USER_GENERATOR", strategy = "uuid")
    @Column(name = COL_ID)
    private String id ="";

    @Column(name = COL_PWD)
    private String pwd = "";

    @Column(name = COL_EMAIL)
    private String email = "";

    @Column(name = COL_Type)
    private String type ="";

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = Authentication.TABLE_NAME+"_"+Authentication.COL_ProductKey)
    private Authentication authentication;
}

