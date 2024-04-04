package com.fonyou.test.shared.model.exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ExceptionResponse {
    private ExceptionCode code;

    private String message;
}
