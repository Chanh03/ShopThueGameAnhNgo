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
public class Game {
    @Id
    @Column(name = "Id", nullable = false, length = 50)
    private String id;

    @Nationalized
    @Column(name = "Ten", length = 50)
    private String ten;

    @Column(name = "Gia_Thue")
    private Long giaThue;

    @Column(name = "Enabled")
    private Boolean enabled;

    @Column(name = "Phien_Ban", length = 50)
    private String phienBan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Loai_Game_Id")
    private LoaiGame loaiGame;

    @OneToMany(mappedBy = "game")
    private Set<Comment> comments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "game")
    private Set<GameChitiet> gameChitiets = new LinkedHashSet<>();

    @OneToMany(mappedBy = "game")
    private Set<LinkTai> linkTais = new LinkedHashSet<>();

    @OneToMany(mappedBy = "game")
    private Set<ThueGame> thueGames = new LinkedHashSet<>();

}