package cl.sermaluc.intranet.dao.base.implement;

import cl.sermaluc.intranet.dao.base.interfaces.BaseDao;
import cl.sermaluc.intranet.model.entity.base.BaseEntity;
import cl.sermaluc.intranet.utils.logger.LoggerSermaluc;
import org.reactivestreams.Publisher;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Base Dao implement repository, the generic class for entity parameters
 *
 * @param <T>  the entity class extend for BaseEntity classes. In the collection
 * @param <ID> the entity id in the collection
 */
public class BaseDaoImpl<T extends BaseEntity, ID extends String> implements BaseDao<T, ID> {

    /**
     * Instance inject for mongo repository services for operations in the db collection
     */
    private ReactiveMongoRepository<T, ID> tidReactiveMongoRepository;
    /**
     * Inject the logger in the dao
     */
    private LoggerSermaluc logger = new LoggerSermaluc(getClass());
    /**
     * Constructor for injections dependencies
     *
     * @param tidReactiveMongoRepository mongo operations dependency
     */
    public BaseDaoImpl(ReactiveMongoRepository<T, ID> tidReactiveMongoRepository) {
        this.tidReactiveMongoRepository = tidReactiveMongoRepository;
    }

    /**
     * Insert one document the T entity collection in the database
     *
     * @param entity one document for the insert in the database
     * @return the entity insert
     * @throws Exception possibility exception
     */
    public Mono<T> insert(T entity) throws Exception {
        logger.infoBegin("insert", "Data: " + entity.toString());
        logger.infoExecute("insert", "Execute insert reactive mongo repository");
        Mono<T> result = this.tidReactiveMongoRepository.insert(entity);
        logger.infoExecute("insert", "result operation: " + result.toString());
        return result;
    }

    /**
     * Insert many document the T entity collection in the database
     *
     * @param entities many document for the insert in the database
     * @return the list publisher entity insert
     * @throws Exception possibility exception
     */
    public Flux<T> insert(Publisher<T> entities) throws Exception {
        logger.infoBegin("insert", "Data: " + entities.toString());
        logger.infoExecute("insert", "Execute insert reactive mongo repository");
        return this.tidReactiveMongoRepository.insert(entities);
    }

    /**
     * Insert many document the T entity collection in the database
     *
     * @param entities many document for the insert in the database
     * @return the list iterable entity insert
     * @throws Exception possibility exception
     */
    public Flux<T> insert(Iterable<T> entities) throws Exception {
        return this.tidReactiveMongoRepository.insert(entities);
    }

    /**
     * Update one document the T entity collection in the database
     *
     * @param entity one document for the update in the database
     * @return the entity update
     * @throws Exception possibility exception
     */
    public Mono<T> update(T entity) throws Exception {
        return this.tidReactiveMongoRepository.save(entity);
    }

    /**
     * Update many document the T entity collection in the database
     *
     * @param entities many document for the update in the database
     * @return the list publisher entity update
     * @throws Exception possibility exception
     */
    public Flux<T> update(Publisher<T> entities) throws Exception {
        return this.tidReactiveMongoRepository.saveAll(entities);
    }

    /**
     * Update many document the T entity collection in the database
     *
     * @param entities many document for the update in the database
     * @return the list iterable entity update
     * @throws Exception possibility exception
     */
    public Flux<T> update(Iterable<T> entities) throws Exception {
        return this.tidReactiveMongoRepository.saveAll(entities);
    }

    /**
     * Delete one document for T entity collection in the data base
     *
     * @param entity delete one document in the database
     * @return Void asyn
     * @throws Exception possibility exception
     */
    public Mono<Void> delete(T entity) throws Exception {
        return this.tidReactiveMongoRepository.delete(entity);
    }

    /**
     * Delete one document for T entity collection in the data base
     *
     * @param id the entity delete one document in the database
     * @return Void asyn
     * @throws Exception possibility exception
     */
    public Mono<Void> deleteById(ID id) throws Exception {
        return this.tidReactiveMongoRepository.deleteById(id);
    }

    /**
     * Delete many document for T entity collection in the data base
     *
     * @param ids the entity delete many document in the database
     * @return Void asyn
     * @throws Exception possibility exception
     */
    public Mono<Void> deleteById(Publisher<ID> ids) throws Exception {
        return this.tidReactiveMongoRepository.deleteById(ids);
    }

    /**
     * Delete all document for T entity collection in the data base
     *
     * @return Void asyn
     * @throws Exception possibility exception
     */
    public Mono<Void> deleteAll() throws Exception {
        return this.tidReactiveMongoRepository.deleteAll();
    }

    /**
     * Delete all document for T entity collection in the data base
     *
     * @return Void asyn
     * @throws Exception possibility exception
     */
    public Mono<Void> deleteAll(Publisher<T> entities) throws Exception {
        return this.tidReactiveMongoRepository.deleteAll(entities);
    }

    /**
     * Delete all document for T entity collection in the data base
     *
     * @return Void asyn
     * @throws Exception possibility exception
     */
    public Mono<Void> deleteAll(Iterable<T> entities) throws Exception {
        return this.tidReactiveMongoRepository.deleteAll(entities);
    }

    /**
     * Find by id the collection T entity reference
     *
     * @param id id the entity document collection
     * @return one document for the collection
     * @throws Exception possibility exception
     */
    public Mono<T> findById(ID id) throws Exception {
        return this.tidReactiveMongoRepository.findById(id);
    }

    /**
     * Find by id the collection T entity reference
     *
     * @param ids ids the entity document collection
     * @return one document for the collection
     * @throws Exception possibility exception
     */
    public Mono<T> findById(Publisher<ID> ids) throws Exception {
        return this.tidReactiveMongoRepository.findById(ids);
    }

    /**
     * Find by all id the T entity document reference
     *
     * @param ids ids the entity collections for search documents
     * @return all result the search
     * @throws Exception possibility exceptions
     */
    public Flux<T> findAllById(Iterable<ID> ids) throws Exception {
        return this.tidReactiveMongoRepository.findAllById(ids);
    }

    /**
     * Find by all id the T entity document reference
     *
     * @param ids ids the entity collections for search documents
     * @return all result the search
     * @throws Exception possibility exceptions
     */
    public Flux<T> findAllById(Publisher<ID> ids) throws Exception {
        return this.tidReactiveMongoRepository.findAllById(ids);
    }

    /**
     * Get all document the collection in the data base type T
     *
     * @return all documents the collections
     * @throws Exception possibility exception
     */
    public Flux<T> findAll() throws Exception {
        return this.tidReactiveMongoRepository.findAll();
    }

    /**
     * Get all document the collections with filter parameter base type T
     *
     * @param filter T filter search
     * @return result search
     * @throws Exception possibility exception
     */
    public Flux<T> findAll(T filter) throws Exception {
        return this.tidReactiveMongoRepository.findAll(Example.of(filter));
    }

    /**
     * Get all document the collections with sort order parameter base
     *
     * @param sort order
     * @return all documents order by sorter
     * @throws Exception possibility exception
     */
    public Flux<T> findAll(Sort sort) throws Exception {
        return this.tidReactiveMongoRepository.findAll(sort);
    }

    /**
     * Get All document the collections with sort order and filter logic parameter
     *
     * @param filter filter for search document
     * @param sort   order
     * @return all document with sort and filter result
     * @throws Exception possibility exception
     */
    public Flux<T> findAll(T filter, Sort sort) throws Exception {
        return this.tidReactiveMongoRepository.findAll(Example.of(filter), sort);
    }
}
