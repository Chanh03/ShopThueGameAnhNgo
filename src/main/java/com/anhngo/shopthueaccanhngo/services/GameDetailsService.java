package com.anhngo.shopthueaccanhngo.services;

import com.anhngo.shopthueaccanhngo.entities.GameDetail;
import com.anhngo.shopthueaccanhngo.repositories.GameDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameDetailsService {
    @Autowired
    private GameDetailsRepo gameDetailsRepo;

    public Object getAllByGameId(String id) {
        return gameDetailsRepo.findByGameId(id);
    }

    public Optional<GameDetail> getByGameId(String id) {
        return Optional.ofNullable(gameDetailsRepo.findByGameId(id));
    }
}
