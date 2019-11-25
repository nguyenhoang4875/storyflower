package storysflower.com.storysflower.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import storysflower.com.storysflower.constants.UrlConstants;

@Controller
@RequestMapping(UrlConstants.URL_ADMIN)
public class AdminAuthController {

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
