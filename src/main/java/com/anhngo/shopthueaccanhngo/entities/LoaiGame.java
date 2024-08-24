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
@Table(name = "Loai_Game")
public class LoaiGame {
    @Id
    @Column(name = "Id", nullable = false, length = 50)
    private String id;

    @Nationalized
    @Column(name = "Loai", length = 50)
    private String loai;

    @OneToMany(mappedBy = "loaiGame")
    private Set<Game> games = new LinkedHashSet<>();

}