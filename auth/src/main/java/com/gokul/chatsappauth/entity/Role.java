package com.gokul.chatsappauth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {


    public final static Role User=new Role("USER");


    private String name;
}
