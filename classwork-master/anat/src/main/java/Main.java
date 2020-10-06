import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Field[] fields = Test.class.getDeclaredFields();

        for(int i =0; i<fields.length; i++) {
            Field field = fields[i];
           boolean f = field.isAnnotationPresent(Annotation.class);
           if (f) {
               System.out.println("Field " + field.getName() + " is smell " + "author: " + field.getAnnotation(Annotation.class).author());
           }

        }

        Method[] methods = Test2.class.getDeclaredMethods();

        for (int i =0; i<methods.length;i++) {
            Method method = methods[i];
            boolean m = method.isAnnotationPresent(RunMe.class);
            if(m) {
                method.invoke(new Test2());
            }
        }

    }
}
