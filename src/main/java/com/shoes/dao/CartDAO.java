package com.shoes.dao;

import java.util.List;

import com.shoes.model.Cart;

public interface CartDAO {

    boolean addToCart(Cart cart);

    List<Cart> getCartItems(int userId);

    boolean removeCartItem(int cartId);
    
    boolean updateQuantity(int cartId, int quantity);

    boolean clearCart(int userId);
    
 
}