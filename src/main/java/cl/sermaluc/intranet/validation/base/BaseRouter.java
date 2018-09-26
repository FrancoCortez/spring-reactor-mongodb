package cl.sermaluc.intranet.validation.base;

import org.springframework.beans.factory.annotation.Value;

public class BaseRouter {
    @Value("${spring.rest.base-path}")
    protected String baseRest;
}
