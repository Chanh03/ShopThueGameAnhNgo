package com.anhngo.shopthueaccanhngo.services;

import com.anhngo.shopthueaccanhngo.entities.Rental;
import com.anhngo.shopthueaccanhngo.entities.User;
import com.anhngo.shopthueaccanhngo.repositories.RentalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    @Autowired
    private RentalRepo rentalRepo;

    public List<Rental> findAllByUsername(User username) {
        return rentalRepo.findAllByUsername(username);
    }
}
