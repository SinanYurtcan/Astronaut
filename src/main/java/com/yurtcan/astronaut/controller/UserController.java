package com.yurtcan.astronaut.controller;

import java.util.List;

import javax.validation.Valid;

import com.yurtcan.astronaut.model.User;
import com.yurtcan.astronaut.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  private final UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/user/list")
  public String listItems(Model model) {
    List<User> users = userRepository.findAll();
    model.addAttribute("users", users);
    return "user-list";
  }

  @GetMapping("/user/signup")
  public String showSignUpForm(User user) {
    return "user-add";
  }

  @PostMapping("/user/add")
  public String addUser(@Valid User user, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "user-add";
    }

    userRepository.save(user);
    model.addAttribute("users", userRepository.findAll());
    return "user-list";
  }

  @GetMapping("/user/edit/{id}")
  public String showUpdateForm(@PathVariable("id") int id, Model model) {
    User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    model.addAttribute("user", user);
    return "user-update";
  }

  @PostMapping("/user/update/{id}")
  public String updateUser(@PathVariable("id") int id, @Valid User user, BindingResult result, Model model) {
    if (result.hasErrors()) {
      user.setId(id);
      return "user-update";
    }

    userRepository.save(user);
    model.addAttribute("users", userRepository.findAll());
    return "user-list";
  }

  @GetMapping("/user/delete/{id}")
  public String deleteUser(@PathVariable("id") int id, Model model) {
    User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    userRepository.delete(user);
    model.addAttribute("users", userRepository.findAll());
    return "user-list";
  }
}