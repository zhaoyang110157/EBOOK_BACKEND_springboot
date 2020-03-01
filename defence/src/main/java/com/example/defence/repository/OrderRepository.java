package com.example.defence.repository;

import com.example.defence.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
    List<Orders> findOrdersById(int id);
    Orders findOrdersByOid(int oid);
}
