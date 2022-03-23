package com.blind.back.blind_back.member.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="mem_no")
    private Long memNo;


    private String memId;
    private String memPw;
    @Column(name="mem_nick")
    private String memNick;
    @Column(name="enabled")
    private Boolean enabled;

    @ManyToMany
    @JoinTable(name = "member_role",
               joinColumns = @JoinColumn(name = "mem_no"),
               inverseJoinColumns = @JoinColumn(name = "role_no"))
    private List<Role> roles = new ArrayList<>();
}
