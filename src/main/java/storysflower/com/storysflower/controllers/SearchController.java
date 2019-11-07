package storysflower.com.storysflower.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import storysflower.com.storysflower.services.OccasionService;
import storysflower.com.storysflower.services.ProductService;
import storysflower.com.storysflower.services.SearchService;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OccasionService occasionService;
    private static final String FLOWERS = "flowers";
    private static final String OCCASION = "occasions";

    @GetMapping
    public String getSearchPage(@RequestParam("searchKey") String searchKey, Model model) {

        model.addAttribute(FLOWERS, searchService.getListFlowerByKey(searchKey));
        model.addAttribute(OCCASION, occasionService.findAllOccasion());
        return "flower";
    }
}

