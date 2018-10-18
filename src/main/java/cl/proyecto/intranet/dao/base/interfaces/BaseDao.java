package cl.proyecto.intranet.dao.base.interfaces;

import cl.proyecto.intranet.model.entity.base.BaseEntity;
import org.reactivestreams.Publisher;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Base Dao interface repository, the generic class for entity parameters
 *
 * @param <T>  the entity class extend for BaseEntity classes. In the collection
 * @param <ID> the entity id in the collection
 */
public interface BaseDao<T extends BaseEntity, ID extends String> {

    /**
     * Insert one document the T entity collection in the database
     *
     * @param entity one document for the insert in the database
     * @return the entity insert
     * @throws Exception possibility exception
     */
    public Mono<T> insert(T entity) throws Exception;

    /**
     * Insert many document the T entity collection in the database
     *
     * @param entities many document for the insert in the database
     * @return the list publisher entity insert
     * @throws Exception possibility exception
     */
    public Flux<T> insert(Publisher<T> entities) throws Exception;

    /**
     * Insert many document the T entity collection in the database
     *
     * @param entities many document for the insert in the database
     * @return the list iterable entity insert
     * @throws Exception possibility exception
     */
    public Flux<T> insert(Iterable<T> entities) throws Exception;

    /**
     * Update one document the T entity collection in the database
     *
     * @param entity one document for the update in the database
     * @return the entity update
     * @throws Exception possibility exception
     */
    public Mono<T> update(T entity) throws Exception;

    /**
     * Update many document the T entity collection in the database
     *
     * @param entities many document for the update in the database
     * @return the list publisher entity update
     * @throws Exception possibility exception
     */
    public Flux<T> update(Publisher<T> entities) throws Exception;

    /**
     * Update many document the T entity collection in the database
     *
     * @param entities many document for the update in the database
     * @return the list iterable entity update
     * @throws Exception possibility exception
     */
    public Flux<T> update(Iterable<T> entities) throws Exception;

    /**
     * Delete one document for T entity collection in the data base
     *
     * @param entity delete one document in the database
     * @return Void asyn
     * @throws Exception possibility exception
     */
    public Mono<Void> delete(T entity) throws Exception;

    /**
     * Delete one document for T entity collection in the data base
     *
     * @param id the entity delete one document in the database
     * @return Void asyn
     * @throws Exception possibility exception
     */
    public Mono<Void> deleteById(ID id) throws Exception;

    /**
     * Delete many document for T entity collection in the data base
     *
     * @param ids the entity delete many document in the database
     * @return Void asyn
     * @throws Exception possibility exception
     */
    public Mono<Void> deleteById(Publisher<ID> ids) throws Exception;

    /**
     * Delete all document for T entity collection in the data base
     *
     * @return Void asyn
     * @throws Exception possibility exception
     */
    public Mono<Void> deleteAll() throws Exception;

    /**
     * Delete all document for T entity collection in the data base
     *
     * @return Void asyn
     * @throws Exception possibility exception
     */
    public Mono<Void> deleteAll(Publisher<T> entities) throws Exception;

    /**
     * Delete all document for T entity collection in the data base
     *
     * @return Void asyn
     * @throws Exception possibility exception
     */
    public Mono<Void> deleteAll(Iterable<T> entities) throws Exception;

    /**
     * Find by id the collection T entity reference
     *
     * @param id id the entity document collection
     * @return one document for the collection
     * @throws Exception possibility exception
     */
    public Mono<T> findById(ID id) throws Exception;

    /**
     * Find by id the collection T entity reference
     *
     * @param ids ids the entity document collection
     * @return one document for the collection
     * @throws Exception possibility exception
     */
    public Mono<T> findById(Publisher<ID> ids) throws Exception;

    /**
     * Find by all id the T entity document reference
     *
     * @param ids ids the entity collections for search documents
     * @return all result the search
     * @throws Exception possibility exceptions
     */
    public Flux<T> findAllById(Iterable<ID> ids) throws Exception;

    /**
     * Find by all id the T entity document reference
     *
     * @param ids ids the entity collections for search documents
     * @return all result the search
     * @throws Exception possibility exceptions
     */
    public Flux<T> findAllById(Publisher<ID> ids) throws Exception;

    /**
     * Get all document the collection in the data base type T
     *
     * @return all documents the collections
     * @throws Exception possibility exception
     */
    public Flux<T> findAll() throws Exception;

    /**
     * Get all document the collections with filter parameter base type T
     *
     * @param filter T filter search
     * @return result search
     * @throws Exception possibility exception
     */
    public Flux<T> findAll(T filter) throws Exception;

    /**
     * Get all document the collections with sort order parameter base
     *
     * @param sort order
     * @return all documents order by sorter
     * @throws Exception possibility exception
     */
    public Flux<T> findAll(Sort sort) throws Exception;

    /**
     * Get All document the collections with sort order and filter logic parameter
     *
     * @param filter filter for search document
     * @param sort   order
     * @return all document with sort and filter result
     * @throws Exception possibility exception
     */
    public Flux<T> findAll(T filter, Sort sort) throws Exception;

    /**
     * @param id
     * @return
     * @throws Exception
     */
    public Mono<Boolean> existsById(ID id) throws Exception;
}
