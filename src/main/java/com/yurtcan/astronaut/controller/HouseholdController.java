package com.yurtcan.astronaut.controller;

import com.yurtcan.astronaut.repository.HouseholdRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HouseholdController {

  private static final Logger logger = LoggerFactory.getLogger(HouseholdController.class);

  @Autowired
  HouseholdRepository householdRepository;

  @RequestMapping("/households")
  public String listHouseholds(Model model) {

    logger.trace("We are testing a trace log entry from the class: " + this.getClass().getName());

    model.addAttribute("households", householdRepository.findAll());
    return "households";
  }
}
