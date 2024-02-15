package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public Order createOrder(Order order) throws UserNotFoundException {
        if (!userRepository.existsById(order.getUserId())) {
            throw new UserNotFoundException("Usuário com ID " + order.getUserId() + " não encontrado.");
        }

        // Se o usuário existe, procede com a criação do pedido
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    public List<Order> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }

   /* public Order updateOrder(String id, Order orderDetails) {
        orderDetails.setId(id);
        return orderRepository.save(orderDetails);
    }
*/
   public Order updateOrder(String id, Order orderDetails) throws UserNotFoundException {
       // Primeiro, verifica se o pedido existe
       Order order = orderRepository.findById(id)
               .orElseThrow(() -> new OrderNotFoundException("Pedido com ID " + id + " não encontrado."));

       // Verifica se o usuário existe (se o userId foi fornecido/alterado)
       if (orderDetails.getUserId() != null && !orderDetails.getUserId().isEmpty() && !userRepository.existsById(orderDetails.getUserId())) {
           throw new UserNotFoundException("Usuário com ID " + orderDetails.getUserId() + " não encontrado.");
       }

       // Atualiza os detalhes do pedido, excluindo ou não a atualização do userId baseado na lógica de negócios
       order.setItems(orderDetails.getItems());
       order.setTotal(orderDetails.getTotal());
       // opcionalmente atualiza o userId, se a lógica de negócios permitir
       // order.setUserId(orderDetails.getUserId());

       return orderRepository.save(order);
   }

    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
}