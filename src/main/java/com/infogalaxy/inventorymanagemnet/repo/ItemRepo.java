package com.infogalaxy.inventorymanagemnet.repo;

import com.infogalaxy.inventorymanagemnet.entity.item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<item,Integer> {
}
