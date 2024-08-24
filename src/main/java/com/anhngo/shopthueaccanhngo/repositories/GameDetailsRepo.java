package com.anhngo.shopthueaccanhngo.repositories;

import com.anhngo.shopthueaccanhngo.entities.GameDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDetailsRepo extends JpaRepository<GameDetail, Long> {
}
