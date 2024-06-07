package com.zeroskill.buytopia.entity;

import com.zeroskill.buytopia.dto.MemberDto;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_id", nullable = false, unique = true)
    private String loginId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ColumnDefault("'SILVER'")
    @Enumerated(EnumType.STRING)
    @Column(name = "grade", nullable = false)
    private Grade grade;

    @Embedded
    private Address address;

    public Member(String loginId, String name, String email, String password, Address address) {
        this.loginId = loginId;
        this.name = name;
        this.email = email;
        this.grade = Grade.SILVER;
        this.password = password;
        this.address = address;
    }

    public static Member toEntity(MemberDto memberDto, Address address) {
        return new Member(memberDto.loginId(), memberDto.name(), memberDto.email(), memberDto.password(),address);
    }
}