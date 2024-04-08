package com.turkcell.library.system.business.dto.request.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//Via Dto request object, end user db access restricted
public class UpdateRequestBook {
    //with id field repository infer this process is an update process
    private int id;
    private String name;
    private String author;
    private boolean available;
}
