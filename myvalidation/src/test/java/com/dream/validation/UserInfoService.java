package com.dream.validation;

import javax.validation.Valid;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-08
 */
public class UserInfoService {

    public void setUserInfo(@Valid UserInfo userInfo) {}

    public @Valid UserInfo getUserInfo()
    {
        return new UserInfo();
    }

    public UserInfoService() {
    }

    public UserInfoService(@Valid  UserInfo userInfo) {

    }
}
