package com.turkcell.library.system.business.abstracts;

import com.turkcell.library.system.business.dto.request.member.AddRequestMember;
import com.turkcell.library.system.business.dto.request.member.UpdateRequestMember;
import com.turkcell.library.system.business.dto.response.member.AddResponseMember;
import com.turkcell.library.system.business.dto.response.member.GetAllMemberResponse;
import com.turkcell.library.system.business.dto.response.member.GetByIdResponseMember;
import com.turkcell.library.system.business.dto.response.member.UpdateResponseMember;

import java.util.List;

public interface MemberService {

    AddResponseMember addMember(AddRequestMember addRequestMember);

    GetByIdResponseMember getMemberById(int id);

    List<GetAllMemberResponse> getAllMember();

    UpdateResponseMember updateMember(UpdateRequestMember updateBookRequest);

    void deleteMember(int id);

}
