package storysflower.com.storysflower.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import storysflower.com.storysflower.constants.CommonConstants;
import storysflower.com.storysflower.constants.UrlConstants;
import storysflower.com.storysflower.dto.UserProfileDTO;
import storysflower.com.storysflower.services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(UrlConstants.URL_ADMIN)
public class AdminCustomerController {

    @Autowired
    UserService userService;

    @GetMapping({UrlConstants.URL_ADMIN_CUSTOMER_INDEX})
        public String index(Model model, HttpServletRequest request , RedirectAttributes redirect) {
            request.getSession().setAttribute("customer", null);
            if(model.asMap().get("success") != null)
                redirect.addFlashAttribute("success",model.asMap().get("success").toString());
            return "redirect:"+UrlConstants.URL_ADMIN+UrlConstants.URL_ADMIN_CUSTOMER_INDEX +"/1";

    }
    @GetMapping({UrlConstants.URL_ADMIN_CUSTOMER_INDEX_PAGINATION})
    public String shoListCustomerPage(HttpServletRequest request,@PathVariable int page, Model model) {

        PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("customer");
        List<UserProfileDTO> list =(List<UserProfileDTO>) userService.findAll();
        System.out.println(list.size());
        System.out.println(list.size());
        if (pages == null) {
            pages = new PagedListHolder<>(list);
            pages.setPageSize(CommonConstants.DEFAULT_PAGING_CUSTOMER_SIZE);
        } else {
            final int goToPage = page - 1;
            if (goToPage <= pages.getPageCount() && goToPage >= 0) {
                pages.setPage(goToPage);
            }
        }
        request.getSession().setAttribute("customer", pages);
        int current = pages.getPage() + 1;
        int begin = Math.max(1, current - list.size());
        int end = Math.min(begin + 5, pages.getPageCount());
        int totalPageCount = pages.getPageCount();
        String baseUrl = UrlConstants.URL_ADMIN+UrlConstants.URL_ADMIN_CUSTOMER_INDEX+"/";

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("customerlist", pages);

        return "admin/customer/index";
    }

}
