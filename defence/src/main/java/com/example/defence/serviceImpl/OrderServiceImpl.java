package com.example.defence.serviceImpl;

import com.example.defence.dao.BookDAO;
import com.example.defence.dao.OrderDAO;
import com.example.defence.entity.Orderitem;
import com.example.defence.entity.Orders;
import com.example.defence.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private BookDAO bookDAO;

    @Override
    public void addOrder(Orders orders){
        orderDAO.addOrder(orders);
        List<Orderitem> orderitems = orders.getOrderitems();
        for(int i =0 ; i < orderitems.size() ;++i){
            bookDAO.buyBooks(orderitems.get(i).getBid(),orderitems.get(i).getSales());
        }
    }

    @Override
    public Orders getOne(int oid){ return orderDAO.getOne(oid);}

    @Override
    public List<Orders> getAllById(int id){ return orderDAO.getAllById(id);}

    @Override
    public long getOid(){return orderDAO.getOid();}


}
