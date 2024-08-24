package com.anhngo.shopthueaccanhngo.controllers;

import com.anhngo.shopthueaccanhngo.entities.Game;
import com.anhngo.shopthueaccanhngo.entities.GameType;
import com.anhngo.shopthueaccanhngo.services.GameService;
import com.anhngo.shopthueaccanhngo.services.GameTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListGameController {
    @Autowired
    private GameService gameService;

    @Autowired
    private GameTypeService gameTypeService;

    @ModelAttribute("gameTypes")
    public void gameTypes(Model model) {
        Pageable pageable = PageRequest.of(0, 12);
        Page<GameType> page = gameTypeService.getAllByPage(pageable);
        model.addAttribute("gameTypes", page);
    }

    @RequestMapping()
    public String home(Model model) {
        model.addAttribute("games", gameService.getAll());
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());
        Page<Game> page = gameService.getAllByPage(pageable);
        model.addAttribute("listGamePage", page);
        model.addAttribute("randomGame", gameService.getRandomGame());
        return "home/_listGame";
    }
}
