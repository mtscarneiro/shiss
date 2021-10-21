package mtscarneiro.vlues.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
@Getter
@Setter
@Entity
@Table(name = "tb_kalleu")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String cpf;
    private LocalDate birthDate;

    @OneToMany(mappedBy = "id.phone")
    private Set<Phone> phone;

    public Person() {
    }

    public Person(Long id, String firstName, String lastName, String cpf, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }
}