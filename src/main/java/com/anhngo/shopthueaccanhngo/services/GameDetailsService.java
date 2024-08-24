package com.anhngo.shopthueaccanhngo.services;

import com.anhngo.shopthueaccanhngo.repositories.GameDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameDetailsService {
    @Autowired
    private GameDetailsRepo gameDetailsRepo;
}
