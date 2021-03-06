package cl.proyecto.intranet.model.request.domain;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
public class TypeUserRequest implements Serializable {
    private String name;
    private String description;

}
