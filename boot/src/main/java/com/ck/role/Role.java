package ck.tools.role;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;

import java.util.Set;
import java.util.HashSet;

import ck.tools.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ct_roles")
public class Role {
    @Id
    @GeneratedValue(generator = "uid-generator")
    @GenericGenerator(name = "uid-generator", strategy = "ck.tools.uid.IdGenerator")
    private Long id;
    private String name;
    private String label;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
