package cl.proyecto.intranet.model.request.domain;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
public class TypeUserWithIdRequest implements Serializable {

    private String _id;
    private String name;
    private String description;
}
