package cl.sermaluc.intranet.validation.application.interfaces;

import cl.sermaluc.intranet.model.request.application.UserRequest;

public interface UserValidator {

    /**
     *
     * @param to
     * @throws Exception
     */
    public void validatorRequestObject(UserRequest to) throws Exception;
}
