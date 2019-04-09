package loc.mark52.managermoney.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ROLES")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "NAME")
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
