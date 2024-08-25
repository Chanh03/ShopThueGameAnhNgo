package com.anhngo.shopthueaccanhngo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "Username", nullable = false, length = 50)
    private String username;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Enabled", nullable = false)
    private Boolean enabled = false;

    @Column(name = "Email", nullable = false)
    private String email;

    @Nationalized
    @Column(name = "Full_Name", nullable = false)
    private String fullName;

    @Column(name = "Phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "Ngay_Tao", nullable = false)
    private Instant ngayTao;

    @Nationalized
    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "Hinh_Anh")
    private String hinhAnh;

    @ColumnDefault("0")
    @Column(name = "Money")
    private Long money;

    @OneToMany(mappedBy = "username")
    private Set<Authority> authorities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "username")
    private Set<Comment> comments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "username")
    private Set<Rental> rentals = new LinkedHashSet<>();

}