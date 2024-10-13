package fr.shewbii.maplr_sugar_shack.controller;

import fr.shewbii.maplr_sugar_shack.models.dto.OrderLineDto;
import fr.shewbii.maplr_sugar_shack.models.dto.OrderValidationResponseDto;
import fr.shewbii.maplr_sugar_shack.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public OrderValidationResponseDto placeOrder(@RequestBody List<OrderLineDto> lines) {
        return orderService.placeOrder(lines);
    }

}
