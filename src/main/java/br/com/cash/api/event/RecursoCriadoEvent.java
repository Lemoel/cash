package br.com.cash.api.event;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecursoCriadoEvent extends ApplicationEvent {

    static final long serialVersionUUID = 1L;
    HttpServletResponse response;
    Long codigo;

    public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
        super(source);
        this.response = response;
        this.codigo = codigo;
    }
}
