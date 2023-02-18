package annotation;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.extensions.Extension;

import java.lang.annotation.*;



@Target({ElementType.METHOD,ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Tag {

    String name();

    String description() default "";

    ExternalDocumentation externalDocs() default @ExternalDocumentation;

    Extension[] extensions() default {};

}
