package com.anhngo.shopthueaccanhngo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Downloads")
public class Download {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Game_Id", nullable = false)
    private Game game;

    @Column(name = "Loai", nullable = false, length = 50)
    private String loai;

    @Column(name = "LinkTai", nullable = false)
    private String linkTai;

}