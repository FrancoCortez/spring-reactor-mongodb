package cl.sermaluc.intranet.validation.domain.implement;

import cl.sermaluc.intranet.model.request.domain.TypeUserRequest;
import cl.sermaluc.intranet.validation.base.ValidationUtils;
import cl.sermaluc.intranet.validation.domain.interfaces.TypeUserValidator;
import org.springframework.stereotype.Component;

/**
 * Base type user validation objects
 */
@Component
public class TypeUserValidatorImpl implements TypeUserValidator {

    /**
     * Validation request object for request type user.
     *
     * @param to object to validation logic.
     * @throws Exception errors the validation export
     */
    public void validatorRequestObject(TypeUserRequest to) throws Exception {
        StringBuilder errors = new StringBuilder();
        errors.append(
                ValidationUtils.notEmptyString
                        .and(ValidationUtils.notNullString)
                        .genericResult(to.getName())
                        .getFieldNameIfInvalid("Error el nombre del tipo de usuario no puede ser null o estar vacio")
                        .orElse("")
        );
        if (!errors.toString().isEmpty()) {
            throw new Exception(errors.toString());
        }
    }

    /**
     * Validation request id for request
     *
     * @param id id to validation
     * @throws Exception errors the validation export
     */
    public void validatorIdRequestParam(String id) throws Exception {
        StringBuilder errors = new StringBuilder();
        errors.append(
                ValidationUtils.notEmptyString
                        .and(ValidationUtils.notNullString)
                        .genericResult(id)
                        .getFieldNameIfInvalid("El id no puede ser null o estar vacio")
                        .orElse("")
        );
        if (!errors.toString().isEmpty()) {
            throw new Exception(errors.toString());
        }
    }


}
