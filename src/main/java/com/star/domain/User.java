package com.star.domain;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name="alita_user")
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name="name_")
    private String name;

    @Column(name="user_id_")
    @NotEmpty
    private String userId;

    @Column(name="password_")
    @NotEmpty
    private String password;

    @Column(name = "disabled_")
    private Boolean disabled;

    @Column(name = "locked_")
    private Boolean locked;

    @ManyToMany
    @JoinTable(name="alita_user_role",
    joinColumns = @JoinColumn(name = "user_id_",
            foreignKey = @ForeignKey(name="fk_user_id_")
    ),
            inverseJoinColumns = @JoinColumn(name="role_id_",
                    foreignKey = @ForeignKey(name="fk_role_id_")
            ),
            uniqueConstraints = @UniqueConstraint(columnNames = {"user_id_", "role_id_"}))

    private Set<Role> roles;

    @Transient
    private List<String> roleIds;

    public  User(){
        roles = new HashSet<>();
    }
    public  List<String> getRoleIds(){
        if(null==roleIds){
            roleIds=getRoles().stream().map(Role::getId).collect(Collectors.toList());
        }
        return roleIds;
    }


}

