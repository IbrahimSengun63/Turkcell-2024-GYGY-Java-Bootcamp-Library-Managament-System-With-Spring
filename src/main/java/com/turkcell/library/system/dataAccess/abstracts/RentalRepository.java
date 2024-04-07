package com.turkcell.library.system.dataAccess.abstracts;

import com.turkcell.library.system.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Integer> {
}
