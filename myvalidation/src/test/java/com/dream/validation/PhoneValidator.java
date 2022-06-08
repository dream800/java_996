package com.dream.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-08
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public void initialize(Phone constraintAnnotation) {
        //接口是default默认可以不实现
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        Pattern regex = Pattern.compile("1[3-9]\\d{9}");
        String optional = Optional.ofNullable(s).orElse("");
        Matcher matcher = regex.matcher(optional);


        return matcher.matches();
//        if (!matcher.matches()) {
//            return false;
//        }

//        return true;
    }
}
