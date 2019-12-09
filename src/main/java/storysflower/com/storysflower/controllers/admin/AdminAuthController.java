package storysflower.com.storysflower.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import storysflower.com.storysflower.constants.UrlConstants;
import storysflower.com.storysflower.services.OccasionService;

@Controller
@RequestMapping(UrlConstants.URL_ADMIN)
public class AdminAuthController {
    private static final String OCCASIONS = "occasions";

    @Autowired
    private OccasionService occasionService;
    @ModelAttribute
    public void leftbar(Model model){
        model.addAttribute(OCCASIONS, occasionService.findAllOccasion());
    }

    @GetMapping(UrlConstants.URL_LOGIN)
    public String index() {
        return "admin/login";
    }

    @GetMapping(UrlConstants.URL_403_)
    public String error403() {
        return "admin/error404";
    }

    @GetMapping(UrlConstants.URL_404_)
    public String error404() {
        return "admin/error404";
    }

}
