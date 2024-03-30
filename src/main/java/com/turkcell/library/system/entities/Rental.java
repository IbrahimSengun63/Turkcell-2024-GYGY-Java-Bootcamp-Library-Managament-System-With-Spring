package com.turkcell.library.system.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne()
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToMany(mappedBy = "rental")
    private List<Transaction> transactions;
}