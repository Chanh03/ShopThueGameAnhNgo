package com.anhngo.shopthueaccanhngo.entities;

import com.anhngo.shopthueaccanhngo.entities.Game;
import com.anhngo.shopthueaccanhngo.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Username")
    private User username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Game_Id")
    private Game game;

    @Column(name = "Ngay_Dang")
    private Instant ngayDang;

    @Nationalized
    @Column(name = "Noi_Dung")
    private String noiDung;

}