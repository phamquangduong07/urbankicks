package com.sd61.urbankicks.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "product_variants",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_product_variant",
                        columnNames = {"product_id", "size_id", "color_id"}
                )
        }
)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "size_id", nullable = false)
    private Size size;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;


    @Column(name = "price", nullable = false, precision = 18, scale = 2)
    private BigDecimal price;

    @Column(name = "cost", precision = 18, scale = 2)
    private BigDecimal cost;


    @ColumnDefault("0")
    @Column(name = "stock", nullable = false)
    private Integer stock;



    @Column(name = "status", nullable = false)
    private Integer status =1 ;



}