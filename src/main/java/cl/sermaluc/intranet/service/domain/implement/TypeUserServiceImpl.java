package cl.sermaluc.intranet.service.domain.implement;

import cl.sermaluc.intranet.dao.domain.interfaces.TypeUserDao;
import cl.sermaluc.intranet.model.entity.domain.TypeUserEntity;
import cl.sermaluc.intranet.model.request.domain.TypeUserRequest;
import cl.sermaluc.intranet.service.base.implement.BaseServiceImpl;
import cl.sermaluc.intranet.service.domain.interfaces.TypeUserService;
import cl.sermaluc.intranet.validation.domain.interfaces.TypeUserValidator;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Type user service implementation for business logic
 */
@Service
public class TypeUserServiceImpl extends BaseServiceImpl<TypeUserEntity, String> implements TypeUserService {
    /**
     * Injection for dao type user.
     */
    private final TypeUserDao typeUserDao;
    /**
     * Injection for validator type user.
     */
    private final TypeUserValidator typeUserValidator;

    /**
     * Constructor for injection the dependencies
     *
     * @param typeUserDao       dao type user dependency
     * @param typeUserValidator validator for type user dependency
     */
    public TypeUserServiceImpl(final TypeUserDao typeUserDao, final TypeUserValidator typeUserValidator) {
        super(typeUserDao);
        this.typeUserDao = typeUserDao;
        this.typeUserValidator = typeUserValidator;
    }

    /**
     * Insert logic for type user collections.
     * Insert the one document in the collections type user.
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> insert(ServerRequest request) {
        try {
            Mono<TypeUserRequest> monoRequestTO = request.bodyToMono(TypeUserRequest.class);
            TypeUserRequest requestTO = monoRequestTO.toProcessor().block();
            this.typeUserValidator.validatorRequestObject(requestTO);
            TypeUserEntity entity = TypeUserEntity.builder()
                    .name(requestTO.getName())
                    .description(requestTO.getDescription())
                    .build();
            Mono<TypeUserEntity> monoResponse = this.typeUserDao.insert(entity);
            return ServerResponse.ok().body(monoResponse, TypeUserEntity.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }


    /**
     * Update logic for type user collections.
     * Update the one document in the collections type user.
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> update(ServerRequest request){
        try {
            String id = request.pathVariable("id");
            this.typeUserValidator.validatorIdRequestParam(id);
            Mono<TypeUserEntity> validationId = this.typeUserDao.findById(id);
            if(validationId == null){
                return this.notFoundHandler("Id del objeto a modificar no existe.");
            }
            if(validationId.toProcessor().block() == null){
                return this.notFoundHandler("Id del objeto a modificar no existe.");
            }
            Thread.sleep(10000);
            Mono<TypeUserRequest> monoRequestTO = request.bodyToMono(TypeUserRequest.class);
            TypeUserRequest requestTO = monoRequestTO.toProcessor().block();
            this.typeUserValidator.validatorRequestObject(requestTO);

            TypeUserEntity entity = TypeUserEntity.builder()
                    .name(requestTO.getName())
                    .description(requestTO.getDescription())
                    .build();
            entity.set_id(id);
            Mono<TypeUserEntity> monoResponse = this.typeUserDao.update(entity);
            return ServerResponse.ok().body(monoResponse, TypeUserEntity.class);
        }catch (Exception ex){
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
    public Mono<ServerResponse> delete(ServerRequest request){
        try {
            String id = request.pathVariable("id");
            this.typeUserValidator.validatorIdRequestParam(id);
            Mono<TypeUserEntity> searchForDelete = this.typeUserDao.findById(id);
            TypeUserEntity searchForDeleteTO = searchForDelete.toProcessor().block();
            if(searchForDeleteTO == null){
                return this.notFoundHandler("Objecto para la eliminacion no existe");
            }
            Mono<Void> response = this.typeUserDao.deleteById(id);
            return ServerResponse.ok().body(response, Void.class);
        }catch (Exception ex){
            return this.errorHandler(ex);
        }
    }

    /**
     * Delete all document the collection type user.
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> deleteAll(ServerRequest request){
        try {
            Mono<Void> response = this.typeUserDao.deleteAll();
            return ServerResponse.ok().body(response, Void.class);
        }catch (Exception ex){
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
            Thread.sleep(1000);
            return ServerResponse.ok().body(this.typeUserDao.findAll(), TypeUserEntity.class);
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
            this.typeUserValidator.validatorIdRequestParam(id);
            return ServerResponse.ok().body(this.typeUserDao.findById(id), TypeUserEntity.class);
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

            this.typeUserValidator.validatorIdRequestParam(name);
            return ServerResponse.ok().body(this.typeUserDao.findByName(name), TypeUserEntity.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }

}
