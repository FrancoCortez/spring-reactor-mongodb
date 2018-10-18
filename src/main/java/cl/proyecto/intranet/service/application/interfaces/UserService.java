package cl.proyecto.intranet.service.application.interfaces;

import cl.proyecto.intranet.model.entity.application.UserEntity;
import cl.proyecto.intranet.service.base.interfaces.BaseService;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 *
 */
public interface UserService extends BaseService<UserEntity, String> {

    /**
     * Insert logic for type user collections.
     * Insert the one document in the collections type user.
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> insert(ServerRequest request);

    /**
     * Update logic for user collections.
     * Update the one document in the collections user.
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> update(ServerRequest request);

    /**
     * Delete logic for user collections.
     * Delete the one document in the collections user.
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> delete(ServerRequest request);

    /**
     * Delete all document the collection user.
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> deleteAll(ServerRequest request);

    /**
     * Get all document for collection user
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> findAll(ServerRequest request);

    /**
     * Get by id document for collection user
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> findById(ServerRequest request);

    /**
     * @param request
     * @return
     */
    public Mono<ServerResponse> findByUsername(ServerRequest request);

    /**
     * @param request
     * @return
     */
    public Mono<ServerResponse> findByEmail(ServerRequest request);

    /**
     * @param request
     * @return
     */
    public Mono<ServerResponse> findByUsernameAndPassword(ServerRequest request);

    /**
     * @param request
     * @return
     */
    public Mono<ServerResponse> findByUsernameOrEmail(ServerRequest request);

    /**
     * @param request
     * @return
     */
    public Mono<ServerResponse> findByUserNameOrEmailAndPassword(ServerRequest request);
}
