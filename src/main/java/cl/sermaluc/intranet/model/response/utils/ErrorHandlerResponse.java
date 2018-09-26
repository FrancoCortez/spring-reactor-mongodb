package cl.sermaluc.intranet.model.response.utils;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
public class ErrorHandlerResponse implements Serializable {
    private String msg;
    private Object trace;
    private Object cause;
}
