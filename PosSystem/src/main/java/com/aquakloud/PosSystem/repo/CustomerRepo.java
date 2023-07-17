package com.aquakloud.PosSystem.repo;

import com.aquakloud.PosSystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByActiveState(boolean activeStatus);
}
