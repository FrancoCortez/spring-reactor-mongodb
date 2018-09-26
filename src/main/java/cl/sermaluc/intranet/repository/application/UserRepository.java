package cl.sermaluc.intranet.repository.application;

import cl.sermaluc.intranet.model.entity.application.UserEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Repository for User collection with reactive operation in mongodb
 */
@Repository
public interface UserRepository extends ReactiveMongoRepository<UserEntity, String> {

    /**
     * @param username
     * @return
     */
    Mono<UserEntity> findByUsername(String username);

    /**
     * @param email
     * @return
     */
    Mono<UserEntity> findByEmail(String email);

    /**
     * @param username
     * @param password
     * @return
     */
    Mono<UserEntity> findByUsernameAndPassword(String username, String password);

    /**
     * @param username
     * @param email
     * @return
     */
    Mono<UserEntity> findByUsernameOrEmail(String username, String email);

    /**
     * @param username
     * @param email
     * @param password
     * @return
     */
    Mono<UserEntity> findByUsernameOrEmailAndPassword(String username, String email, String password);

}
