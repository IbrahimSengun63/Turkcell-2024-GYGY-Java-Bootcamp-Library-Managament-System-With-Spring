package com.turkcell.library.system.business.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AddBookResponse {
    private int id;
    private String name;
    private String author;
    private boolean available;
}