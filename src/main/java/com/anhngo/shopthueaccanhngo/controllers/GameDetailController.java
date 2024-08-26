package com.anhngo.shopthueaccanhngo.controllers;

import com.anhngo.shopthueaccanhngo.entities.GameDetail;
import com.anhngo.shopthueaccanhngo.services.CommentService;
import com.anhngo.shopthueaccanhngo.services.GameDetailsService;
import com.anhngo.shopthueaccanhngo.services.NotificationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class GameDetailController {
    @Autowired
    private GameDetailsService gameDetailsService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private CommentService commentService;

    @ModelAttribute("notifications")
    public void notifications(Model model) {
        model.addAttribute("notifications", notificationService.getAll());
        model.addAttribute("notificationsSize", notificationService.getAll().size());
    }

    @ModelAttribute("servletUrl")
    public String servletUrl(HttpServletRequest request) {
        return request.getServletPath();
    }

    @RequestMapping("/chi-tiet/{id}")
    public String detail(Model model, @PathVariable(name = "id") String id) {
        model.addAttribute("gameDetails", gameDetailsService.getAllByGameId(id).getLast());
        List<GameDetail> gameUpdateHistory = gameDetailsService.getAllByGameId(id)
                .stream()
                .sorted(Comparator.comparing(GameDetail::getUpdateDate).reversed())
                .collect(Collectors.toList());
        model.addAttribute("gameUpdateHistory", gameUpdateHistory);
        model.addAttribute("sameGameType", gameDetailsService.getByGameId(id).getGame().getGameType().getGames());
        model.addAttribute("comments", commentService.getAllByGameId(id));
        return "home/_gameDetails";
    }
}
