package cl.sermaluc.intranet.model.request.domain;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
public class StatusRequest implements Serializable {
    private String name;
    private String description;
}
