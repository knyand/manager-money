package loc.mark52.managermoney.data.entity;

import loc.mark52.managermoney.validator.UserDuplicate;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "USERS")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @NotEmpty
    @Email
    @UserDuplicate
    @Column(name = "EMAIL")
    private String email;
    @NotEmpty
    @Column(name = "NAME")
    private String name;
    @NotEmpty
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ENABLED")
    private boolean enabled;
    @ManyToMany
    @JoinTable(name = "AUTHORITIES", joinColumns = {@JoinColumn(name = "USER_ID")}, inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    private Set<Role> roles;
    @ElementCollection
    @CollectionTable(name = "ACCOUNTS")
    @MapKeyColumn(name = "CUR")
    @Column(name = "SUM")
    private Map<String, Double> accounts = new HashMap<>();
}
