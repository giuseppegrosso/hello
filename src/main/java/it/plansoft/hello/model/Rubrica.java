package it.plansoft.hello.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Giuseppe Grosso
 * @project hello
 * @since 10/11/2021
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
// attenzione senza questa annotazione
// spring data non capisce che stiamo cercando gli oggetti su tabella di un database.
@Entity
@Table(name = "Rubrica")
public class Rubrica {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "lastname")
    private String surname;
    private String name;
    private String address;


    public Rubrica(String surname, String name, String address) {
        this.surname = surname;
        this.name = name;
        this.address = address;
    }
}
