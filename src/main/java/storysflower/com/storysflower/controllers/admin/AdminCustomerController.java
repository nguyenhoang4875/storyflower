package storysflower.com.storysflower.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import storysflower.com.storysflower.constants.CommonConstants;
import storysflower.com.storysflower.constants.UrlConstants;
import storysflower.com.storysflower.dto.UserProfileDTO;
import storysflower.com.storysflower.services.UserService;

import java.util.List;

@Controller
@RequestMapping(UrlConstants.URL_ADMIN)
public class AdminCustomerController {

    @Autowired
    UserService userService;

    @GetMapping({UrlConstants.URL_ADMIN_CUSTOMER_INDEX, UrlConstants.URL_ADMIN_CUSTOMER_INDEX_PAGINATION})
    public String index(Model model, @PathVariable(name = "page", required = false) Integer page) {
        if (page == null) {
            page = 1;
        }
        int offset = (page - 1) * CommonConstants.DEFAULT_PAGING_CUSTOMER_SIZE;
        int countPagination = userService.countPagination();
        int totalPage = (int) Math.ceil((float) countPagination / CommonConstants.DEFAULT_PAGING_CUSTOMER_SIZE);

        List<UserProfileDTO> listUserProfile = userService.findAllPagination(offset,CommonConstants.DEFAULT_PAGING_CUSTOMER_SIZE);
        for (UserProfileDTO u: listUserProfile) {
            String name =Character.toString(u.getFisrtName().charAt(0)).toUpperCase();
            u.setFisrtName(name+u.getFisrtName().substring(1)+" ");

            String name1 =Character.toString(u.getLastName().charAt(0)).toUpperCase();
            u.setLastName(name1+u.getLastName().substring(1)+" ");

        }
        model.addAttribute("listUserProfile", listUserProfile );
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        return "admin/customer/index";
    }

}
