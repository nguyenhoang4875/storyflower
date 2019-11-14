package storysflower.com.storysflower.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import storysflower.com.storysflower.constants.UrlConstants;
import storysflower.com.storysflower.services.OccasionService;
import storysflower.com.storysflower.services.ProductService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(UrlConstants.URL_ADMIN)
public class AdminManagerFlowerController {

    private static final String OCCASION = "occasion";
    private static final String OCCASIONS = "occasions";
    private static final String LIST_OCCASION = "list_occasion";

    @Autowired
    private ProductService productService;

    @Autowired
    private OccasionService occasionService;

    @GetMapping({UrlConstants.URL_ADMIN_PRODUCT_INDEX,UrlConstants.URL_ADMIN_PRODUCT_INDEX_ID})
    public String getAllProduct(Model model, HttpServletRequest request, RedirectAttributes redirect,
                                @PathVariable(name = "id", required = false) Long id) {
        if(id == null)  id= 1L;
        System.out.println(id);
        model.addAttribute(OCCASIONS, occasionService.findAllOccasion());
        model.addAttribute(OCCASION, occasionService.getOccasionDTOById(id));
        model.addAttribute(LIST_OCCASION, productService.getListProductDTOByOccasionId(id));
        return UrlConstants.URL_ADMIN + "/product/index_pr";
    }


}
