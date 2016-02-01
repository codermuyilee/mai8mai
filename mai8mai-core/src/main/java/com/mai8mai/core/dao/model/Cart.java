package com.mai8mai.core.dao.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="cart")
public class Cart extends BaseModel {

    /**
     * 购物车中的项
     */
    private List<CartItem> cartItems;
    /**
     * 购物车所对应的用户
     */
    private User user;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
