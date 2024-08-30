package com.anhngo.shopthueaccanhngo.repositories;

import com.anhngo.shopthueaccanhngo.entities.Rental;
import com.anhngo.shopthueaccanhngo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepo extends JpaRepository<Rental, Long> {
    List<Rental> findAllByUsername(User username);
}

