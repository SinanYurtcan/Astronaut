package com.yurtcan.astronaut.controller;

import java.util.List;

import javax.validation.Valid;

import com.yurtcan.astronaut.model.HouseholdItem;
import com.yurtcan.astronaut.repository.HouseholdItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HouseholdItemController {

  @Autowired
  HouseholdItemRepository householdItemRepository;

  @RequestMapping("/householdItem/list")
  public String listHouseholdItems(Model model) {

    List<HouseholdItem> householdItems = householdItemRepository.findAll();
    model.addAttribute("householdItems", householdItems);
    return "householdItem-list";
  }

  @GetMapping("/householdItem/create")
  public String showAddForm(HouseholdItem householdItem) {
    return "householdItem-add";
  }

  @PostMapping(path = { "/householdItem/add"})
  public String addHouseholdItem(@Valid HouseholdItem householdItem, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "householdItem-add";
    }

    householdItemRepository.save(householdItem);
    model.addAttribute("householdItems", householdItemRepository.findAll());
    return "householdItem-list";
  }

  @GetMapping("/householdItem/edit/{id}")
  public String showUpdateForm(@PathVariable("id") int id, Model model) {
    HouseholdItem householdItem = householdItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid household item Id:" + id));
    model.addAttribute("householdItem", householdItem);
    return "householdItem-update";
  }

  @PostMapping("/householdItem/update/{id}")
  public String updateHouseholdItem(@PathVariable("id") int id, @Valid HouseholdItem householdItem, BindingResult result, Model model) {
    if (result.hasErrors()) {
      householdItem.setId(id);
      return "householdItem-update";
    }

    householdItemRepository.save(householdItem);
    model.addAttribute("householdItem", householdItemRepository.findAll());
    return "householdItem-list";
  }

  @GetMapping("/householdItem/delete/{id}")
  public String deleteHouseholdItem(@PathVariable("id") int id, Model model) {
    HouseholdItem householdItem = householdItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid household item Id:" + id));
    householdItemRepository.delete(householdItem);
    model.addAttribute("householdItems", householdItemRepository.findAll());
    return "householdItem-list";
  }
}
