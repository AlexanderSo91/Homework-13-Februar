package annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited

public @interface Operation {
    String method() default "";

    String summary();
}
