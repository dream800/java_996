package com.dream.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
//注解的作用目标  字段上
@Target({ElementType.FIELD})
//注解的保留策略 运行期
@Retention(RetentionPolicy.RUNTIME)
// 关联验证器
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {

    String message() default "手机号不合法";

    //约束注解组别
    Class<?>[] groups() default {};

    // 约束注解的有效负载
    Class<? extends Payload>[] payload() default {};

}
