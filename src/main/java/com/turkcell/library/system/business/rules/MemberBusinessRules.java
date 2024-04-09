package com.turkcell.library.system.business.rules;

import com.turkcell.library.system.core.utilities.exceptions.BusinessException;
import com.turkcell.library.system.dataAccess.abstracts.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberBusinessRules {
    private final MemberRepository memberRepository;

    public void checkIfMemberNameExists(String name) {
        if (this.memberRepository.existsByName(name)) {
            throw new BusinessException("Member already exists");
        }
    }

    public void checkIfMemberExists(int id) {
        if (this.memberRepository.findById(id).isEmpty()) {
            throw new BusinessException("Member with " + id + " id couldn't be found");
        }
    }
}
