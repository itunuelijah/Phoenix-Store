package com.phoenix.data.repository;

import com.phoenix.data.models.Cart;
import com.phoenix.data.models.Item;
import com.phoenix.data.models.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = {"/db/insert.sql"})
@Slf4j
class CartRepositoryTest {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Add an item to cart test")
    void addProductToCart(){
        Product product = productRepository.findByName("Macbook Air")
                .orElse(null);
        assertThat(product).isNotNull();

        Item item = Item.builder().product(product).quantityAddedToCart(2).build();

        assertThat(item.getProduct()).isNotNull();
        assertThat(item.getQuantityAddedToCart()).isEqualTo(2);
        Cart cart = new Cart();
        cart.addItem(item);


        cartRepository.save(cart);
        assertThat(cart.getId()).isNotNull();
        assertThat(cart.getItemList().isEmpty()).isFalse();
        assertThat(cart.getItemList().get(0).getProduct()).isNotNull();
        log.info("cart object saved --> {}", cart);
    }

    @Test
    @DisplayName("View all items in a cart")
    void viewItemsInCartTest(){
        //get a cart by id
        Cart savedCart = cartRepository.findById(345L).orElse(null);
        assertThat(savedCart).isNotNull();
        assertThat(savedCart.getItemList().size()).isEqualTo(3);
        //print items
        log.info("Cart Retrieved from DB :: {}", savedCart);
    }


    @Test
    @DisplayName("Update an item in cart test")
    void updateItemInCartTest(){

        Cart savedCart = cartRepository.findById(355L).orElse(null);
        assertThat(savedCart).isNotNull();
        assertThat(savedCart.getItemList().size()).isEqualTo(1);
        assertThat(savedCart.getItemList().get(0).getQuantityAddedToCart()).isEqualTo(3);

        Item item = savedCart.getItemList().get(0);
        item.setQuantityAddedToCart(5);

        cartRepository.save(savedCart);

        assertThat(savedCart.getItemList().get(0).getQuantityAddedToCart()).isEqualTo(5);

    }
}