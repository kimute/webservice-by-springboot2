package com_kim.config.auth.dto;

import com_kim.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

//認証を通ったユーザー情報のみ処置
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
