package loc.mark52.managermoney.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = UserValidator.class)
public @interface UserDuplicate {
    String message() default "Duplicate user.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
