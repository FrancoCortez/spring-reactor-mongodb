package cl.proyecto.intranet.dao.application.implement;

import cl.proyecto.intranet.dao.application.interfaces.UserDao;
import cl.proyecto.intranet.model.entity.application.UserEntity;
import cl.proyecto.intranet.repository.application.UserRepository;
import cl.proyecto.intranet.dao.base.implement.BaseDaoImpl;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 *
 */
@Component
public class UserDaoImpl extends BaseDaoImpl<UserEntity, String> implements UserDao {

    /**
     *
     */
    private final UserRepository userRepository;

    /**
     * @param userRepository
     */
    public UserDaoImpl(final UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    /**
     * @param name
     * @return
     */
    public Mono<UserEntity> findByUsername(String name) {
        return this.userRepository.findByUsername(name);
    }

    /**
     * @param email
     * @return
     */
    public Mono<UserEntity> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    /**
     * @param usernameOrEmail
     * @param password
     * @return
     */
    public Mono<UserEntity> findByUserNameOrEmailAndPassword(String usernameOrEmail, String password) {
        return this.userRepository.findByUsernameOrEmailAndPassword(usernameOrEmail, usernameOrEmail, password);
    }

    /**
     * @param name
     * @param password
     * @return
     */
    public Mono<UserEntity> findByUsernameAndPassword(String name, String password) {
        return this.userRepository.findByUsernameAndPassword(name, password);
    }

    /**
     * @param usernameOrEmail
     * @return
     */
    public Mono<UserEntity> findByUsernameOrEmail(String usernameOrEmail) {
        return this.userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
    }

}
