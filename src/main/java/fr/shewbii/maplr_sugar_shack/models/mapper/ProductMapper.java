package fr.shewbii.maplr_sugar_shack.models.mapper;

import fr.shewbii.maplr_sugar_shack.models.dto.CatalogueItemDto;
import fr.shewbii.maplr_sugar_shack.models.dto.MapleSyrupDto;
import fr.shewbii.maplr_sugar_shack.models.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    MapleSyrupDto toMapleSyrupDto(Product entity);

    @Mapping(target = "maxQty", source = "stock")
    CatalogueItemDto toCatalogueItemDto(Product entity);

    List<CatalogueItemDto> toCatalogueItemDtos(List<Product> entities);

}
