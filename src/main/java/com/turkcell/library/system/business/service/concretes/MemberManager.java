package com.turkcell.library.system.business.service.concretes;

import com.turkcell.library.system.business.dto.request.member.AddMemberRequest;
import com.turkcell.library.system.business.dto.request.member.UpdateMemberRequest;
import com.turkcell.library.system.business.dto.response.member.AddMemberResponse;
import com.turkcell.library.system.business.dto.response.member.GetAllMemberResponse;
import com.turkcell.library.system.business.dto.response.member.GetByIdMemberResponse;
import com.turkcell.library.system.business.dto.response.member.UpdateMemberResponse;
import com.turkcell.library.system.business.rules.MemberBusinessRules;
import com.turkcell.library.system.business.service.abstracts.MemberService;
import com.turkcell.library.system.core.utilities.mappers.MemberMapper;
import com.turkcell.library.system.dataAccess.abstracts.MemberRepository;
import com.turkcell.library.system.entities.Member;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@RequiredArgsConstructor
@Service
public class MemberManager implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberBusinessRules memberBusinessRules;

    @Override
    public AddMemberResponse addBook(AddMemberRequest addMemberRequest) {
        this.memberBusinessRules.checkIfMemberNameExists(addMemberRequest.getName());
        Member member = MemberMapper.INSTANCE.memberFromAddRequest(addMemberRequest);
        Member savedMember = this.memberRepository.save(member);
        return MemberMapper.INSTANCE.memberFromAddResponse(savedMember);
    }

    @Override
    public GetByIdMemberResponse getMemberById(int id) {
        Member member = this.memberRepository.findById(id).orElseThrow();
        return MemberMapper.INSTANCE.memberFromGetByIdResponse(member);
    }

    @Override
    public List<GetAllMemberResponse> getAllMember() {
        List<Member> books = this.memberRepository.findAll();
        return MemberMapper.INSTANCE.memberFromGetAllResponse(books);
    }

    @Override
    public UpdateMemberResponse updateBook(UpdateMemberRequest updateBookRequest) {
        Member member = MemberMapper.INSTANCE.memberFromUpdateRequest(updateBookRequest);
        Member savedMember = this.memberRepository.save(member);
        return MemberMapper.INSTANCE.memberFromUpdateResponse(savedMember);
    }

    @Override
    public void deleteBook(int id) {
        this.memberRepository.deleteById(id);
    }
}
