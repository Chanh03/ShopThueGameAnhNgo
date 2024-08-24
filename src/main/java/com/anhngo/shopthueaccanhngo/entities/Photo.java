package com.anhngo.shopthueaccanhngo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GameDetail_Id", nullable = false)
    private GameDetail gameDetail;

    @Column(name = "HinhAnh", nullable = false)
    private String hinhAnh;

}