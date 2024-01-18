package vn.com.tech.awesome.job.api.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * @author Admin
 * @created 18/01/2024 - 12:18 PM
 * @project awesome-job-api
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "issues")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Issue {
    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "java.lang.String")
    String id;
}
