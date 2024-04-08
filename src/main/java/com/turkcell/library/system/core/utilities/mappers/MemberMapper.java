package com.turkcell.library.system.core.utilities.mappers;

import com.turkcell.library.system.business.dto.request.member.AddRequestMember;
import com.turkcell.library.system.business.dto.request.member.UpdateRequestMember;
import com.turkcell.library.system.business.dto.response.member.AddResponseMember;
import com.turkcell.library.system.business.dto.response.member.GetAllMemberResponse;
import com.turkcell.library.system.business.dto.response.member.GetByIdResponseMember;
import com.turkcell.library.system.business.dto.response.member.UpdateResponseMember;
import com.turkcell.library.system.entities.Member;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    Member addRequestToMember(AddRequestMember addRequestMember);
    AddResponseMember memberToAddResponse(Member member);

    Member updateRequestToMember(UpdateRequestMember updateRequestMember);
    UpdateResponseMember memberToUpdateResponse(Member member);

    GetByIdResponseMember memberToGetByIdResponse(Member member);

    List<GetAllMemberResponse> membersToGetAllResponse(List<Member> members);
}
