package com.sd61.urbankicks.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "sizes")
public class Size extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @Column(name = "size_value", nullable = false, precision = 4, scale = 1)
    private BigDecimal sizeValue;

    @NotNull
    @Column(name = "status", nullable = false)
    private Integer status;


}