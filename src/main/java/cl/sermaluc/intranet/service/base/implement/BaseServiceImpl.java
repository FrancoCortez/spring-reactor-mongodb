package cl.sermaluc.intranet.service.base.implement;

import cl.sermaluc.intranet.dao.base.interfaces.BaseDao;
import cl.sermaluc.intranet.model.entity.base.BaseEntity;
import cl.sermaluc.intranet.model.response.utils.ErrorHandlerResponse;
import cl.sermaluc.intranet.service.base.interfaces.BaseService;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Base service implementation
 *
 * @param <T>  t entity class
 * @param <ID> id the entity class
 */
public class BaseServiceImpl<T extends BaseEntity, ID extends String> implements BaseService<T, ID> {
    /**
     * Base injection dao
     */
    private BaseDao<T, ID> tidBaseDao;

    /**
     * Constructor base for injections dependencies
     *
     * @param tidBaseDao base dao injection
     */
    public BaseServiceImpl(BaseDao<T, ID> tidBaseDao) {
        this.tidBaseDao = tidBaseDao;
    }

    protected Mono<ServerResponse> errorHandler(Exception ex) {
        ErrorHandlerResponse response = ErrorHandlerResponse.builder()
                .msg(ex.getMessage())
                .trace(ex.getStackTrace())
                .cause(ex.getCause())
                .build();
        return ServerResponse.badRequest().body(Mono.just(response), ErrorHandlerResponse.class);
    }

    protected Mono<ServerResponse> errorHandler(String msg){
        ErrorHandlerResponse response = ErrorHandlerResponse.builder()
                .msg(msg)
                .build();
        return ServerResponse.badRequest().body(Mono.just(response),ErrorHandlerResponse.class);
    }

    protected Mono<ServerResponse> warnnigHandler(String msg){
        ErrorHandlerResponse response = ErrorHandlerResponse.builder()
                .msg(msg)
                .build();
        return ServerResponse.status(409).body(Mono.just(response),ErrorHandlerResponse.class);
    }

    protected Mono<ServerResponse> notFoundHandler(String msg){
        ErrorHandlerResponse response = ErrorHandlerResponse.builder()
                .msg(msg)
                .build();
        return ServerResponse.status(404).body(Mono.just(response),ErrorHandlerResponse.class);
    }
}
