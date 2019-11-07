package storysflower.com.storysflower.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import storysflower.com.storysflower.services.OccasionService;
import storysflower.com.storysflower.services.ProductService;

@Controller
@RequestMapping("/giftandsweet")
public class GiftSweetController {
    @Autowired
    private ProductService productService;

    private static final String FLOWERS = "flowers";
    @GetMapping()
    public String getOccasionPage(Model model){
        model.addAttribute(FLOWERS, productService.getAllGitfAndSweet());
        return "flower";
    }
}
