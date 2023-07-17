package com.springbootacademy.batch9pos.repo;

import com.springbootacademy.batch9pos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ItemRepo extends JpaRepository<Item,Integer>  {

    List<Item> findAllByActiveState(boolean activeStatus);
}

