package cl.proyecto.intranet.model.entity.domain;

import cl.proyecto.intranet.model.entity.base.BaseEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
@Document(collection = "status")
public class StatusEntity extends BaseEntity {
    private String name;
    private String description;
}
