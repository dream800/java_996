package demo.reflect;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-25
 */
public class ReflectTest {

    ReflectTest(String name) {
        System.out.println("name: " + name);
    }
    public ReflectTest(char name) {
        System.out.println("char name: " + name);
    }

    protected ReflectTest(boolean b) {
        System.out.println("boolean name: " + b);
    }

    private ReflectTest(int index) {
        System.out.println("int index: " + index);
    }


    public ReflectTest(String name, int index) {
        System.out.println("char name: " + name + "index: : " + index);
    }

    public ReflectTest() {
        System.out.println("无参构造函数");
    }

    public static void main(String[] args) throws ClassNotFoundException {


        ReflectTest reflectTest = new ReflectTest();
        Class<? extends ReflectTest> aClass = reflectTest.getClass();
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        Class<?> aClass1 = Class.forName("demo.reflect.ReflectTest");

        System.out.println(aClass == reflectTestClass);




    }

}
