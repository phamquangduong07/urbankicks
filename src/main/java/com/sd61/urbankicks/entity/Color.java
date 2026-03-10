package com.sd61.urbankicks.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "colors")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Color extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 255)

    @Nationalized
    @Column(name = "name", nullable = false, unique = true)
    private String name;


    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "hex_code", nullable = false, length = 10,unique = true)
    private String hexCode;
}