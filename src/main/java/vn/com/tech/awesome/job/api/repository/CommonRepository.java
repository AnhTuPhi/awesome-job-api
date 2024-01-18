package vn.com.tech.awesome.job.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * @author Admin
 * @created 18/01/2024 - 11:32 AM
 * @project awesome-job-api
 */
@NoRepositoryBean
public interface CommonRepository<E, ID> extends JpaRepository<E, ID>, QuerydslPredicateExecutor<E> {

    List<E> findByIdIn(List<ID> ids);

}
