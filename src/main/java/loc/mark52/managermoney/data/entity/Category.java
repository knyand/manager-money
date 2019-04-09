package loc.mark52.managermoney.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "CATEGORIES")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @NotEmpty
    @Column(name = "NAME")
    private String name;
    @NotEmpty
    @Column(name = "CAPACITY")
    private double capacity;
}
