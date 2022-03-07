package com.blind.back.blind_back.member.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long memNo;

    private String memId;
    private String memPw;
    private String memNick;
    private Boolean enabled;

    @ManyToMany
    @JoinTable(
            name = "MEMBER_ROLE",
            joinColumns = @JoinColumn(name = "MEMNO"),
            inverseJoinColumns = @JoinColumn(name = "ROLENO"))
    private List<Role> roles;
}
