package cl.proyecto.intranet.model.entity.base;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Base Entity for object db
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class BaseEntity implements Serializable {

    @Id
    private String _id;
    private AuditingEntity auditingEntity;
}
