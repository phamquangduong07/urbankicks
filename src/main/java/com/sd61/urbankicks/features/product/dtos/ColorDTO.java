package com.sd61.urbankicks.features.product.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ColorDTO {
    @NotBlank(message = "Màu không được để trống")
    @Size(max = 255, message = "Tên màu tối đa 255 ký tự")
    private String name;

    @NotNull(message = "Trạng thái không được để trống")
    private Integer status;

    @NotBlank(message = "Mã màu không được để trống")
    @JsonProperty("hex_code")
    @Pattern(
            regexp = "^#([A-Fa-f0-9]{6})$",
            message = "Mã màu phải đúng định dạng HEX (#RRGGBB)"
    )
    private String hexCode;
}
