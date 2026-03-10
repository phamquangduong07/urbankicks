package com.sd61.urbankicks.features.product.dtos.requests.updates;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateImageRequest {
    private UUID id;

    @NotNull(message = "Color is required")
    private UUID colorId;

    @NotBlank(message = "Image url is required")
    @Size(max = 500, message = "Image url must be less than 500 characters")
    @JsonProperty("image_url")
    private String imageUrl;

    private Boolean isThumbnail ;
}
