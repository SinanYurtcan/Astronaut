package com.yurtcan.astronaut.controller;

import java.util.List;

import com.yurtcan.astronaut.model.Item;
import com.yurtcan.astronaut.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {

  private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

  @Autowired
  ItemRepository itemRepository;

  @RequestMapping("/item/list")
  public String listItems(Model model) {

    logger.trace("We are testing a trace log entry from the class: " + this.getClass().getName());

    List<Item> items = itemRepository.findAll();
    model.addAttribute("items", items);
    return "item-list";
  }
}
