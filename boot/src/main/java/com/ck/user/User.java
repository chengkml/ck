package ck.tools.user;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import ck.tools.role.Role;

@Data
@Entity
@Table(name = "ct_users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(generator = "uid-generator")
    @GenericGenerator(name = "uid-generator", strategy = "ck.tools.uid.IdGenerator")
    private Long id;
    private String username;
    private String email;
    private String password;
    private String isAccountNonExpired;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

@ManyToMany
@JoinTable(
    name = "ct_user_role_rela",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
)
private Set<Role> roles = new HashSet<>();

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles.stream()
               .map(role -> new SimpleGrantedAuthority(role.getName()))
               .collect(Collectors.toList());
}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
