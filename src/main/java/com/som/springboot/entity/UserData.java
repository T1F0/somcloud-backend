package com.som.springboot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class UserData {
    @Id
    private Integer userid;
    private String usernickname;
    private String usergender;
    private String userregion;
    private String userbirthday;
    private String userheadportraiturl;
}