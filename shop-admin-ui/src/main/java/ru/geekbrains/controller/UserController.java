package ru.geekbrains.controller;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.dto.UserDto;
import ru.geekbrains.dto.request.user.UserEditRequest;
import ru.geekbrains.repository.RoleRepository;
import ru.geekbrains.service.UserService;


import javax.validation.Valid;

@Controller
@Slf4j
public class UserController {

    private final RoleRepository roleRepository;

    private final UserService userService;

    @Autowired
    public UserController(RoleRepository roleRepository, UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/users")
    public String adminUsersPage(Model model) {
        model.addAttribute("activePage", "Users");
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/user/{id}/edit")
    public String adminEditUser(Model model, @PathVariable("id") Integer id) throws NotFoundException {
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", roleRepository.findAll());
        return "user_form";
    }

    @GetMapping("/user/create")
    public String adminCreateUser(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", new UserDto());
        model.addAttribute("roles", roleRepository.findAll());
        return "user_form";
    }

    @PutMapping("/user")
    public String adminUpsertUser(@Valid UserEditRequest userEditRequest, BindingResult bindingResult, Model model) {
        model.addAttribute("activePage", "Users");

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> {
                log.info("PUT: adminUpsertUser(UserDto)::count errors={}==>{}", bindingResult.getAllErrors().size(), objectError);
            });
            model.addAttribute("error", true);
            return "redirect:/user/" + userEditRequest.getId() + "/edit?error=true";
        }

        userService.save(userEditRequest);
        return "redirect:/users";
    }

    @DeleteMapping("/user/{id}/delete")
    public String adminDeleteUser(Model model, @PathVariable("id") Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/roles")
    public String adminRolesPage(Model model) {
        model.addAttribute("activePage", "Roles");
        return "index";
    }
}
