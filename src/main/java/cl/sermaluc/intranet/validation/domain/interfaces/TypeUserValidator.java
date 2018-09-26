package cl.sermaluc.intranet.validation.domain.interfaces;

import cl.sermaluc.intranet.model.request.domain.TypeUserRequest;
import cl.sermaluc.intranet.model.request.domain.TypeUserWithIdRequest;

/**
 * Base validation interface.
 */
public interface TypeUserValidator {

    /**
     * Validation request object for request type user.
     *
     * @param to object to validation logic.
     * @throws Exception errors the validation export
     */
    public void validatorRequestObject(TypeUserRequest to) throws Exception;

    /**
     * @param to
     * @throws Exception
     */
    public void validatorRequestWithIdObject(TypeUserWithIdRequest to) throws Exception;

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
