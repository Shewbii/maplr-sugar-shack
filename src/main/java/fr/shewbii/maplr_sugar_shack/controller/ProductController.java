package fr.shewbii.maplr_sugar_shack.controller;

import fr.shewbii.maplr_sugar_shack.models.dto.CatalogueItemDto;
import fr.shewbii.maplr_sugar_shack.models.dto.MapleSyrupDto;
import fr.shewbii.maplr_sugar_shack.models.enums.SyrupTypeEnum;
import fr.shewbii.maplr_sugar_shack.models.mapper.ProductMapper;
import fr.shewbii.maplr_sugar_shack.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductMapper mapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CatalogueItemDto> getCatalogue(@RequestParam(required = false) SyrupTypeEnum type) {
        return mapper.toCatalogueItemDtos(service.findAll(type));
    }

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public MapleSyrupDto getProductInfo(@PathVariable Integer productId) {
        return mapper.toMapleSyrupDto(service.getById(productId));
    }

}
