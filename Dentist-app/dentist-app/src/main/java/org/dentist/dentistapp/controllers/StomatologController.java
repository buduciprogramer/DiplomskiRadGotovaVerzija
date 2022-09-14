package org.dentist.dentistapp.controllers;

import org.dentist.dentistapp.entities.Stomatolog;
import org.dentist.dentistapp.model.Role;
import org.dentist.dentistapp.services.StomatologService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




import java.util.List;

@Controller
public class StomatologController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private StomatologService userService;

    @GetMapping("/")
    public String viewUsers(Model model) {
        List<Stomatolog> stomatologList = userService.getAllStomatologs();
        model.addAttribute("listOfUsers", stomatologList);
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        Stomatolog stomatolog = new Stomatolog();
        model.addAttribute("loginUser", stomatolog);
        return "login";
    }

    @GetMapping("/register")
    public String showNewUserForm(Model model) {
        Stomatolog stomatolog = new Stomatolog();
        model.addAttribute("emptyUser", stomatolog);
        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("emptyUser") Stomatolog stomatolog) {
        try {
            stomatolog.setPassword(passwordEncoder.encode(stomatolog.getPassword()));
            stomatolog.setRole(Role.STOMATOLOG);
            userService.saveStomatolog(stomatolog);
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/register?error=Bad registration";
        }
    }
}