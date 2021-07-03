package com.gokul.chatsappauth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class User {

    public User(User user){
        this.id=user.id;
        this.username=user.username;
        this.password=user.password;
        this.email=user.email;
        this.email=user.email;
        this.createdAt=user.createdAt;
        this.updatedAt=user.updatedAt;
        this.active=user.active;
        this.userProfile=user.userProfile;
        this.roles=user.roles;
    }

    public User(String username,String password,String email){
        this.username=username;
        this.password=password;
        this.email=email;
        this.active=true;
        this.roles=new HashSet<>(){{new Role("USER");}};
    }


    @Id
    private String id;


    @NotBlank
    @Size(max=15)
    private String username;

    @NotBlank
    @Size(max = 50)
    @JsonIgnore
    private String password;

    @NotBlank
    @Size(max = 40)
    private String email;


    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    private boolean active;

    private Profile userProfile;

    private Set<Role>roles;

}
