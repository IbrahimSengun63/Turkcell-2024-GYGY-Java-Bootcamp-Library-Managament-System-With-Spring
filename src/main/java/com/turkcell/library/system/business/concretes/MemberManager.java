package com.turkcell.library.system.business.concretes;

import com.turkcell.library.system.business.abstracts.MemberService;
import com.turkcell.library.system.business.dto.request.member.AddRequestMember;
import com.turkcell.library.system.business.dto.request.member.UpdateRequestMember;
import com.turkcell.library.system.business.dto.response.member.AddResponseMember;
import com.turkcell.library.system.business.dto.response.member.GetAllMemberResponse;
import com.turkcell.library.system.business.dto.response.member.GetByIdResponseMember;
import com.turkcell.library.system.business.dto.response.member.UpdateResponseMember;
import com.turkcell.library.system.business.rules.MemberBusinessRules;
import com.turkcell.library.system.core.utilities.mappers.MemberMapper;
import com.turkcell.library.system.dataAccess.abstracts.MemberRepository;
import com.turkcell.library.system.entities.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberManager implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberBusinessRules memberBusinessRules;

    @Override
    public AddResponseMember addMember(AddRequestMember addRequestMember) {
        this.memberBusinessRules.checkIfMemberNameExists(addRequestMember.getName());
        Member member = MemberMapper.INSTANCE.addRequestToMember(addRequestMember);
        Member savedMember = this.memberRepository.save(member);
        return MemberMapper.INSTANCE.memberToAddResponse(savedMember);
    }

    @Override
    public GetByIdResponseMember getMemberById(int id) {
        Member member = this.memberRepository.findById(id).orElseThrow();
        return MemberMapper.INSTANCE.memberToGetByIdResponse(member);
    }

    @Override
    public List<GetAllMemberResponse> getAllMember() {
        List<Member> books = this.memberRepository.findAll();
        return MemberMapper.INSTANCE.membersToGetAllResponse(books);
    }

    @Override
    public UpdateResponseMember updateMember(UpdateRequestMember updateBookRequest) {
        Member member = MemberMapper.INSTANCE.updateRequestToMember(updateBookRequest);
        Member savedMember = this.memberRepository.save(member);
        return MemberMapper.INSTANCE.memberToUpdateResponse(savedMember);
    }

    @Override
    public void deleteMember(int id) {
        this.memberRepository.deleteById(id);
    }
}
