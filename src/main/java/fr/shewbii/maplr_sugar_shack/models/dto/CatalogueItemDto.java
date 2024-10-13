package fr.shewbii.maplr_sugar_shack.models.dto;

import fr.shewbii.maplr_sugar_shack.models.enums.SyrupTypeEnum;

public record CatalogueItemDto(
        Integer id,
        String name,
        String image,
        Double price,
        Integer maxQty,
        SyrupTypeEnum type
) {
}
