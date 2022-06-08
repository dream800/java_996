package com.dream.validation;

import org.hibernate.validator.constraints.Length;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.util.Date;
import java.util.List;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-08
 */
public class UserInfo {

    public interface createUserInfo{}
    public interface updateUserInfo{};


    @GroupSequence({
            createUserInfo.class,
            updateUserInfo.class,
            Default.class
    })
    public interface Group{}

    @NotNull(message = "userId不能为空", groups = updateUserInfo.class)
    private String userId;


    @NotEmpty(message = "userName不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Length(min = 8, max = 10, message = "密码长度需要在8和10之间")
    private String passWord;

    @Email(message = "邮箱格式不对")
    private String email;


    @Phone
    private String  phone;


//    @Past(message = "不能设置一个未来的日期")
    @Future(message = "不能设置一个过去的日期")
    private Date birthday;

    @Min(value = 18, message = "最小年纪不能小于18岁")
    @Max(value = 60, message = "最大年纪不能大于60岁")
    private Integer age;


    @Size(min = 2, message = "不能少于1个好友")
    private List<@Valid UserInfo> friends;

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", friends=" + friends +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<UserInfo> getFriends() {
        return friends;
    }

    public void setFriends(List<UserInfo> friends) {
        this.friends = friends;
    }
}
