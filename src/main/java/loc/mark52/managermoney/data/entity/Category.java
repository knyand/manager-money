package loc.mark52.managermoney.data.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "CATEGORIES")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @NotEmpty
    @Column(name = "NAME")
    private String name;
    @Column(name = "CAPACITY")
    private double capacity;
}
