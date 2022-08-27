import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Apple;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-25
 */
public class Application {

    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Apple apple = context.getBean("sweetApple", Apple.class);

        System.out.println(apple);



    }

}
