package com.star.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 腳色
 */
@Entity
@Data
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "no_", nullable = false, unique = true)
    private String no;

    @Column(name = "name_", nullable = false)
    private String name;


}
