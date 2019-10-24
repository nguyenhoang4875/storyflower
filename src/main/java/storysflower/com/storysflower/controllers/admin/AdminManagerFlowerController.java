package storysflower.com.storysflower.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import storysflower.com.storysflower.constants.UrlConstants;
import storysflower.com.storysflower.dto.ReviewDTO;
import storysflower.com.storysflower.model.tables.tables.Product;
import storysflower.com.storysflower.services.*;

import javax.servlet.http.HttpServletRequest;

import static storysflower.com.storysflower.controllers.ProductController.OCCASION;

@Controller
@RequestMapping(UrlConstants.URL_ADMIN)
public class AdminManagerFlowerController {

    private static final String OCCASION = "occasion";
    private static final String OCCASIONS = "occasions";
    private static final String DEAL_PRODUCT = "dealproducts";
    private static final String CATEGORIES = "categories";
    private static final String PRODUCT = "product";
    private static final String REVIEWS = "reviews";
    private static final String REVIEWDTO = "reviewDTO";
    private static final String BESTRATINGPRODUCTS = "bestRatingProducts";
    @Autowired
    private ProductService productService;

    @Autowired
    private OccasionService occasionService;

    @Autowired
    private DealService dealService;


    @Autowired
    CategoryService categoryService;

    @Autowired
    ReviewService reviewService;

    @GetMapping({UrlConstants.URL_ADMIN_PRODUCT_INDEX})
    public String getAllProduct(Model model, HttpServletRequest request, RedirectAttributes redirect) {
        model.addAttribute(OCCASIONS, occasionService.findAllOccasion());
        model.addAttribute(DEAL_PRODUCT, dealService.findAllDealProducts());


        //model.addAttribute(OCCASION, occasionService.getOccasionDTOById(1L));
        model.addAttribute("temp", productService.getListProductDTOByOccasionId(1L));

        System.out.println("size list product: ");
        System.out.println(productService.getListProductDTOByOccasionId(1L).size());

        model.addAttribute(CATEGORIES, categoryService.getCategories());
        model.addAttribute(PRODUCT, productService.getProductDetailDTOById(1L));
        model.addAttribute(REVIEWS, reviewService.getAllReviewsByProductId(1L));
        model.addAttribute(REVIEWDTO, new ReviewDTO());
        System.out.println(productService.getListBestProductDTOByRatting());
        model.addAttribute(BESTRATINGPRODUCTS, productService.getListBestProductDTOByRatting());
        return UrlConstants.URL_ADMIN + "/product/index_pr";
    }


}
