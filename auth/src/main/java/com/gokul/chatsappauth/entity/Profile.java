package com.gokul.chatsappauth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Size(max = 50)
    private String displayName;
    private String profilePictureUrl;
    private Date birthday;
    private Set<Address>addresses;
}
