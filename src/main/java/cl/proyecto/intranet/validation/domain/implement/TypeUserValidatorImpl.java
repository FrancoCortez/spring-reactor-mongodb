package cl.proyecto.intranet.validation.domain.implement;

import cl.proyecto.intranet.dao.domain.interfaces.TypeUserDao;
import cl.proyecto.intranet.model.request.domain.TypeUserRequest;
import cl.proyecto.intranet.model.request.domain.TypeUserWithIdRequest;
import cl.proyecto.intranet.validation.domain.interfaces.TypeUserValidator;
import cl.proyecto.intranet.validation.base.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Base type user validation objects
 */
@Component
public class TypeUserValidatorImpl implements TypeUserValidator {
    /**
     *
     */
    private final TypeUserDao typeUserDao;

    /**
     * @param typeUserDao
     */
    @Autowired
    public TypeUserValidatorImpl(final TypeUserDao typeUserDao) {
        this.typeUserDao = typeUserDao;
    }

    /**
     * Validation request object for request type user.
     *
     * @param to object to validation logic.
     * @throws Exception errors the validation export
     */
    public void validatorRequestObject(TypeUserRequest to) throws Exception {

        StringBuilder errors = new StringBuilder();
        errors.append(
                ValidationUtils.notNullString
                        .and(ValidationUtils.notEmptyString)
                        .genericResult(to.getName())
                        .getFieldNameIfInvalid("Error el nombre del tipo de usuario no puede ser null o estar vacio")
                        .orElse("")
        );
        if (!errors.toString().isEmpty()) {
            throw new Exception(errors.toString());
        }
    }

    /**
     * @param to
     * @throws Exception
     */
    public void validatorRequestWithIdObject(TypeUserWithIdRequest to) throws Exception {
        StringBuilder errors = new StringBuilder();
        errors.append(
                ValidationUtils.notNullString
                        .and(ValidationUtils.notEmptyString)
                        .genericResult(to.getName())
                        .getFieldNameIfInvalid("El nombre del tipo de usuario no puede ser null o estar vacio")
                        .orElse("")
        );
        errors.append(
                ValidationUtils.notNullString
                        .and(ValidationUtils.notEmptyString)
                        .genericResult(to.get_id())
                        .getFieldNameIfInvalid("El id no puede ser null o estar vacio")
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
            Optional<Boolean> isExists = this.typeUserDao.existsById(id).toProcessor().blockOptional();
            if (!isExists.isPresent())
                errors.append("El objeto tipo de usuario no existe en la base de datos.");
            else {
                if (!isExists.get()) {
                    errors.append("El objeto tipo de usuario no existe en la base de datos.");
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
