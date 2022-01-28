package com.example.springpractice.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "z_user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "username", nullable = false, unique = true)
  private String username;
  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "role_code", nullable = false)
  private String roleCode;
  @Column(name = "avatar", nullable = true)
  private String avatar;

//  @ManyToOne
//  @JoinColumn(name = "role_code")
//  private Role role;
}
