package com.omkar.ordertracker.repository;

import com.omkar.ordertracker.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // ✅ Add this if not already present
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByOrderId(String orderId);

    @Query(value = "SELECT * FROM orders WHERE status = :status", nativeQuery = true)
    List<Order> findByStatus(@Param("status") String status);
}
