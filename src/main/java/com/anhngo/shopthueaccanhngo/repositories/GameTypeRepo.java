package com.anhngo.shopthueaccanhngo.repositories;

import com.anhngo.shopthueaccanhngo.entities.GameType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameTypeRepo extends JpaRepository<GameType, Long> {
}
