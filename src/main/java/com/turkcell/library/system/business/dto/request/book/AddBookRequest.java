package com.turkcell.library.system.business.dto.request.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//Via Dto request object, end user db access restricted
public class AddBookRequest {
    // field validations defined
    // to make it active this validations in web api layer at the related end point we must define @Valid annotations as well
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
    private String author;
    private boolean available;
}