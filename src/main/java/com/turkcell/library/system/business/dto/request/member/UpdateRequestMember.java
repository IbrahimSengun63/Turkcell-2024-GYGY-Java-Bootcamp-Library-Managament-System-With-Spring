package com.turkcell.library.system.business.dto.request.member;


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

public class UpdateRequestMember {
    private int id;
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
}
