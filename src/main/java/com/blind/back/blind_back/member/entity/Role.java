package com.blind.back.blind_back.member.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long roleNo;

    @NotNull
    private String roleName;

    @ManyToMany(mappedBy="roles")
    private List<Member> members;
}
