package cl.proyecto.intranet.service.domain.implement;

import cl.proyecto.intranet.service.domain.interfaces.StatusService;
import cl.proyecto.intranet.dao.domain.interfaces.StatusDao;
import cl.proyecto.intranet.model.entity.domain.StatusEntity;
import cl.proyecto.intranet.model.request.domain.StatusRequest;
import cl.proyecto.intranet.service.base.implement.BaseServiceImpl;
import cl.proyecto.intranet.validation.domain.interfaces.StatusValidator;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Type user service implementation for business logic
 */
@Service
public class StatusServiceImpl extends BaseServiceImpl<StatusEntity, String> implements StatusService {
    /**
     * Injection for dao status.
     */
    private final StatusDao statusDao;
    /**
     * Injection for validator status.
     */
    private final StatusValidator statusValidator;

    /**
     * Constructor for injection the dependencies
     *
     * @param statusDao       dao status dependency
     * @param statusValidator validator for status dependency
     */
    public StatusServiceImpl(final StatusDao statusDao, final StatusValidator statusValidator) {
        super(statusDao);
        this.statusDao = statusDao;
        this.statusValidator = statusValidator;
    }

    /**
     * Insert logic for status collections.
     * Insert the one document in the collections status.
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> insert(ServerRequest request) {
        try {
            StatusRequest requestTO = request.bodyToMono(StatusRequest.class).toProcessor().block();
            this.statusValidator.validatorRequestObject(requestTO);
            StatusEntity entity = StatusEntity.builder()
                    .name(requestTO.getName())
                    .description(requestTO.getDescription())
                    .build();
            Mono<StatusEntity> monoResponse = this.statusDao.insert(entity);
            return ServerResponse.ok().body(monoResponse, StatusEntity.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }


    /**
     * Update logic for status collections.
     * Update the one document in the collections status.
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> update(ServerRequest request) {
        try {
            String id = request.pathVariable("id");
            this.statusValidator.validatorIdRequestParam(id);
            Mono<StatusEntity> validationId = this.statusDao.findById(id);
            if (validationId == null) {
                return this.notFoundHandler("Id del objeto a modificar no existe.");
            }
            if (validationId.toProcessor().block() == null) {
                return this.notFoundHandler("Id del objeto a modificar no existe.");
            }
            Mono<StatusRequest> monoRequestTO = request.bodyToMono(StatusRequest.class);
            StatusRequest requestTO = monoRequestTO.toProcessor().block();
            this.statusValidator.validatorRequestObject(requestTO);

            StatusEntity entity = StatusEntity.builder()
                    .name(requestTO.getName())
                    .description(requestTO.getDescription())
                    .build();
            entity.set_id(id);
            Mono<StatusEntity> monoResponse = this.statusDao.update(entity);
            return ServerResponse.ok().body(monoResponse, StatusEntity.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }

    /**
     * Delete logic for type user collections.
     * Delete the one document in the collections type user.
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> delete(ServerRequest request) {
        try {
            String id = request.pathVariable("id");
            this.statusValidator.validatorIdRequestParam(id);
            Mono<StatusEntity> searchForDelete = this.statusDao.findById(id);
            StatusEntity searchForDeleteTO = searchForDelete.toProcessor().block();
            if (searchForDeleteTO == null) {
                return this.notFoundHandler("Objecto para la eliminacion no existe");
            }
            Mono<Void> response = this.statusDao.deleteById(id);
            return ServerResponse.ok().body(response, Void.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }

    /**
     * Delete all document the collection type user.
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> deleteAll(ServerRequest request) {
        try {
            Mono<Void> response = this.statusDao.deleteAll();
            return ServerResponse.ok().body(response, Void.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }

    /**
     * Get all document for collection type user
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> findAll(ServerRequest request) {
        try {
            return ServerResponse.ok().body(this.statusDao.findAll(), StatusEntity.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }

    /**
     * Get by id document for collection type user
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> findById(ServerRequest request) {
        try {
            String id = request.pathVariable("id");
            this.statusValidator.validatorIdRequestParam(id);
            return ServerResponse.ok().body(this.statusDao.findById(id), StatusEntity.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }

    /**
     * Get by name document for collection type user
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> findByName(ServerRequest request) {
        try {
            String name = request.pathVariable("name");
            this.statusValidator.validatorIdRequestParam(name);
            return ServerResponse.ok().body(this.statusDao.findByName(name), StatusEntity.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }


}
