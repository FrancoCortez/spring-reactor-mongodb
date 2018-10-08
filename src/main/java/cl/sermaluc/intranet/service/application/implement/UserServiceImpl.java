package cl.sermaluc.intranet.service.application.implement;

import cl.sermaluc.intranet.dao.application.interfaces.UserDao;
import cl.sermaluc.intranet.model.entity.application.UserEntity;
import cl.sermaluc.intranet.model.entity.domain.StatusEntity;
import cl.sermaluc.intranet.model.entity.domain.TypeUserEntity;
import cl.sermaluc.intranet.model.request.application.UserRequest;
import cl.sermaluc.intranet.service.application.interfaces.UserService;
import cl.sermaluc.intranet.service.base.implement.BaseServiceImpl;
import cl.sermaluc.intranet.validation.application.interfaces.UserValidator;
import cl.sermaluc.intranet.validation.domain.interfaces.StatusValidator;
import cl.sermaluc.intranet.validation.domain.interfaces.TypeUserValidator;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 *
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity, String> implements UserService {
    /**
     *
     */
    private final UserDao userDao;
    private final TypeUserValidator typeUserValidator;
    private final StatusValidator statusValidator;
    private final UserValidator userValidator;

    /**
     * @param userDao
     * @param typeUserValidator
     * @param statusValidator
     * @param userValidator
     */
    public UserServiceImpl(final UserDao userDao, final TypeUserValidator typeUserValidator, StatusValidator statusValidator, final UserValidator userValidator) {
        super(userDao);
        this.userDao = userDao;
        this.typeUserValidator = typeUserValidator;
        this.statusValidator = statusValidator;
        this.userValidator = userValidator;
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
            Mono<UserRequest> monoRequestTO = request.bodyToMono(UserRequest.class);
            UserRequest requestTO = monoRequestTO.toProcessor().block();
            this.userValidator.validatorRequestObject(requestTO);
            this.typeUserValidator.validatorRequestWithIdObject(requestTO.getTypeUserWithIdRequest());
            this.typeUserValidator.validatorExistForId(requestTO.getTypeUserWithIdRequest().get_id());

            this.statusValidator.validatorRequestWithIdObject(requestTO.getStatusWithIdRequest());
            this.statusValidator.validatorExistForId(requestTO.getStatusWithIdRequest().get_id());

            //Create type user.
            TypeUserEntity typeUserEntity = TypeUserEntity.builder()
                    .name(requestTO.getTypeUserWithIdRequest().getName())
                    .description(requestTO.getTypeUserWithIdRequest().getDescription())
                    .build();
            typeUserEntity.set_id(requestTO.getTypeUserWithIdRequest().get_id());

            //Create status.
            StatusEntity statusEntity = StatusEntity.builder()
                    .name(requestTO.getStatusWithIdRequest().getName())
                    .description(requestTO.getStatusWithIdRequest().getDescription())
                    .build();
            statusEntity.set_id(requestTO.getStatusWithIdRequest().get_id());

            //Create User
            UserEntity userEntity = UserEntity.builder()
                    .username(requestTO.getUsername())
                    .password(requestTO.getPassword())
                    .email(requestTO.getEmail())
                    .typeUser(typeUserEntity)
                    .statusEntity(statusEntity)
                    .build();
            Mono<UserEntity> monoResponse = this.userDao.insert(userEntity);
            return ServerResponse.ok().body(monoResponse, UserEntity.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }

    /**
     * Update logic for user collections.
     * Update the one document in the collections user.
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> update(ServerRequest request) {
        try {
            String id = request.pathVariable("id");
            this.userValidator.validatorIdRequestParam(id);
            this.userValidator.validatorExistForId(id);
            UserRequest requestTO = request.bodyToMono(UserRequest.class).toProcessor().block();
            this.userValidator.validatorRequestObject(requestTO);
            this.typeUserValidator.validatorRequestWithIdObject(requestTO.getTypeUserWithIdRequest());
            this.typeUserValidator.validatorExistForId(requestTO.getTypeUserWithIdRequest().get_id());

            TypeUserEntity typeUserEntity = TypeUserEntity.builder()
                    .name(requestTO.getTypeUserWithIdRequest().getName())
                    .description(requestTO.getTypeUserWithIdRequest().getDescription())
                    .build();
            typeUserEntity.set_id(requestTO.getTypeUserWithIdRequest().get_id());

            UserEntity userEntity = UserEntity.builder()
                    .username(requestTO.getUsername())
                    .password(requestTO.getPassword())
                    .email(requestTO.getEmail())
                    .typeUser(typeUserEntity)
                    .build();
            userEntity.set_id(id);

            Mono<UserEntity> monoResponse = this.userDao.update(userEntity);
            return ServerResponse.ok().body(monoResponse, UserEntity.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }

    /**
     * Delete logic for user collections.
     * Delete the one document in the collections user.
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> delete(ServerRequest request) {
        try {
            String id = request.pathVariable("id");
            this.userValidator.validatorIdRequestParam(id);
            Mono<UserEntity> searchForDelete = this.userDao.findById(id);
            UserEntity searchForDeleteTO = searchForDelete.toProcessor().block();
            if (searchForDeleteTO == null) {
                return this.notFoundHandler("Objecto para la eliminacion no existe");
            }
            Mono<Void> response = this.userDao.deleteById(id);
            return ServerResponse.ok().body(response, Void.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }

    /**
     * Delete all document the collection user.
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> deleteAll(ServerRequest request) {
        try {
            Mono<Void> response = this.userDao.deleteAll();
            return ServerResponse.ok().body(response, Void.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }

    /**
     * Get all document for collection user
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> findAll(ServerRequest request) {
        try {
            return ServerResponse.ok().body(this.userDao.findAll(), UserEntity.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }

    /**
     * Get by id document for collection user
     *
     * @param request request the server petition
     * @return response the server to client
     */
    public Mono<ServerResponse> findById(ServerRequest request) {
        try {
            String id = request.pathVariable("id");
            this.userValidator.validatorIdRequestParam(id);
            return ServerResponse.ok().body(this.userDao.findById(id), UserEntity.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }

    /**
     * @param request
     * @return
     */
    public Mono<ServerResponse> findByUsername(ServerRequest request) {
        try {
            String name = request.pathVariable("username");
            this.userValidator.validatorIdRequestParam(name);
            return ServerResponse.ok().body(this.userDao.findByUsername(name), UserEntity.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }

    /**
     * @param request
     * @return
     */
    public Mono<ServerResponse> findByEmail(ServerRequest request) {
        try {
            String email = request.pathVariable("email");
            this.userValidator.validatorIdRequestParam(email);
            return ServerResponse.ok().body(this.userDao.findByEmail(email), UserEntity.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }

    /**
     * @param request
     * @return
     */
    public Mono<ServerResponse> findByUsernameAndPassword(ServerRequest request) {
        try {
            String username = request.pathVariable("username");
            String password = request.pathVariable("password");
            this.userValidator.validatorIdRequestParam(username);
            this.userValidator.validatorIdRequestParam(password);
            return ServerResponse.ok().body(this.userDao.findByUsernameAndPassword(username, password), UserEntity.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }

    /**
     * @param request
     * @return
     */
    public Mono<ServerResponse> findByUsernameOrEmail(ServerRequest request) {
        try {
            String search = request.pathVariable("search");
            this.userValidator.validatorIdRequestParam(search);
            return ServerResponse.ok().body(this.userDao.findByUsernameOrEmail(search), UserEntity.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }

    /**
     * @param request
     * @return
     */
    public Mono<ServerResponse> findByUserNameOrEmailAndPassword(ServerRequest request) {
        try {
            String search = request.pathVariable("search");
            String password = request.pathVariable("password");
            this.userValidator.validatorIdRequestParam(search);
            return ServerResponse.ok().body(this.userDao.findByUserNameOrEmailAndPassword(search, password), UserEntity.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }
}
