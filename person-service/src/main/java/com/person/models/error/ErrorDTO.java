package com.person.models.error;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Результат с описанием ошибки
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO implements Serializable {

    private static final long serialVersionUID = -7674808279617550407L;

    private String description;

}
