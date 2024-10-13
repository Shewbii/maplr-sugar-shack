package fr.shewbii.maplr_sugar_shack.models.dto;

import fr.shewbii.maplr_sugar_shack.models.enums.SyrupTypeEnum;

public record MapleSyrupDto(
        Integer id,
        String description,
        String image,
        Double price,
        Integer stock,
        SyrupTypeEnum type) {
}
