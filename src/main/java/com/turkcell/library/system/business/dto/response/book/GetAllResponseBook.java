package com.turkcell.library.system.business.dto.response.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//Via Dto request object, end user db access restricted
public class GetAllResponseBook {
    private int id;
    private String name;
    private String author;
    private boolean available;
}
