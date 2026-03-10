package com.sd61.urbankicks.features.product.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SizeRequest {
    @NotNull(message = "Giá trị size không được để trống")
    @DecimalMin(value = "0.0", inclusive = false, message = "Size phải lớn hơn 0")
    @DecimalMax(value = "99.9", message = "Size tối đa là 99.9")
    @Digits(integer = 2, fraction = 1, message = "Size tối đa 2 số nguyên và 1 số thập phân (VD: 38.5)")
    @JsonProperty("size_value")
    private BigDecimal sizeValue;

    @NotNull(message = "Trạng thái không được để trống")
    private Integer status;
}
