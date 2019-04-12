package com.yurtcan.astronaut.repository;

import com.yurtcan.astronaut.model.HouseholdItem;
import com.yurtcan.astronaut.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdItemRepository extends JpaRepository<HouseholdItem, Integer> {


}
