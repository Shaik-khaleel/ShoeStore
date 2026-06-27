package com.shoes.servlets;

import java.io.IOException;
import java.util.List;

import com.shoes.DAOImpl.CartDAOImpl;
import com.shoes.DAOImpl.OrderDAOImpl;
import com.shoes.DAOImpl.OrderItemDAOImpl;
import com.shoes.DAOImpl.ShoeDAOImpl;
import com.shoes.model.Cart;
import com.shoes.model.Order;
import com.shoes.model.OrderItem;
import com.shoes.model.Shoe;
import com.shoes.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String customerName = request.getParameter("customerName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        CartDAOImpl cartDAO = new CartDAOImpl();
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        OrderItemDAOImpl itemDAO = new OrderItemDAOImpl();
        ShoeDAOImpl shoeDAO = new ShoeDAOImpl();

        List<Cart> cartList = cartDAO.getCartItems(user.getId());

        System.out.println("Cart Size = " + cartList.size());

        for (Cart cart : cartList) {

            // Check stock
            Shoe shoe = shoeDAO.getShoeById(cart.getShoeId());

            if (shoe == null) {

                response.getWriter().println("Shoe not found.");
                return;
            }

            if (shoe.getStock() < cart.getQuantity()) {

                response.getWriter().println(
                        "Sorry! Only " + shoe.getStock()
                        + " item(s) available for "
                        + shoe.getShoeName());

                return;
            }

            // Create Order
            Order order = new Order();

            order.setUserId(user.getId());
            order.setShoeId(cart.getShoeId());
            order.setShoeName(cart.getShoeName());
            order.setImage(cart.getImage());
            order.setSize(cart.getSize());
            order.setQuantity(cart.getQuantity());
            order.setPrice(cart.getPrice());
            order.setTotal(cart.getPrice() * cart.getQuantity());

            order.setCustomerName(customerName);
            order.setPhone(phone);
            order.setAddress(address);

            boolean orderSaved = orderDAO.placeOrder(order);

            System.out.println("Order Saved = " + orderSaved);

            if (orderSaved) {

                int orderId = orderDAO.getLastOrderId();

                System.out.println("Last Order ID = " + orderId);

                OrderItem item = new OrderItem();

                item.setOrderId(orderId);
                item.setShoeId(cart.getShoeId());
                item.setQuantity(cart.getQuantity());
                item.setPrice(cart.getPrice());

                boolean itemSaved = itemDAO.addOrderItem(item);

                System.out.println("Order Item Saved = " + itemSaved);

                // Reduce Stock
                boolean stockUpdated = shoeDAO.reduceStock(
                        cart.getShoeId(),
                        cart.getQuantity());

                System.out.println("Stock Updated = " + stockUpdated);
            }
        }

        response.sendRedirect("MyOrdersServlet");
    }
}