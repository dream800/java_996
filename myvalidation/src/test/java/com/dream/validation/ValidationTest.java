package com.dream.validation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-08
 */
public class ValidationTest {


    private Validator validator;

    private UserInfo userInfo;

    private Set<ConstraintViolation<UserInfo>> set;


    Set<ConstraintViolation<UserInfoService>> constraintViolations;

    @Before
    public void init() throws ParseException {
        validator = Validation.buildDefaultValidatorFactory().getValidator();

        userInfo = new UserInfo();
//        userInfo.setUserId("12");
        userInfo.setUserName("dream");
        userInfo.setPassWord("12345678");
        userInfo.setEmail("");
        userInfo.setAge(20);
        userInfo.setPhone("110");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        userInfo.setBirthday(df.parse("2022-06-09"));

        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.JUNE, 9);
//        userInfo.setBirthday(calendar.getTime());

        UserInfo friend = new UserInfo();
        friend.setUserId("123");
        friend.setUserName("dream1");
        friend.setPassWord("12345678");
        friend.setBirthday(calendar.getTime());
        List<UserInfo> list = new ArrayList() {
//            {add(new UserInfo());}
//            {add(new UserInfo());}
            {add(friend);}
            {add(friend);}
        };
        this.userInfo.setFriends(list);
    }


    @Test
    public void nullValidation()
    {
        set = validator.validate(userInfo);


    }


    @Test
    public void groupsValidation()
    {
//        set = validator.validate(userInfo, UserInfo.createUserInfo.class);
        set = validator.validate(userInfo, UserInfo.updateUserInfo.class);


    }

    @Test
    public void paramValidation() throws NoSuchMethodException {
        ExecutableValidator executableValidator = validator.forExecutables();

        UserInfoService userInfoService = new UserInfoService();
        Method method = userInfoService.getClass().getMethod("setUserInfo", UserInfo.class);
        Object[] objects = {new UserInfo()};
        constraintViolations = executableValidator.validateParameters(userInfoService, method, objects);
    }


    @Test
    public void returnValueValidation() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ExecutableValidator valid = validator.forExecutables();
        UserInfoService userInfoService = new UserInfoService();
        Method method = userInfoService.getClass().getMethod("getUserInfo");
        Object returnValue = method.invoke(userInfoService);
        constraintViolations = valid.validateReturnValue(userInfoService, method, returnValue);
    }

    @Test
    public void constructValidation() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ExecutableValidator valid = validator.forExecutables();

        Constructor<UserInfoService> constructor = UserInfoService.class.getConstructor(UserInfo.class);

        Object[] objects = {new UserInfo()};

        constraintViolations = valid.validateConstructorParameters(constructor, objects);


    }


    @After
    public void print()
    {
        set.forEach(e->{
            System.out.println(e.getMessage());
        });

//        constraintViolations.forEach(e->{
//            System.out.println(e.getMessage());
//        });
    }

}
