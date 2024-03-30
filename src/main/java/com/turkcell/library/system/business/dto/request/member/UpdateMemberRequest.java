package com.turkcell.library.system.business.dto.request.member;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UpdateMemberRequest {
    private int id;
    private String name;
}
