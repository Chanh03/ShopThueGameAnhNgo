package com.anhngo.shopthueaccanhngo.services;

import com.anhngo.shopthueaccanhngo.entities.Game;
import com.anhngo.shopthueaccanhngo.repositories.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class GameService {
    @Autowired
    private GameRepo gameRepo;

    public Object getAll() {
        return gameRepo.findAll();
    }

    public Page<Game> getAllByPage(Pageable pageable) {
        return gameRepo.findAll(pageable);
    }

    public Game getRandomGame() {
        List<Game> games = gameRepo.findAll();
        Random random = new Random();
        return games.get(random.nextInt(games.size()));
    }

    public Game findById(String id) {
        return gameRepo.findById(id).orElse(null);
    }
}
