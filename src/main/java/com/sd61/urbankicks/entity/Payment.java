package com.sd61.urbankicks.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;


    @Column(name = "payment_method", nullable = false)
    private Integer paymentMethod;

    @Size(max = 255)
    @Column(name = "payment_code")
    private String paymentCode;


    @Column(name = "amount", nullable = false, precision = 18, scale = 2)
    private BigDecimal amount;


    @Column(name = "paid_amount", nullable = false, precision = 18, scale = 2)
    private BigDecimal paidAmount;


    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "paid_at")
    private LocalDateTime paidAt;

    @ColumnDefault("sysdatetime()")
    @Column(name = "created_at")
    private LocalDateTime createdAt;


}