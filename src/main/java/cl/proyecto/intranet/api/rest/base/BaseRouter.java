package cl.proyecto.intranet.api.rest.base;

import org.springframework.beans.factory.annotation.Value;

public class BaseRouter {
    @Value("${spring.rest.base-path}")
    protected String baseRest;
}
