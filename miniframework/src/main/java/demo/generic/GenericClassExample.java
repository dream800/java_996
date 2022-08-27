package demo.generic;

import lombok.Data;

import java.util.Arrays;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-25
 */
@Data
public class GenericClassExample<T> {

    private T member;


    public GenericClassExample(T member) {
        this.member = member;
    }

    public T handleSomething(T target)
    {
        return target;
    }


    public static  <E>  void printArray(E[] files)
    {
        for (E file : files) {
            System.out.println(file);
        }
    }
}
