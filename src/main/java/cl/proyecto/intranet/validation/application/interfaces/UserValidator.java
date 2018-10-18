package cl.proyecto.intranet.validation.application.interfaces;

import cl.proyecto.intranet.model.request.application.UserRequest;

public interface UserValidator {

    /**
     * @param to
     * @throws Exception
     */
    public void validatorRequestObject(UserRequest to) throws Exception;

    /**
     * Validation request id for request
     *
     * @param id id to validation
     * @throws Exception errors the validation export
     */
    public void validatorIdRequestParam(String id) throws Exception;

    /**
     * @param id
     * @throws Exception
     */
    public void validatorExistForId(String id) throws Exception;
}
