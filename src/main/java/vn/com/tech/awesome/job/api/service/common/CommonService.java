package vn.com.tech.awesome.job.api.service.common;

import com.querydsl.core.types.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import vn.com.tech.awesome.job.api.repository.CommonRepository;
import vn.com.tech.awesome.job.api.util.Constants;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

import static java.util.Objects.isNull;

/**
 * @author Admin
 * @created 18/01/2024 - 11:23 AM
 * @project awesome-job-api
 */

public abstract class CommonService<E, ID, R extends CommonRepository<E, ID>> {

    protected final R repo;
    protected final Logger log;

    public CommonService(R repo) {
        log = LoggerFactory.getLogger(getClass());

        this.repo = repo;
    }

    public E save(E entity) {
        repo.save(entity);
        return entity;
    }

    public List<E> save(List<E> entities) {
        repo.saveAll(entities);
        return entities;
    }

    public Optional<E> get(ID id) {
        return repo.findById(id);
    }

//    public E getOrElseThrow(ID id) throws NotFoundEntityException {
//        return get(id)
//                .orElseThrow(NotFoundEntityException.ofSupplier(notFoundMessage()));
//    }
//
//    public E getOrElseThrow(ID id, String message) throws NotFoundEntityException {
//        return get(id)
//                .orElseThrow(NotFoundEntityException.ofSupplier(message));
//    }
//
//    public E getOrElseThrowError(ID id, String errorCode) {
//        return get(id)
//                .orElseThrow(() -> ErrorCodeException.of(DistributedErrorCodeFactory.of(errorCode)));
//    }

    public E delete(E entity) {
        repo.delete(entity);
        return entity;
    }

    public List<E> delete(List<E> entities) {
        repo.deleteAll(entities);
        return entities;
    }

    public E deleteIfExisted(ID id) {
        Optional<E> optional = get(id);
        if (optional.isEmpty()) {
            return null;
        }
        E entity = optional.get();
        delete(entity);
        repo.flush();
        return entity;
    }

    public E deleteEntityIfExisted(E e) {
        delete(e);
        repo.flush();
        return e;
    }

    public Page<E> query(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Page<E> query(Sort.Order... orders) {
        return query(null, orders);
    }

    public Page<E> query(Integer offset, Integer limit, Sort.Order... orders) {
        return query(null, offset, limit, orders);
    }

    public Page<E> query(Predicate condition, Sort.Order... orders) {
        return query(condition, null, null, orders);
    }

    public Page<E> query(Predicate condition, Integer offset, Integer limit, Sort.Order... orders) {
        Pageable pageable = ofPageable(offset, limit, orders);
        return condition != null ? repo.findAll(condition, pageable) : repo.findAll(pageable);
    }

    public List<E> all(Sort.Order... orders) {
        return all(null, orders);
    }

    public List<E> all(Predicate condition, Sort.Order... orders) {
        List<E> result = new LinkedList<>();

        Page<E> page = query(condition, orders);
        while (page.hasContent()) {
            result.addAll(page.getContent());

            Pageable nextPageable = page.getPageable().next();
            page = Objects.nonNull(condition) ? repo.findAll(condition, nextPageable) : repo.findAll(nextPageable);
        }
        return result;
    }

//    public E updateOnField(ID id, Consumer<E> fieldConsumer) throws NotFoundEntityException {
//        E entity = getOrElseThrow(id);
//        return update(entity, fieldConsumer);
//    }

    public E update(E entity, Consumer<E> fieldConsumer) {
        fieldConsumer.accept(entity);
        save(entity);
        return entity;
    }

    public boolean exits(ID id) {
        return repo.existsById(id);
    }

    public List<E> load(List<ID> ids) {
        return repo.findAllById(ids);
    }

    public List<E> getAll() {
        return repo.findAll();
    }

    protected abstract String notFoundMessage();

    public static Pageable ofPageable(Integer page, Integer size, Sort.Order... orders) {
        if (isNull(page)) {
            page = Constants.DEFAULT_OFFSET;
        }
        if (isNull(size)) {
            size = Constants.DEFAULT_LIMIT;
        }

        Sort sort = orders == null ? Sort.unsorted() : Sort.by(orders);

        return PageRequest.of(page - 1, size, sort);
    }

    public List<E> saveAndFlush(List<E> entities) {
        return repo.saveAllAndFlush(entities);
    }

    public E saveAndFlush(E entity) {
        return repo.saveAndFlush(entity);
    }
}
