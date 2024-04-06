package com.turkcell.library.system.webApi.controllers;

import com.turkcell.library.system.business.dto.request.member.AddMemberRequest;
import com.turkcell.library.system.business.dto.request.member.UpdateMemberRequest;
import com.turkcell.library.system.business.dto.response.member.AddMemberResponse;
import com.turkcell.library.system.business.dto.response.member.GetAllMemberResponse;
import com.turkcell.library.system.business.dto.response.member.GetByIdMemberResponse;
import com.turkcell.library.system.business.dto.response.member.UpdateMemberResponse;
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

    @PostMapping("/addMember")
    public ResponseEntity<AddMemberResponse> addMember(@RequestBody @Valid AddMemberRequest addMemberRequest) {
        AddMemberResponse response = this.memberService.addMember(addMemberRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }
    @GetMapping("/getById/{id}")
    public GetByIdMemberResponse getById(@PathVariable int id) {
        return this.memberService.getMemberById(id);
    }

    @GetMapping("/getAllMembers")
    public List<GetAllMemberResponse> getAllMember() {
        return this.memberService.getAllMember();
    }

    @PutMapping("/updateMember")
    public ResponseEntity<UpdateMemberResponse> updateMember(@RequestBody UpdateMemberRequest updateMemberRequest) {
        UpdateMemberResponse response = this.memberService.updateMember(updateMemberRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/deleteMember/{id}")
    public void deleteMember(@PathVariable int id) {
        this.memberService.deleteMember(id);
    }
}
