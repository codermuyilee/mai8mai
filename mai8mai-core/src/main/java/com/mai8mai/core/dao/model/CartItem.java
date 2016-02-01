package com.mai8mai.core.dao.model;

import javax.persistence.*;

@Entity
@Table(name="cart_item")
public class CartItem extends BaseModel {
    /**
     * 商品
     */
    private Goods goods;
    /**
     * 商品个数
     */
    private Integer num;

    private Cart cart;

    @OneToOne
    @JoinColumn(name="goods_id")
    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Column(name="num")
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
