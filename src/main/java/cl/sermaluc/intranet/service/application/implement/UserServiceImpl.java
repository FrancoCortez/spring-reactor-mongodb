package cl.sermaluc.intranet.service.application.implement;

import cl.sermaluc.intranet.dao.application.interfaces.UserDao;
import cl.sermaluc.intranet.model.entity.application.UserEntity;
import cl.sermaluc.intranet.model.entity.domain.TypeUserEntity;
import cl.sermaluc.intranet.model.request.application.UserRequest;
import cl.sermaluc.intranet.service.application.interfaces.UserService;
import cl.sermaluc.intranet.service.base.implement.BaseServiceImpl;
import cl.sermaluc.intranet.validation.application.interfaces.UserValidator;
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
    private final UserValidator userValidator;

    /**
     * @param userDao
     * @param typeUserValidator
     * @param userValidator
     */
    public UserServiceImpl(final UserDao userDao, final TypeUserValidator typeUserValidator, final UserValidator userValidator) {
        super(userDao);
        this.userDao = userDao;
        this.typeUserValidator = typeUserValidator;
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
            Mono<UserEntity> monoResponse = this.userDao.insert(userEntity);
            return ServerResponse.ok().body(monoResponse, UserEntity.class);
        } catch (Exception ex) {
            return this.errorHandler(ex);
        }
    }
}
