package com.anhngo.shopthueaccanhngo.services;

import com.anhngo.shopthueaccanhngo.entities.Game;
import com.anhngo.shopthueaccanhngo.entities.GameType;
import com.anhngo.shopthueaccanhngo.repositories.GameTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameTypeService {
    @Autowired
    private GameTypeRepo gameTypeRepo;

    public Page<GameType> getAllByPage(Pageable pageable) {
        return gameTypeRepo.findAll(pageable);
    }
}
