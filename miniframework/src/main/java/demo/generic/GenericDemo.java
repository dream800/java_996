package demo.generic;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-25
 */
public class GenericDemo {

    public static void main(String[] args) {

        GenericClassExample<String> abc = new GenericClassExample<>("abc");

        GenericClassExample<Integer> example = new GenericClassExample<>(123);

        System.out.println(abc.getMember().getClass());
        System.out.println(example.getMember().getClass());


        Integer[] arr = {1,2,3};
        GenericClassExample.printArray(arr);


        Character[] arr1 = {'1','2','3'};
        GenericClassExample.printArray(arr1);


    }

}
