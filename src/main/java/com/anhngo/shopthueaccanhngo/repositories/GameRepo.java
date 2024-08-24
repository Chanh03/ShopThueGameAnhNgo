package com.anhngo.shopthueaccanhngo.repositories;

import com.anhngo.shopthueaccanhngo.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepo extends JpaRepository<Game, Long> {
}
