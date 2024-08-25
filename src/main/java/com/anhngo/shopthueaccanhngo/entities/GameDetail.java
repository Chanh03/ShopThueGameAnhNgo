package com.anhngo.shopthueaccanhngo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Game_Details")
public class GameDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Game_Id", nullable = false)
    private Game game;

    @Nationalized
    @Column(name = "Chi_Tiet", nullable = false)
    private String chiTiet;


    @Column(name = "So_Luot_Tai", nullable = false)
    private Long soLuotTai;

    @Column(name = "Update_Date", nullable = false)
    private Date updateDate;

    @Column(name = "Dung_Luong", nullable = false)
    private String dungLuong;

    @Column(name = "So_Part", nullable = false)
    private Long soPart;

    @Column(name = "So_Nguoi_Choi", nullable = false)
    private String soNguoiChoi;

    @Column(name = "He_Dieu_Hanh", nullable = false)
    private String heDieuHanh;

    @Column(name = "Choi_Bang", nullable = false)
    private String choiBang;

    @Column(name = "Ngon_Ngu", nullable = false)
    private String ngonNgu;

    @Nationalized
    @Column(name = "Huong_Dan", nullable = false)
    private String huongDan;

    @Column(name = "Phien_Ban", nullable = false, length = 50)
    private String phienBan;

    @OneToMany(mappedBy = "gameDetail")
    private Set<Photo> photos = new LinkedHashSet<>();

}