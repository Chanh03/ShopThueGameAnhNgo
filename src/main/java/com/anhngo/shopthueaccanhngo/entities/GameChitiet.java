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
@Table(name = "Game_ChiTiet")
public class GameChitiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Game_Id")
    private Game game;

    @Nationalized
    @Column(name = "Chi_Tiet")
    private String chiTiet;

    @Nationalized
    @Column(name = "Gioi_Thieu")
    private String gioiThieu;

    @Column(name = "So_Luot_Tai")
    private Long soLuotTai;

    @Nationalized
    @Column(name = "Huong_Dan")
    private String huongDan;

    @Nationalized
    @Column(name = "Danh_Gia", length = 50)
    private String danhGia;

    @OneToMany(mappedBy = "gameChitiet")
    private Set<HinhAnh> hinhAnhs = new LinkedHashSet<>();

}