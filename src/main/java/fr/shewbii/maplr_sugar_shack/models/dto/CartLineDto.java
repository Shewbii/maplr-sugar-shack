package fr.shewbii.maplr_sugar_shack.models.dto;

public record CartLineDto(
        Integer productId,
        String image,
        String name,
        Double price,
        Integer qty
) {
}
