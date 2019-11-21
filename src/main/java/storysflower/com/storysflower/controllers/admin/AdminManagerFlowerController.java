package storysflower.com.storysflower.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import storysflower.com.storysflower.constants.UrlConstants;
import storysflower.com.storysflower.dto.ReviewDTO;
import storysflower.com.storysflower.services.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(UrlConstants.URL_ADMIN)
public class AdminManagerFlowerController {

    private static final String OCCASION = "occasion";
    private static final String OCCASIONS = "occasions";
    private static final String LIST_OCCASION = "list_occasion";


    private static final String CATEGORIES = "categories";
    private static final String PRODUCT = "product";
    private static final String REVIEWS = "reviews";
    private static final String REVIEWDTO = "reviewDTO";
    private static final String BESTRATINGPRODUCTS = "bestRatingProducts";

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    private OccasionService occasionService;

    @GetMapping({UrlConstants.URL_ADMIN_PRODUCT_INDEX, UrlConstants.URL_ADMIN_PRODUCT_INDEX_ID})
    public String getAllProduct(Model model, HttpServletRequest request, RedirectAttributes redirect,
                                @PathVariable(name = "id", required = false) Long id) {
        if (id == null) id = 1L;
        model.addAttribute(OCCASIONS, occasionService.findAllOccasion());
        model.addAttribute(OCCASION, occasionService.getOccasionDTOById(id));
        model.addAttribute(LIST_OCCASION, productService.getListProductDTOByOccasionId(id));
        return UrlConstants.URL_ADMIN + "/product/index_pr";
    }

    @GetMapping({UrlConstants.URL_ADMIN_PRODUCT_EDIT_ID})
    public String getProductPage(Model model, @PathVariable("id") Long id) {

        if (id == null) id = 1L;
        model.addAttribute(OCCASIONS, occasionService.findAllOccasion());
        model.addAttribute(OCCASION, occasionService.getOccasionDTOById(id));
        model.addAttribute(LIST_OCCASION, productService.getListProductDTOByOccasionId(id));

        model.addAttribute(CATEGORIES, categoryService.getCategories());
        model.addAttribute(PRODUCT, productService.getProductDetailDTOById(id));
        model.addAttribute(REVIEWS, reviewService.getAllReviewsByProductId(id));
        model.addAttribute(REVIEWDTO, new ReviewDTO());
        model.addAttribute(BESTRATINGPRODUCTS, productService.getListBestProductDTOByRatting());
        System.out.println("============================= hello ===================");
        System.out.println(productService.getProductDetailDTOById(id));
        return UrlConstants.URL_ADMIN + "/product/edit_pr";
        // return "product-detail/detail";
    }

    @GetMapping({UrlConstants.URL_ADMIN_PRODUCT_INDEX, UrlConstants.URL_ADMIN_PRODUCT_ADD})
    public String addProduct(Model model, HttpServletRequest request, RedirectAttributes redirect,
                                @PathVariable(name = "id", required = false) Long id) {
        if (id == null) id = 1L;
        model.addAttribute(OCCASIONS, occasionService.findAllOccasion());
        model.addAttribute(OCCASION, occasionService.getOccasionDTOById(id));
        model.addAttribute(LIST_OCCASION, productService.getListProductDTOByOccasionId(id));
        return UrlConstants.URL_ADMIN + "/product/add_pr";
    }


}
