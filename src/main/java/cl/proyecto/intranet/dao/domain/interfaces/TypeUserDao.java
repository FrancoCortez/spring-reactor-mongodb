package cl.proyecto.intranet.dao.domain.interfaces;

import cl.proyecto.intranet.model.entity.domain.TypeUserEntity;
import cl.proyecto.intranet.dao.base.interfaces.BaseDao;
import reactor.core.publisher.Flux;

/**
 * Type user dao interface
 */
public interface TypeUserDao extends BaseDao<TypeUserEntity, String> {

    /**
     * Find by name the type user collections in the database
     *
     * @param name search for name document attribute
     * @return result the documents the search
     * @throws Exception possibility exception
     */
    public Flux<TypeUserEntity> findByName(String name) throws Exception;
}
