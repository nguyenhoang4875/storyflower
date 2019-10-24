package storysflower.com.storysflower.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import storysflower.com.storysflower.constants.UrlConstants;
import storysflower.com.storysflower.model.tables.tables.Product;
import storysflower.com.storysflower.services.DealService;
import storysflower.com.storysflower.services.OccasionService;
import storysflower.com.storysflower.services.ProductService;

import javax.servlet.http.HttpServletRequest;

import static storysflower.com.storysflower.controllers.ProductController.OCCASION;

@Controller
@RequestMapping(UrlConstants.URL_ADMIN)
public class AdminManagerFlowerController {

    private static final String OCCASION = "occasions";
    private static final String DEAL_PRODUCT = "dealproducts";
    @Autowired
    private ProductService productService;

    @Autowired
    private OccasionService occasionService;

    @Autowired
    private DealService dealService;

    @GetMapping({UrlConstants.URL_ADMIN_PRODUCT_INDEX})
    public String getAllProduct(Model model, HttpServletRequest request, RedirectAttributes redirect) {
        model.addAttribute(OCCASION, occasionService.findAllOccasion());
        model.addAttribute(DEAL_PRODUCT, dealService.findAllDealProducts());
        return UrlConstants.URL_ADMIN + "/product/index_pr";

    }


}
