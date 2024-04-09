package com.turkcell.library.system.dataAccess.abstracts;

import com.turkcell.library.system.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental,Integer> {
    List<Rental> findByMemberId(int memberId);
}
