package com.emerson.doris.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TesteDto {

    private EventDto event;
    private Object options;
    private Object payload;

    @Override
    public String toString() {
        return "TesteDto{" +
                "event=" + event.toString() +
                ", options=" + options +
                ", payload=" + payload +
                '}';
    }

}
