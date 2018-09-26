package cl.sermaluc.intranet.validation.application.implement;

import cl.sermaluc.intranet.model.request.application.UserRequest;
import cl.sermaluc.intranet.validation.application.interfaces.UserValidator;
import cl.sermaluc.intranet.validation.base.ValidationUtils;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class UserValidatorImpl implements UserValidator {

    /**
     *
     * @param to
     * @throws Exception
     */
    public void validatorRequestObject(UserRequest to) throws Exception{
        StringBuilder errors = new StringBuilder();
        errors.append(
                ValidationUtils.objectNotNull
                        .genericResult(to.getTypeUserWithIdRequest())
                        .getFieldNameIfInvalid("El tipo de usuario no puede ser null")
                        .orElse("")
        );
        errors.append(
                ValidationUtils.notEmptyString
                        .and(ValidationUtils.notNullString)
                        .genericResult(to.getUsername())
                        .getFieldNameIfInvalid("El nombre de usuario no puede ser null o estar vacio")
                        .orElse("")
        );

        errors.append(
                ValidationUtils.notEmptyString
                        .and(ValidationUtils.notNullString)
                        .genericResult(to.getPassword())
                        .getFieldNameIfInvalid("La contraceña no puede ser vacia o null")
                        .orElse("")
        );

        errors.append(
                ValidationUtils.notEmptyString
                        .and(ValidationUtils.notNullString)
                        .genericResult(to.getEmail())
                        .getFieldNameIfInvalid("El correo no puede ser vacio o null")
                        .orElse("")
        );
        if (!errors.toString().isEmpty()) {
            throw new Exception(errors.toString());
        }
    }

}
