package cl.sermaluc.intranet.repository.domain;

import cl.sermaluc.intranet.model.entity.domain.TypeUserEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Repository for Type User collection with reactive operation in mongodb
 */
@Repository
public interface TypeUserRepository extends ReactiveMongoRepository<TypeUserEntity, String> {

    /**
     * Find by name element the type user collection
     *
     * @param name search parameter name
     * @return result the search in the type user collection
     */
    Flux<TypeUserEntity> findByName(String name);

}
