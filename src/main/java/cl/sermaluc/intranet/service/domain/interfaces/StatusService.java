package cl.sermaluc.intranet.service.domain.interfaces;

import cl.sermaluc.intranet.model.entity.domain.StatusEntity;
import cl.sermaluc.intranet.model.entity.domain.TypeUserEntity;
import cl.sermaluc.intranet.service.base.interfaces.BaseService;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface StatusService extends BaseService<StatusEntity, String> {
    /**
     * Insert logic for type user collections.
     * Insert the one document in the collections type user.
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> insert(ServerRequest request);

    /**
     * Update logic for type user collections.
     * Update the one document in the collections type user.
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> update(ServerRequest request);

    /**
     * Delete logic for type user collections.
     * Delete the one document in the collections type user.
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> delete(ServerRequest request);

    /**
     * Delete all document the collection type user.
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> deleteAll(ServerRequest request);

    /**
     * Get all document for collection type user
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> findAll(ServerRequest request);

    /**
     * Get by id document for collection type user
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> findById(ServerRequest request);

    /**
     * Get by id document for collection type user
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> findByName(ServerRequest request);
}
