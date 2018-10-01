package cl.sermaluc.intranet.api.rest.domain;


import cl.sermaluc.intranet.api.rest.base.BaseRouter;
import cl.sermaluc.intranet.service.domain.interfaces.TypeUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Base type user micro services routes
 */
@Configuration
public class TypeUserRouter extends BaseRouter {
    /**
     * Creation routes for type user
     *
     * @param typeUserService injection bean the type user service logic
     * @return bean function
     */
    @Bean(value = "type-user")
    public RouterFunction<ServerResponse> router(TypeUserService typeUserService) {
        return route(POST(baseRest + "/type-user").and(accept(APPLICATION_JSON)).and(contentType(APPLICATION_JSON)), typeUserService::insert)
                .andRoute(GET(baseRest + "/type-user"), typeUserService::findAll)
                .andRoute(GET(baseRest + "/type-user/{id}"), typeUserService::findById)
                .andRoute(GET(baseRest + "/type-user/find-by-name/{name}"), typeUserService::findByName)
                .andRoute(PUT(baseRest + "/type-user/{id}").and(accept(APPLICATION_JSON)).and(contentType(APPLICATION_JSON)), typeUserService::update)
                .andRoute(DELETE(baseRest + "/type-user/{id}").and(accept(APPLICATION_JSON)), typeUserService::delete)
                .andRoute(POST(baseRest + "/type-user/delete-all"), typeUserService::deleteAll)
                ;
    }
}
