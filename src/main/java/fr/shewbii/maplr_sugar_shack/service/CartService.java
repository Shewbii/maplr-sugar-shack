package fr.shewbii.maplr_sugar_shack.service;

import fr.shewbii.maplr_sugar_shack.exception.EntityNotFoundException;
import fr.shewbii.maplr_sugar_shack.exception.IncorrectDataException;
import fr.shewbii.maplr_sugar_shack.exception.QuantityException;
import fr.shewbii.maplr_sugar_shack.models.dto.CartLineDto;
import fr.shewbii.maplr_sugar_shack.models.entity.OrderLine;
import fr.shewbii.maplr_sugar_shack.models.entity.Product;
import fr.shewbii.maplr_sugar_shack.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private OrderLineRepository repository;

    @Autowired
    private ProductService productService;

    public List<CartLineDto> getCart() {
        return repository.findAll().stream()
                .map(ol -> new CartLineDto(
                        ol.getProduct().getId(),
                        ol.getProduct().getImage(),
                        ol.getProduct().getName(),
                        ol.getProduct().getPrice(),
                        ol.getQuantity()))
                .toList();
    }

    public OrderLine addToCart(Integer productId) {
        Product product = productService.findById(productId).orElseThrow(IncorrectDataException::new);
        Optional<OrderLine> optOrderLine = repository.findByProduct(product);
        OrderLine orderLine = new OrderLine();
        if (optOrderLine.isPresent()) {
            orderLine = optOrderLine.get();
        }
        orderLine.setProduct(product);
        orderLine.setQuantity(orderLine.getQuantity() + 1);
        return repository.save(orderLine);
    }

    public void removeFromCart(Integer productId) {
        repository.deleteByProduct_Id(productId);
    }

    public OrderLine changeQty(Integer productId, Integer newQty) {
        Product product = productService.findById(productId).orElseThrow(IncorrectDataException::new);
        OrderLine cartLine = repository.findByProduct(product)
                .orElseThrow(() -> new EntityNotFoundException(OrderLine.class.getName()));
        if (newQty > product.getStock()) {
            throw new QuantityException(newQty, product.getStock());
        }
        cartLine.setQuantity(newQty);
        return repository.save(cartLine);
    }
}
