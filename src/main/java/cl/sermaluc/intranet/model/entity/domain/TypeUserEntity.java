package cl.sermaluc.intranet.model.entity.domain;

import cl.sermaluc.intranet.model.entity.base.BaseEntity;
import lombok.*;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
@Document(collection = "typeUser")
public class TypeUserEntity extends BaseEntity {
    @TextIndexed
    private String name;
    private String description;
}
