package cl.sermaluc.intranet.model.request.application;

import cl.sermaluc.intranet.model.request.domain.StatusWithIdRequest;
import cl.sermaluc.intranet.model.request.domain.TypeUserWithIdRequest;
import lombok.*;

import java.io.Serializable;

/**
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
public class UserRequest implements Serializable {
    private String username;
    private String password;
    private String email;
    private TypeUserWithIdRequest typeUserWithIdRequest;
    private StatusWithIdRequest statusWithIdRequest;
}
