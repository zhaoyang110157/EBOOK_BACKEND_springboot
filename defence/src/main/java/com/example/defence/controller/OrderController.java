package com.example.defence.controller;
import com.example.defence.entity.Orders;
import com.example.defence.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/Orders")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/getAll" , method = RequestMethod.GET)
    public List<Orders> getAll(@RequestParam int id){
        System.out.print(id+"'s orders show \n");
        return orderService.getAllById(id);
    }

    @PostMapping("addOrders")
    public void addOrder(@RequestBody Orders orders){
        System.out.print("addOrders started\n" );
        int oid = (int)orderService.getOid()+1;
        System.out.print("oid "+orders.getOid()+" id "+orders.getId() + "\n");
        orders.setOid(oid);
        orders.setItemOid(oid);
        orderService.addOrder(orders);
    }

}
