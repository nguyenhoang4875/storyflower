package storysflower.com.storysflower.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import storysflower.com.storysflower.dto.CartDTO;
import storysflower.com.storysflower.services.CartService;
import storysflower.com.storysflower.services.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    private static final String CARTS = "carts";
    private static final String TOTALCART = "totalcart";
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String getCartPage(HttpSession httpSession, Model model) {
        List<CartDTO> cartDTOList = (httpSession.getAttribute(CARTS) == null) ? new ArrayList<>() : (List<CartDTO>) httpSession.getAttribute(CARTS);
        model.addAttribute(TOTALCART, cartService.calculateTotal(cartDTOList));
        model.addAttribute(CARTS, cartDTOList);
        return "cart";
    }
}
