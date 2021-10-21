package mtscarneiro.vlues.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Getter
@Setter
public class Phone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Integer number;

    public Phone(Long id, String type, Integer number) {
        this.id = id;
        this.type = type;
        this.number = number;
    }

    public Phone() {
    }
}
