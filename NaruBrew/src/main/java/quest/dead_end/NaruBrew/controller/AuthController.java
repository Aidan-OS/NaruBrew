package quest.dead_end.NaruBrew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import quest.dead_end.NaruBrew.service.AppUserService;
import quest.dead_end.NaruBrew.dto.SignupForm;

@Controller
public class AuthController
{
    private final AppUserService userService;

    public AuthController(AppUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage()
    {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage()
    {
        return "signup";
    }

    @PostMapping("/signup")
    public String handleSignup(@ModelAttribute SignupForm form, Model model) {
        boolean success = userService.registerUser(form.getUsername(), form.getEmail(), form.getPassword());
        if (!success) {
            model.addAttribute("error", "Username already taken.");
            return "signup";
        }
        return "redirect:/login";
    }
}
