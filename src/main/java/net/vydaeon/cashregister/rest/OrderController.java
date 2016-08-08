package net.vydaeon.cashregister.rest;

import net.vydaeon.cashregister.domain.Order;
import net.vydaeon.cashregister.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * {@link RestController} for Order
 *
 * @author Brad Bottjen
 */
@RestController
@RequestMapping("/orders")
class OrderController {

    private final OrderService orderService;

    @Autowired
    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = POST)
    public Order createOrder() {
        return orderService.createOrder();
    }

    @RequestMapping(value = "/{orderId}/items/{itemName}", method = POST)
    public Order addItem(@PathVariable String orderId, @PathVariable String itemName) {
        return orderService.addItem(orderId, itemName);
    }

    @RequestMapping(value = "/{orderId}/items/{itemName}", method = DELETE)
    public Order removeItem(@PathVariable String orderId, @PathVariable String itemName) {
        return orderService.removeItem(orderId, itemName);
    }
}
