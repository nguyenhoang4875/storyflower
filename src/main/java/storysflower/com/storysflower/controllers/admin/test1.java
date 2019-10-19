package storysflower.com.storysflower.controllers.admin;

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
@RequestMapping("/test1")
public class test1 {
    @GetMapping()
//    public String getOccasionPage(){
//        return "fragments/admin-fr/header";
//    }
    public String getOccasionPage(){
        return "admin/home_ad";
    }
}
