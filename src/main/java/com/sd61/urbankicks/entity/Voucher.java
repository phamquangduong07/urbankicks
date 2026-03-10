package com.sd61.urbankicks.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "vouchers")
public class Voucher extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 100)
    @Column(name = "code", nullable = false, length = 100)
    private String code;

    @Size(max = 255)
    @Nationalized
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 500)
    @Nationalized
    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "discount_type", nullable = false)
    private Integer discountType;


    @Column(name = "discount_value", nullable = false, precision = 18, scale = 2)
    private BigDecimal discountValue;

    @ColumnDefault("0")
    @Column(name = "min_order_value", precision = 18, scale = 2)
    private BigDecimal minOrderValue;

    @Column(name = "max_discount_value", precision = 18, scale = 2)
    private BigDecimal maxDiscountValue;


    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ColumnDefault("0")
    @Column(name = "used_quantity")
    private Integer usedQuantity;


    @Column(name = "start_date", nullable = false)
    private Instant startDate;


    @Column(name = "end_date", nullable = false)
    private Instant endDate;


    @Column(name = "status", nullable = false)
    private Integer status;


}