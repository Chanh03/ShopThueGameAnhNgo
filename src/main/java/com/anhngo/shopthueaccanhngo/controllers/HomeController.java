package com.anhngo.shopthueaccanhngo.controllers;

import com.anhngo.shopthueaccanhngo.entities.*;
import com.anhngo.shopthueaccanhngo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping
public class HomeController {
    @Lazy
    @Autowired
    private GameService gameService;

    @Lazy
    @Autowired
    private GameTypeService gameTypeService;

    @Lazy
    @Autowired
    private GameDetailsService gameDetailsService;

    @Lazy
    @Autowired
    private NotificationService notificationService;

    @Lazy
    @Autowired
    private CommentService commentService;

    @Lazy
    @Autowired
    private UserService userService;

    @Lazy
    @Autowired
    private DownloadService downloadService;

    @ModelAttribute("gameTypes")
    public void gameTypes(Model model) {
        Pageable pageable = PageRequest.of(0, 12);
        Page<GameType> page = gameTypeService.getAllByPage(pageable);
        model.addAttribute("gameTypes", page);
    }

    @ModelAttribute("notifications")
    public void notifications(Model model) {
        model.addAttribute("notifications", notificationService.getAll());
        model.addAttribute("notificationsSize", notificationService.getAll().size());
    }

    @ModelAttribute("authentication")
    public void authentications(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            User userProfile = userService.findById(username);
            model.addAttribute("userProfile", userProfile);
        } else {
            model.addAttribute("userProfile", null);
        }
    }

    @RequestMapping({"/", "/trang-chu", "/home"})
    public String home(Model model) {
        model.addAttribute("games", gameService.getAll());
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());
        Page<Game> page = gameService.getAllByPage(pageable);
        model.addAttribute("listGamePage", page);
        model.addAttribute("randomGame", gameService.getRandomGame());
        return "home/_listGame";
    }

    @RequestMapping("/chi-tiet/{id}")
    public String detail(Model model, @PathVariable(name = "id") String id) {
        model.addAttribute("gameDetails", gameDetailsService.getAllByGameId(id).getLast());
        model.addAttribute("gameDetailsAll", gameDetailsService.getAllByGameId(id));
        List<GameDetail> gameUpdateHistory = gameDetailsService.getAllByGameId(id)
                .stream()
                .sorted(Comparator.comparing(GameDetail::getUpdateDate).reversed())
                .collect(Collectors.toList());
        List<Download> downloads = downloadService.findAllByGameDetailsId(gameDetailsService.getByGameId(id).getId().toString());
        model.addAttribute("downloads", downloads);
        model.addAttribute("gameUpdateHistory", gameUpdateHistory);
        model.addAttribute("sameGameType", gameDetailsService.getByGameId(id).getGame().getGameType().getGames());
        model.addAttribute("comments", commentService.getAllByGameId(id));
        return "home/_gameDetails";
    }

    @RequestMapping("/donate")
    public String donate() {
        return "home/_donate";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(name = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu!");
        }
        return "security/login";
    }

    @RequestMapping("/ho-so-ca-nhan")
    public String handleUserProfile(@RequestParam String username, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            User userProfile = userService.findById(username);
            model.addAttribute("userProfile", userProfile);
        } else {
            model.addAttribute("userProfile", null);
        }
        return "home/_userProfile";
    }
}
