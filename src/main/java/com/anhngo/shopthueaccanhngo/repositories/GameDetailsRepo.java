package com.anhngo.shopthueaccanhngo.repositories;

import com.anhngo.shopthueaccanhngo.entities.GameDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameDetailsRepo extends JpaRepository<GameDetail, Long> {
    @Query("SELECT g FROM GameDetail g WHERE g.game.id = :id")
    List<GameDetail> findByGameId(String id);
}
