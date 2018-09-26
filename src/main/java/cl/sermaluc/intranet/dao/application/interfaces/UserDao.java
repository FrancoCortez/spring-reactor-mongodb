package cl.sermaluc.intranet.dao.application.interfaces;

import cl.sermaluc.intranet.dao.base.interfaces.BaseDao;
import cl.sermaluc.intranet.model.entity.application.UserEntity;
import reactor.core.publisher.Mono;

/**
 *
 */
public interface UserDao extends BaseDao<UserEntity, String> {

    /**
     *
     * @param name
     * @return
     */
    Mono<UserEntity> findByUsername(String name);
    /**
     *
     * @param email
     * @return
     */
    Mono<UserEntity> findByEmail(String email);

    /**
     *
     * @param usernameOrEmail
     * @param password
     * @return
     */
    Mono<UserEntity> findByUserNameOrEmailAndPassword(String usernameOrEmail, String password);

    /**
     *
     * @param name
     * @param password
     * @return
     */
    Mono<UserEntity> findByUsernameAndPassword(String name, String password);

    /**
     *
     * @param usernameOrEmail
     * @return
     */
    Mono<UserEntity> findByUsernameOrEmail(String usernameOrEmail);
}
