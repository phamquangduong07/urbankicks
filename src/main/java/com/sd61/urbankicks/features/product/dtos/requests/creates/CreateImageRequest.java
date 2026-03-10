package com.sd61.urbankicks.features.product.dtos.requests.creates;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateImageRequest {
    @NotNull(message = "Color is required")
    @JsonProperty("color_id")
    private UUID colorId;

    @NotBlank(message = "Image url is required")
    @Size(max = 500, message = "Image url must be less than 500 characters")
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("is_thumbnail")
    private Boolean isThumbnail = false;

}
