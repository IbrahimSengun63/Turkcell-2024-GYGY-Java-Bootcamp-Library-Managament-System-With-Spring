package com.turkcell.library.system.business.dto.request.employee;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRequestEmployee {
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
}
