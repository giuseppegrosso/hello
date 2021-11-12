package it.plansoft.hello.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Giuseppe Grosso
 * @project hello
 * @since 10/11/2021
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RubricaDto {

    private Long id;
    private String name;
    private String surname;
    private String address;

}
