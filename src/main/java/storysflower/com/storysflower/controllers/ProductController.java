package storysflower.com.storysflower.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import storysflower.com.storysflower.services.OccasionService;
import storysflower.com.storysflower.services.ProductService;

/**
 * @author ntynguyen
 */
@Controller
@RequestMapping("/occasion")
public class ProductController {
    public static final String OCCASION = "occasion";
    public static final String OCCASIONS = "occasions";


    @Autowired
    private OccasionService occasionService;

    @Autowired
    private ProductService productService;
    @GetMapping("/{occasionId}")
    public String getOccasionPage(@PathVariable Long occasionId, Model model){
        model.addAttribute(OCCASION, occasionService.getOccasionDTOById(occasionId));
        model.addAttribute(OCCASIONS, productService.getListProductDTOByOccasionId(occasionId));
        return "occasion";
    }
}
