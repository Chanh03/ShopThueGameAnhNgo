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
@Table(name = "GameDetails")
public class GameDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Game_Id", nullable = false)
    private Game game;

    @Nationalized
    @Column(name = "ChiTiet", nullable = false)
    private String chiTiet;


    @Column(name = "SoLuotTai", nullable = false)
    private Long soLuotTai;

    @Nationalized
    @Column(name = "HuongDan", nullable = false)
    private String huongDan;

    @Nationalized
    @Column(name = "DanhGia", nullable = false, length = 50)
    private String danhGia;

    @Column(name = "PhienBan", nullable = false, length = 50)
    private String phienBan;

    @OneToMany(mappedBy = "gameDetail")
    private Set<Photo> photos = new LinkedHashSet<>();

}