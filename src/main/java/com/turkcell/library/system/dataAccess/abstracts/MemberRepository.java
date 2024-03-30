package com.turkcell.library.system.dataAccess.abstracts;

import com.turkcell.library.system.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {
    boolean existsByName(String name);
}
