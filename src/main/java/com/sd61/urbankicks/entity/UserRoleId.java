package com.sd61.urbankicks.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class UserRoleId implements Serializable {
    private static final long serialVersionUID = 5268911771778952303L;
    @Column(name = "user_id", nullable = false)
    private UUID userId;


    @Column(name = "role_id", nullable = false)
    private UUID roleId;


}