package cl.proyecto.intranet.dao.domain.implement;

import cl.proyecto.intranet.dao.domain.interfaces.TypeUserDao;
import cl.proyecto.intranet.model.entity.domain.TypeUserEntity;
import cl.proyecto.intranet.repository.domain.TypeUserRepository;
import cl.proyecto.intranet.dao.base.implement.BaseDaoImpl;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/**
 * Type user implement logic dao repository
 */
@Component
public class TypeUserDaoImpl extends BaseDaoImpl<TypeUserEntity, String> implements TypeUserDao {

    /**
     * Type user repository inject
     */
    private final TypeUserRepository typeUserRepository;

    /**
     * Constructor for injection the dependencies
     *
     * @param typeUserRepository type user repository injection
     */
    public TypeUserDaoImpl(TypeUserRepository typeUserRepository) {
        super(typeUserRepository);
        this.typeUserRepository = typeUserRepository;
    }

    /**
     * Find by name the type user collections in the database
     *
     * @param name search for name document attribute
     * @return result the documents the search
     * @throws Exception possibility exception
     */
    public Flux<TypeUserEntity> findByName(String name) throws Exception {
        return this.typeUserRepository.findByName(name);
    }
}
