package fr.shewbii.maplr_sugar_shack.service;

import fr.shewbii.maplr_sugar_shack.models.dto.OrderLineDto;
import fr.shewbii.maplr_sugar_shack.models.dto.OrderValidationResponseDto;
import fr.shewbii.maplr_sugar_shack.models.entity.Product;
import fr.shewbii.maplr_sugar_shack.models.enums.SyrupTypeEnum;
import fr.shewbii.maplr_sugar_shack.repository.OrderLineRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderLineRepository orderLineRepository;

    @Mock
    private ProductService productService;

    @InjectMocks
    private OrderService orderService;

    private final OrderLineDto ORDER_LINE_DTO_1 = new OrderLineDto(1, 1);
    private final OrderLineDto ORDER_LINE_DTO_2 = new OrderLineDto(2, 3);
    private final OrderLineDto ORDER_LINE_DTO_3 = new OrderLineDto(3, -4);
    private final OrderLineDto ORDER_LINE_DTO_4 = new OrderLineDto(4, 1);
    private final OrderLineDto ORDER_LINE_DTO_5 = new OrderLineDto(5, 6);

    private final Product PRODUCT_1 = new Product(1, "Product 1", "Desc", "img1", 1.0, 15, SyrupTypeEnum.AMBER);
    private final Product PRODUCT_2 = new Product(2, "Product 2", "Desc", "img1", 2.0, 15, SyrupTypeEnum.AMBER);
    private final Product PRODUCT_3 = new Product(3, "Product 3", "Desc", "img1", 3.0, 3, SyrupTypeEnum.AMBER);
    private final Product PRODUCT_4 = new Product(4, "Product 4", "Desc", "img1", 4.0, 0, SyrupTypeEnum.AMBER);
    private final Product PRODUCT_5 = new Product(5, "Product 5", "Desc", "img1", 5.0, 5, SyrupTypeEnum.AMBER);

    @Test
    public void placeOrderValid() {
        given(productService.findById(1)).willReturn(Optional.of(PRODUCT_1));
        given(productService.getById(1)).willReturn(PRODUCT_1);
        given(productService.findById(2)).willReturn(Optional.of(PRODUCT_2));
        given(productService.getById(2)).willReturn(PRODUCT_2);

        OrderValidationResponseDto result = orderService.placeOrder(List.of(ORDER_LINE_DTO_1, ORDER_LINE_DTO_2));

        assertTrue(result.isOrderValid());
        assertThat(result.errors()).isEmpty();
    }

    @Test
    public void placeOrderNonExistentProduct() {
        given(productService.findById(1)).willReturn(Optional.empty());
        given(productService.findById(2)).willReturn(Optional.of(PRODUCT_2));

        OrderValidationResponseDto result = orderService.placeOrder(List.of(ORDER_LINE_DTO_1, ORDER_LINE_DTO_2));

        assertFalse(result.isOrderValid());
        assertThat(result.errors()).hasSize(1);
    }

    @Test
    public void placeOrderNegativeQuantity() {
        given(productService.findById(3)).willReturn(Optional.of(PRODUCT_3));

        OrderValidationResponseDto result = orderService.placeOrder(List.of(ORDER_LINE_DTO_3));

        assertFalse(result.isOrderValid());
        assertThat(result.errors()).hasSize(1);
    }

    @Test
    public void placeOrderInvalidQuantities() {
        given(productService.findById(4)).willReturn(Optional.of(PRODUCT_4));
        given(productService.findById(5)).willReturn(Optional.of(PRODUCT_5));

        OrderValidationResponseDto result = orderService.placeOrder(List.of(ORDER_LINE_DTO_4, ORDER_LINE_DTO_5));

        assertFalse(result.isOrderValid());
        assertThat(result.errors()).hasSize(2);
    }
}
