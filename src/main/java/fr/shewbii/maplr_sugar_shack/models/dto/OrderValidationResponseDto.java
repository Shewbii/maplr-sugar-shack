package fr.shewbii.maplr_sugar_shack.models.dto;

import java.util.List;

public record OrderValidationResponseDto(Boolean isOrderValid, List<String> errors) {
}
