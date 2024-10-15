package fr.shewbii.maplr_sugar_shack.service;

import fr.shewbii.maplr_sugar_shack.exception.IncorrectDataException;
import fr.shewbii.maplr_sugar_shack.exception.QuantityException;
import fr.shewbii.maplr_sugar_shack.models.entity.OrderLine;
import fr.shewbii.maplr_sugar_shack.models.entity.Product;
import fr.shewbii.maplr_sugar_shack.models.enums.SyrupTypeEnum;
import fr.shewbii.maplr_sugar_shack.repository.OrderLineRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

    @Mock
    private OrderLineRepository orderLineRepository;

    @Mock
    private ProductService productService;

    @InjectMocks
    private CartService cartService;

    private final Product PRODUCT_1 = new Product(1, "Product 1", "Desc", "img1", 1.0, 5, SyrupTypeEnum.AMBER);
    private final Integer PRODUCT_1_NEW_QUANTITY_VALID = 2;
    private final Integer PRODUCT_1_NEW_QUANTITY_INVALID = 12;
    private final OrderLine ORDER_LINE_1 = new OrderLine(1, 1, PRODUCT_1);

    @Test
    public void givenInvalidQuantity_throwBadRequestException() {
        given(productService.findById(any())).willReturn(Optional.of(PRODUCT_1));
        given(orderLineRepository.findByProduct(any())).willReturn(Optional.of(ORDER_LINE_1));

        assertThrows(QuantityException.class, () -> cartService.changeQty(PRODUCT_1.getId(), PRODUCT_1_NEW_QUANTITY_INVALID));
    }

    @Test
    public void givenValidQuantity_shouldUpdateProductStock() {
        given(productService.findById(any())).willReturn(Optional.of(PRODUCT_1));
        given(orderLineRepository.findByProduct(any())).willReturn(Optional.of(ORDER_LINE_1));
        given(orderLineRepository.save(ORDER_LINE_1)).willReturn(ORDER_LINE_1);

        OrderLine updatedOrderLine = cartService.changeQty(PRODUCT_1.getId(), PRODUCT_1_NEW_QUANTITY_VALID);
        assertEquals(PRODUCT_1_NEW_QUANTITY_VALID, updatedOrderLine.getQuantity());
    }

    @Test
    public void givenInvalidProduct_throwBadRequestException() {
        given(productService.findById(any())).willReturn(Optional.empty());

        assertThrows(IncorrectDataException.class, () -> cartService.changeQty(PRODUCT_1.getId(), PRODUCT_1_NEW_QUANTITY_INVALID));
    }

}
