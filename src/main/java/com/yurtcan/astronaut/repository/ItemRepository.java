package com.yurtcan.astronaut.repository;

import com.yurtcan.astronaut.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {


}
