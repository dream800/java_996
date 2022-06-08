# 996

## 验证

##### 注解

@NotNull(message = "userId不能为空")

@NotEmpty(message = "userNmae不能为空")

```
@NotBlank(message = "密码不能为空")
@Length(min = 8, max = 10, message = "密码长度需要在8和10之间")
```

@Email 不能同时验证为空  要加上空的判断 为null

@Min 也是不会同时验证为空 或者null

@Max  也是不会同时验证为空 或者null

```
@Past(message = "不能设置一个未来的日期")
@Future(message = "不能设置一个过去的日期")
```

```
@Size(min = 1, message = "不能少于1个好友") 验证集合list的个数
```

##### 级联验证 

```
private List<@Valid UserInfo> friends;
```



##### 分组验证

```
public interface createUserInfo{}
public interface updateUserInfo{};

set = validator.validate(userInfo, UserInfo.updateUserInfo.class);
```

```
分组验证的排序   按照顺序进行验证 先后
@GroupSequence({
        createUserInfo.class,
        updateUserInfo.class,
        Default.class
})
public interface Group{}

set = validator.validate(userInfo, UserInfo.updateUserInfo.class, UserInfo.createUserInfo.class);
```









##### 两种日期设置方式

```
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
userInfo.setBirthday(df.parse("2022-06-07"));

Calendar calendar = Calendar.getInstance();
calendar.set(2022, Calendar.JUNE, 5);
userInfo.setBirthday(calendar.getTime());
```

##### 集合的另一种add方式

```
List<UserInfo> list = new ArrayList() {
    {add(new UserInfo());}
    {add(new UserInfo());}
};
```