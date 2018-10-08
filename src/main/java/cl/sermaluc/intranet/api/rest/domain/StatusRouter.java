package cl.sermaluc.intranet.api.rest.domain;


import cl.sermaluc.intranet.api.rest.base.BaseRouter;
import cl.sermaluc.intranet.service.domain.interfaces.StatusService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Base status micro services routes
 */
@Configuration
public class StatusRouter extends BaseRouter {
    /**
     * Creation routes for status
     *
     * @param statusService injection bean the status service logic
     * @return bean function
     */
    @Bean(value = "status")
    public RouterFunction<ServerResponse> router(StatusService statusService) {
        return route(POST(baseRest + "/status").and(accept(APPLICATION_JSON)).and(contentType(APPLICATION_JSON)), statusService::insert)
                .andRoute(GET(baseRest + "/status"), statusService::findAll)
                .andRoute(GET(baseRest + "/status/{id}"), statusService::findById)
                .andRoute(GET(baseRest + "/status/find-by-name/{name}"), statusService::findByName)
                .andRoute(PUT(baseRest + "/status/{id}").and(accept(APPLICATION_JSON)).and(contentType(APPLICATION_JSON)), statusService::update)
                .andRoute(DELETE(baseRest + "/status/{id}").and(accept(APPLICATION_JSON)), statusService::delete)
                .andRoute(POST(baseRest + "/status/delete-all"), statusService::deleteAll)
                ;
    }
}
