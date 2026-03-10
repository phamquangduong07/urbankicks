package com.sd61.urbankicks.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "sizes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Size extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;


    @Column(name = "size_value", nullable = false, precision = 4, scale = 1,unique = true)
    private BigDecimal sizeValue;

    @Column(name = "status", nullable = false)
    private Integer status;

}