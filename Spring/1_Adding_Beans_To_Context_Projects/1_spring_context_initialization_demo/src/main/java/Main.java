import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args){
        System.out.println("In this project we'll be initializing the spring application context and \nwe'll add some beans into it.");

        AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext(ConfigFile.class);
        Player p = context.getBean("dhino",Player.class);
        String str = context.getBean(String.class);
        int num = context.getBean(int.class);

        System.out.println(str);
        System.out.println(num);
        System.out.println(p.getPlayerName());
        System.out.println(p.getSportName());

        Class<?> playerClassMetaData = p.getClass();
        Method[] pMethods = playerClassMetaData.getDeclaredMethods();
        Field[] pFields = playerClassMetaData.getDeclaredFields();

        System.out.println("Class name : "+p.getClass().getName());
        for(Field element : pFields) {
            System.out.println("Field : " + element);
        }
        for(Method element : pMethods) {
            System.out.println("Method : " + element);
        }
    }
}
