package cl.proyecto.intranet.repository.domain;

import cl.proyecto.intranet.model.entity.domain.StatusEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 *
 */
@Repository
public interface StatusRepository extends ReactiveMongoRepository<StatusEntity, String> {

    /**
     * @param name
     * @return
     */
    Flux<StatusEntity> findByName(String name);
}
