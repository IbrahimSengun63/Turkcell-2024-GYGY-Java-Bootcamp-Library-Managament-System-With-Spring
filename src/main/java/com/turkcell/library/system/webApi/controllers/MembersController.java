package com.turkcell.library.system.webApi.controllers;

import com.turkcell.library.system.business.dto.request.member.AddRequestMember;
import com.turkcell.library.system.business.dto.request.member.UpdateRequestMember;
import com.turkcell.library.system.business.dto.response.member.AddResponseMember;
import com.turkcell.library.system.business.dto.response.member.GetAllMemberResponse;
import com.turkcell.library.system.business.dto.response.member.GetByIdResponseMember;
import com.turkcell.library.system.business.dto.response.member.UpdateResponseMember;
import com.turkcell.library.system.business.abstracts.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MembersController {
    private final MemberService memberService;

    @PostMapping("/add")
    public ResponseEntity<AddResponseMember> addMember(@RequestBody @Valid AddRequestMember addRequestMember) {
        AddResponseMember response = this.memberService.addMember(addRequestMember);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }
    @GetMapping("/getById/{id}")
    public GetByIdResponseMember getByIdMember(@PathVariable int id) {
        return this.memberService.getMemberById(id);
    }

    @GetMapping("/getAll")
    public List<GetAllMemberResponse> getAllMember() {
        return this.memberService.getAllMember();
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateResponseMember> updateMember(@RequestBody @Valid UpdateRequestMember updateRequestMember) {
        UpdateResponseMember response = this.memberService.updateMember(updateRequestMember);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMember(@PathVariable int id) {
        this.memberService.deleteMember(id);
    }
}
