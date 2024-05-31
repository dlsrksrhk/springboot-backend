package me.kdh.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;


@Sql("/insert-members.sql")
@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    void deleteAllMember() {
        memberRepository.deleteAllInBatch();
        assertThat(memberRepository.findAll().size()).isEqualTo(0);
    }

    @Test
    void getAllMembers() {
        assertThat(memberRepository.findAll().size()).isEqualTo(3);
    }

}