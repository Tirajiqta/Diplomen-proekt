package com.ecommerce.diplomna.controller;

import com.ecommerce.diplomna.dto.checkout.CheckoutItemDto;

import com.ecommerce.diplomna.dto.checkout.StripeResponse;

import com.ecommerce.diplomna.service.AuthenticationService;
import com.ecommerce.diplomna.service.OrderService;

import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private OrderService orderService;

    // stripe session checkout api

    @PostMapping("/create-checkout-session")
    public ResponseEntity<StripeResponse> checkoutList(@RequestBody List<CheckoutItemDto> checkoutItemDtoList)
            throws StripeException {
        Session session = orderService.createSession(checkoutItemDtoList);
        StripeResponse stripeResponse = new StripeResponse(session.getId());
        return new ResponseEntity<>(stripeResponse, HttpStatus.OK);

    }
}
