package com.turkcell.library.system.business.dto.response.book;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdResponseBook {
    private String name;
    private String author;
    private boolean available;
}
