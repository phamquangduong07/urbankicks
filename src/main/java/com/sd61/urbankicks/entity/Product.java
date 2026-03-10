package com.sd61.urbankicks.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id",unique = true)
    private UUID id;

    @Size(max = 255)
    @Column(name = "code", nullable = false,unique = true)
    private String code;

    @Size(max = 255)
    @Nationalized
    @Column(name = "name", nullable = false,unique = true)
    private String name;

    @Nationalized
    @Lob
    @Column(name = "description")
    private String description;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    @Column(name = "status", nullable = false)
    private Integer status = 1;


}