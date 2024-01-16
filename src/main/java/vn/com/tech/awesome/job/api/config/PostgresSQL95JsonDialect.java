package vn.com.tech.awesome.job.api.config;

import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.dialect.PostgreSQL95Dialect;

import java.sql.Types;
import java.time.LocalDateTime;

/**
 * @author : AnhTuPhi
 * @created : 1/17/2024 - 12:25 AM - Wednesday
 * @project : awesome-job-api
 **/
public class PostgresSQL95JsonDialect extends PostgreSQL95Dialect {
    public PostgresSQL95JsonDialect() {
        super();
        this.registerHibernateType(Types.OTHER, JsonNodeBinaryType.class.getName());
        this.registerHibernateType(Types.TIMESTAMP, LocalDateTime.class.getName());
        this.registerHibernateType(Types.DATE, LocalDateTime.class.getName());
        this.registerHibernateType(Types.BIGINT, Long.class.getName());
    }
}
