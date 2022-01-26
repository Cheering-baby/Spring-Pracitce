package com.example.springpractice.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "z_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "role_code", nullable = false)
    private String roleCode;
    @Column(name = "role_name", nullable = false)
    private String roleName;
}
