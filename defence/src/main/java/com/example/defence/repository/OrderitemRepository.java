package com.example.defence.repository;

import com.example.defence.entity.Orderitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderitemRepository extends JpaRepository<Orderitem,Integer> {
    List<Orderitem> findOrderitemsByOid(int oid);
}
