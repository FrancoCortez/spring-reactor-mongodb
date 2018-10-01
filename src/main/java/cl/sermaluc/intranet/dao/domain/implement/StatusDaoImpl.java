package cl.sermaluc.intranet.dao.domain.implement;

import cl.sermaluc.intranet.dao.base.implement.BaseDaoImpl;
import cl.sermaluc.intranet.dao.domain.interfaces.StatusDao;
import cl.sermaluc.intranet.dao.domain.interfaces.TypeUserDao;
import cl.sermaluc.intranet.model.entity.domain.StatusEntity;
import cl.sermaluc.intranet.model.entity.domain.TypeUserEntity;
import cl.sermaluc.intranet.repository.domain.StatusRepository;
import cl.sermaluc.intranet.repository.domain.TypeUserRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/**
 * Type user implement logic dao repository
 */
@Component
public class StatusDaoImpl extends BaseDaoImpl<StatusEntity, String> implements StatusDao {

    /**
     * Type user repository inject
     */
    private final StatusRepository statusRepository;

    /**
     * Constructor for injection the dependencies
     *
     * @param statusRepository type user repository injection
     */
    public StatusDaoImpl(final StatusRepository statusRepository) {
        super(statusRepository);
        this.statusRepository = statusRepository;
    }

    /**
     * Find by name the type user collections in the database
     *
     * @param name search for name document attribute
     * @return result the documents the search
     * @throws Exception possibility exception
     */
    public Flux<StatusEntity> findByName(String name) throws Exception {
        return this.statusRepository.findByName(name);
    }
}
