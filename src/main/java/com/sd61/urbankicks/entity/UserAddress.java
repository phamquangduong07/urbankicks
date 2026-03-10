package com.sd61.urbankicks.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "user_addresses")
public class UserAddress extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Size(max = 50)
    @Nationalized
    @Column(name = "label_addresses", nullable = false, length = 50)
    private String labelAddresses;

    @Size(max = 255)
    @Nationalized
    @Column(name = "receiver_name", nullable = false)
    private String receiverName;

    @Size(max = 15)
    @Column(name = "receiver_phone", nullable = false, length = 15)
    private String receiverPhone;

    @Size(max = 500)
    @Nationalized
    @Column(name = "address_detail", nullable = false, length = 500)
    private String addressDetail;

    @Column(name = "ghn_province_id", nullable = false)
    private Integer ghnProvinceId;

    @Column(name = "ghn_district_id", nullable = false)
    private Integer ghnDistrictId;

    @Size(max = 50)
    @Column(name = "ghn_ward_code", nullable = false, length = 50)
    private String ghnWardCode;

    @ColumnDefault("0")
    @Column(name = "is_default", nullable = false)
    private Boolean isDefault;

    @ColumnDefault("0")
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;


}