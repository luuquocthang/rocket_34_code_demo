import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface CustomAnnotation {
    public String key = "k1";
    String value();
}
