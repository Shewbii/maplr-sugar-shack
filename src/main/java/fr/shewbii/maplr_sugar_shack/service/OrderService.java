package fr.shewbii.maplr_sugar_shack.service;

import fr.shewbii.maplr_sugar_shack.models.dto.OrderLineDto;
import fr.shewbii.maplr_sugar_shack.models.dto.OrderValidationResponseDto;
import fr.shewbii.maplr_sugar_shack.models.entity.Product;
import fr.shewbii.maplr_sugar_shack.repository.OrderLineRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Autowired
    private ProductService productService;

    public OrderValidationResponseDto placeOrder(List<OrderLineDto> lines) {
        List<String> errors = new ArrayList<>();

        for (OrderLineDto line : lines) {
            Optional<Product> optProduct = productService.findById(line.productId());

            if (optProduct.isEmpty()) {
                errors.add(String.format("Impossible de trouver de produit avec l'ID (%s)", line.productId()));
            } else {
                Product product = optProduct.get();
                if (line.qty() < 0) {
                    errors.add(String.format("Une quantité ne peut pas etre negative (%s)", product.getName()));
                } else if (product.getStock() < line.qty()) {
                    errors.add(
                            String.format("Il n'y a pas assez de stock pour cet article (%s - stock : %d - demande : %d)",
                                    product.getName(),
                                    product.getStock(),
                                    line.qty()));
                }
            }
        }

        if (errors.isEmpty()) {
            for (OrderLineDto olDto : lines) {
                Product product = productService.getById(olDto.productId());
                product.setStock(product.getStock() - olDto.qty());
                productService.save(product);
                orderLineRepository.deleteByProduct_Id(product.getId());
            }
        }
        return new OrderValidationResponseDto(errors.isEmpty(), errors);
    }

}
