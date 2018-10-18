package cl.proyecto.intranet.dao.domain.implement;

import cl.proyecto.intranet.dao.domain.interfaces.StatusDao;
import cl.proyecto.intranet.model.entity.domain.StatusEntity;
import cl.proyecto.intranet.repository.domain.StatusRepository;
import cl.proyecto.intranet.dao.base.implement.BaseDaoImpl;
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
