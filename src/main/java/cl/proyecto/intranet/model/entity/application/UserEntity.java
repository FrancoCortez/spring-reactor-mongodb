package cl.proyecto.intranet.model.entity.application;

import cl.proyecto.intranet.model.entity.domain.StatusEntity;
import cl.proyecto.intranet.model.entity.base.BaseEntity;
import cl.proyecto.intranet.model.entity.domain.TypeUserEntity;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
@Document(collection = "users")
public class UserEntity extends BaseEntity {

    @Indexed(unique = true)
    @NotNull
    private String username;
    @NotNull
    private String password;
    @Indexed(unique = true)
    @NotNull
    private String email;
    private TypeUserEntity typeUser;
    private StatusEntity statusEntity;
}
