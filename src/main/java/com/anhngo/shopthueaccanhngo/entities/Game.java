package com.anhngo.shopthueaccanhngo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Games")
public class Game {
    @Id
    @Column(name = "Id", nullable = false, length = 50)
    private String id;

    @Nationalized
    @Column(name = "Ten", nullable = false, length = 50)
    private String ten;

    @Column(name = "Gia_Thue", nullable = false)
    private Long giaThue;

    @Column(name = "Enabled", nullable = false)
    private Boolean enabled = false;

    @Column(name = "Hinh_Anh", nullable = false, length = 50)
    private String hinhAnh;

    @Nationalized
    @Column(name = "Gioi_Thieu", nullable = false)
    private String gioiThieu;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Game_Type_Id", nullable = false)
    private GameType gameType;

    @OneToMany(mappedBy = "game")
    private Set<Comment> comments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "game")
    private Set<GameDetail> gameDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "game")
    private Set<Rental> rentals = new LinkedHashSet<>();

}