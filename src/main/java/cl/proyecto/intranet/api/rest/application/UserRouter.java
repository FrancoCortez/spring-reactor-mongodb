package cl.proyecto.intranet.api.rest.application;

import cl.proyecto.intranet.service.application.interfaces.UserService;
import cl.proyecto.intranet.api.rest.base.BaseRouter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Base user micro services routes
 */
@Configuration
public class UserRouter extends BaseRouter {

    /**
     * Creation routes for type user
     *
     * @param userService injection bean the user service logic
     * @return bean function
     */
    @Bean(value = "user")
    public RouterFunction<ServerResponse> router(UserService userService) {
        return route(POST(baseRest + "/user").and(accept(APPLICATION_JSON)).and(contentType(APPLICATION_JSON)), userService::insert)
                .andRoute(GET(baseRest + "/user"), userService::findAll)
                .andRoute(GET(baseRest + "/user/{id}"), userService::findById)
                .andRoute(GET(baseRest + "/user/find-by-username/{username}"), userService::findByUsername)
                .andRoute(GET(baseRest + "/user/find-by-email/{email}"), userService::findByEmail)
                .andRoute(GET(baseRest + "/user/find-by-username-and-password/{username}{password}"), userService::findByUsernameAndPassword)
                .andRoute(GET(baseRest + "/user/find-by-username-or-mail/{search}"), userService::findByUsernameOrEmail)
                .andRoute(GET(baseRest + "/user/find-by-username-or-email-and-password/{search}{password}"), userService::findByUserNameOrEmailAndPassword)
                .andRoute(PUT(baseRest + "/user/{id}").and(accept(APPLICATION_JSON)).and(contentType(APPLICATION_JSON)), userService::update)
                .andRoute(DELETE(baseRest + "/user/{id}").and(accept(APPLICATION_JSON)), userService::delete)
                .andRoute(POST(baseRest + "/user/delete-all"), userService::deleteAll)
                ;
    }
}
