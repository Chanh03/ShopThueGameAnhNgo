package com.anhngo.shopthueaccanhngo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Header", nullable = false)
    private String header;

    @Column(name = "Body", nullable = false)
    private String body;

    @Column(name = "Create_Date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "Link")
    private String link;
}