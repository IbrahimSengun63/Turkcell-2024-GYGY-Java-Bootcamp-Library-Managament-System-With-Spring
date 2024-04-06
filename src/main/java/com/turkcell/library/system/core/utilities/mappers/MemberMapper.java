package com.turkcell.library.system.core.utilities.mappers;

import com.turkcell.library.system.business.dto.request.member.AddMemberRequest;
import com.turkcell.library.system.business.dto.request.member.UpdateMemberRequest;
import com.turkcell.library.system.business.dto.response.member.AddMemberResponse;
import com.turkcell.library.system.business.dto.response.member.GetAllMemberResponse;
import com.turkcell.library.system.business.dto.response.member.GetByIdMemberResponse;
import com.turkcell.library.system.business.dto.response.member.UpdateMemberResponse;
import com.turkcell.library.system.entities.Member;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    Member memberFromAddRequest(AddMemberRequest request);
    AddMemberResponse memberFromAddResponse(Member member);

    Member memberFromUpdateRequest(UpdateMemberRequest request);
    UpdateMemberResponse memberFromUpdateResponse(Member member);

    GetByIdMemberResponse memberFromGetByIdResponse(Member member);

    List<GetAllMemberResponse> memberFromGetAllResponse(List<Member> members);
}
