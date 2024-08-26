package com.anhngo.shopthueaccanhngo.services;

import com.anhngo.shopthueaccanhngo.entities.GameDetail;
import com.anhngo.shopthueaccanhngo.repositories.GameDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameDetailsService {
    @Autowired
    private GameDetailsRepo gameDetailsRepo;

    public List<GameDetail> getAllByGameId(String id) {
        return gameDetailsRepo.findByGameId(id);
    }

    public GameDetail getByGameId(String id) {
        return gameDetailsRepo.findByGameId(id).get(0);
    }
}
