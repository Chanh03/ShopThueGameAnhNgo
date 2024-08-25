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
@Table(name = "Game_Type")
public class GameType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Nationalized
    @Column(name = "Ten", nullable = false, length = 50)
    private String ten;

    @Nationalized
    @Column(name = "Hinh_Anh", nullable = false, length = 50)
    private String hinhAnh;

    @OneToMany(mappedBy = "gameType")
    private Set<Game> games = new LinkedHashSet<>();

}