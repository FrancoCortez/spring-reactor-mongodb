package cl.sermaluc.intranet.validation.application.implement;

import cl.sermaluc.intranet.dao.application.interfaces.UserDao;
import cl.sermaluc.intranet.model.request.application.UserRequest;
import cl.sermaluc.intranet.validation.application.interfaces.UserValidator;
import cl.sermaluc.intranet.validation.base.ValidationUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 *
 */
@Component
public class UserValidatorImpl implements UserValidator {

    /**
     *
     */
    private final UserDao userDao;

    /**
     * @param userDao
     */
    public UserValidatorImpl(final UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * @param to
     * @throws Exception
     */
    public void validatorRequestObject(UserRequest to) throws Exception {
        StringBuilder errors = new StringBuilder();
        errors.append(
                ValidationUtils.objectNotNull
                        .genericResult(to.getTypeUserWithIdRequest())
                        .getFieldNameIfInvalid("El tipo de usuario no puede ser null")
                        .orElse("")
        );
        errors.append(
                ValidationUtils.notNullString
                        .and(ValidationUtils.notEmptyString)
                        .genericResult(to.getUsername())
                        .getFieldNameIfInvalid("El nombre de usuario no puede ser null o estar vacio")
                        .orElse("")
        );

        errors.append(
                ValidationUtils.notNullString
                        .and(ValidationUtils.notEmptyString)
                        .genericResult(to.getPassword())
                        .getFieldNameIfInvalid("La contraceña no puede ser vacia o null")
                        .orElse("")
        );

        errors.append(
                ValidationUtils.notNullString
                        .and(ValidationUtils.notEmptyString)
                        .genericResult(to.getEmail())
                        .getFieldNameIfInvalid("El correo no puede ser vacio o null")
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
                ValidationUtils.notNullString
                        .and(ValidationUtils.notEmptyString)
                        .genericResult(id)
                        .getFieldNameIfInvalid("El id no puede ser null o estar vacio")
                        .orElse("")
        );
        if (!errors.toString().isEmpty()) {
            throw new Exception(errors.toString());
        }
    }

    /**
     * @param id
     * @throws Exception
     */
    public void validatorExistForId(String id) throws Exception {
        StringBuilder errors = new StringBuilder();
        try {
            Optional<Boolean> isExists = this.userDao.existsById(id).toProcessor().blockOptional();
            if (!isExists.isPresent())
                errors.append("El objeto usuario no existe en la base de datos.");
            else {
                if (!isExists.get()) {
                    errors.append("El objeto usuario no existe en la base de datos.");
                }
            }
        } catch (Exception ex) {
            errors.append("A ocurrido un error al buscar el id.");
        }
        if (!errors.toString().isEmpty()) {
            throw new Exception(errors.toString());
        }
    }

}
