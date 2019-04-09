package loc.mark52.managermoney.validator;

import loc.mark52.managermoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UserValidator implements ConstraintValidator<UserDuplicate, String> {
    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return userService == null || userService.findByEmail(email) == null;
    }
}
