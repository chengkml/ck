package com.ck.role;

import org.hibernate.annotations.GenericGenerator;

import com.ck.user.User;

import jakarta.persistence.ManyToMany;

import java.util.Set;
import java.util.HashSet;


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
