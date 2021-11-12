package it.plansoft.hello.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Giuseppe Grosso
 * @project hello
 * @since 02/10/2021
 */
@Data
@AllArgsConstructor
public class LoginDto {
    private String name;
    private String surname;

}
