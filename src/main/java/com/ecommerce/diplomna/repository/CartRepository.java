package com.ecommerce.diplomna.repository;

import com.ecommerce.diplomna.model.Cart;
import com.ecommerce.diplomna.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}
