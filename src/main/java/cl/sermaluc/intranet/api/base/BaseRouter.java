package cl.sermaluc.intranet.api.base;

import org.springframework.beans.factory.annotation.Value;

public class BaseRouter {
    @Value("${spring.rest.base-path}")
    protected String baseRest;
}
