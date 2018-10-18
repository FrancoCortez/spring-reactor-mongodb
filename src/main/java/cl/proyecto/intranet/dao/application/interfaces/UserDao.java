package cl.proyecto.intranet.dao.application.interfaces;

import cl.proyecto.intranet.model.entity.application.UserEntity;
import cl.proyecto.intranet.dao.base.interfaces.BaseDao;
import reactor.core.publisher.Mono;

/**
 *
 */
public interface UserDao extends BaseDao<UserEntity, String> {

    /**
     * @param name
     * @return
     */
    Mono<UserEntity> findByUsername(String name);

    /**
     * @param email
     * @return
     */
    Mono<UserEntity> findByEmail(String email);

    /**
     * @param usernameOrEmail
     * @param password
     * @return
     */
    Mono<UserEntity> findByUserNameOrEmailAndPassword(String usernameOrEmail, String password);

    /**
     * @param name
     * @param password
     * @return
     */
    Mono<UserEntity> findByUsernameAndPassword(String name, String password);

    /**
     * @param usernameOrEmail
     * @return
     */
    Mono<UserEntity> findByUsernameOrEmail(String usernameOrEmail);
}
