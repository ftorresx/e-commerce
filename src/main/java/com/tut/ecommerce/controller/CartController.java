package com.tut.ecommerce.controller;

import com.tut.ecommerce.common.ApiResponse;
import com.tut.ecommerce.dto.cart.AddToCartDto;
import com.tut.ecommerce.dto.cart.CartDto;
import com.tut.ecommerce.exceptions.AuthenticationFailException;
import com.tut.ecommerce.exceptions.CartItemNotExistException;
import com.tut.ecommerce.exceptions.ProductNotExistException;
import com.tut.ecommerce.model.*;
import com.tut.ecommerce.service.AuthenticationService;
import com.tut.ecommerce.service.CartService;
import com.tut.ecommerce.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private AuthenticationService authenticationService;

    /**
     * METODO QUE PERMITE LISTAR TODOS LOS CARRITOS QUE SE ENCUENTRAN EN EL MOMENTO
     * @param token
     * @return
     * @throws AuthenticationFailException
     */
    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        int userId = authenticationService.getUser(token).getId();
        CartDto cartDto = cartService.listCartItems(userId);
        return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
    }
    
    /**
     * METODO QUE PERMITE ADICIONAR ELEMENTOS AL CARRITO DE COMPRAS 
     * @param addToCartDto
     * @param token
     * @return
     * @throws AuthenticationFailException
     * @throws ProductNotExistException
     */
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam("token") String token) throws AuthenticationFailException, ProductNotExistException {
        authenticationService.authenticate(token);

        int userId = authenticationService.getUser(token).getId();

        cartService.addToCart(addToCartDto,userId);

        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

    }
    
    /**
     * METODO QUE PERMITE ACTUALIZAR UN ELEMENTO DEL CARRITO 
     * @param cartDto
     * @param token
     * @return
     * @throws AuthenticationFailException
     * @throws ProductNotExistException
     */
    @PutMapping("/update/{cartItemId}")
    public ResponseEntity<ApiResponse> updateCartItem(@RequestBody @Valid AddToCartDto cartDto,
                                                      @RequestParam("token") String token) throws AuthenticationFailException,ProductNotExistException {
        authenticationService.authenticate(token);
        int userId = authenticationService.getUser(token).getId();

        Product product = productService.getProductById(cartDto.getProductId());

        cartService.updateCartItem(cartDto,userId,product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

    /**
     * METODO QUE PERMITE BORRAR UN ITEM DEL CARRITO
     * @param itemID
     * @param token
     * @return
     * @throws AuthenticationFailException
     * @throws CartItemNotExistException
     */
    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") String itemID,@RequestParam("token") String token) throws AuthenticationFailException, CartItemNotExistException {
        authenticationService.authenticate(token);

        int userId = authenticationService.getUser(token).getId();

        cartService.deleteCartItem(itemID,userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }

}
