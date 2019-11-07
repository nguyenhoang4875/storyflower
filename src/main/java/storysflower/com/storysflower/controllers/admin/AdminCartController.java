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
import storysflower.com.storysflower.dto.CartAdminDTO;
import storysflower.com.storysflower.dto.CustomerCartDTO;
import storysflower.com.storysflower.dto.ProductCartDTO;
import storysflower.com.storysflower.dto.RecipientCartDTO;
import storysflower.com.storysflower.services.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(UrlConstants.URL_ADMIN)
public class AdminCartController {
    @Autowired
    BuyProductServicel buyProductServicel;
    @Autowired
    private CartService cartService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private RecipientService recipientService;

    @GetMapping({UrlConstants.URL_ADMIN_CART_INDEX})
    public  String index(Model model, HttpServletRequest request , RedirectAttributes redirect){
        request.getSession().setAttribute("cart", null);
        if(model.asMap().get("success") != null)
            redirect.addFlashAttribute("success",model.asMap().get("success").toString());
        return "redirect:"+UrlConstants.URL_ADMIN+UrlConstants.URL_ADMIN_CART_INDEX +"/1";
    }
    @GetMapping({UrlConstants.URL_ADMIN_CART_INDEX_PAGINATION})
    public String shoListCustomerPage(HttpServletRequest request, @PathVariable int page, Model model) {
        PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("cart");
        List<CartAdminDTO> list = cartService.findAll();
        if (pages == null) {
            pages = new PagedListHolder<>(list);
            pages.setPageSize(CommonConstants.DEFAULT_PAGING_CART_SIZE);
        } else {
            final int goToPage = page - 1;
            if (goToPage <= pages.getPageCount() && goToPage >= 0) {
                pages.setPage(goToPage);
            }
        }
        request.getSession().setAttribute("cart", pages);
        int current = pages.getPage() + 1;
        int begin = Math.max(1, current - list.size());
        int end = Math.min(begin + 5, pages.getPageCount());
        int totalPageCount = pages.getPageCount();
        String baseUrl = UrlConstants.URL_ADMIN+UrlConstants.URL_ADMIN_CART_INDEX+"/";
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("cartlist", pages);
        return "admin/cart/index";
    }
    @GetMapping({UrlConstants.URL_ADMIN_CART_DETAIL})
    public String detail( @PathVariable Long id, Model model) {
        RecipientCartDTO recipientCartDTO = recipientService.findRecipientCartDTObyIdBuyProduct(id);
        CustomerCartDTO customerCartDTO = customerService.findCustomerCartDTOByIdBuyProduct(id);
        ProductCartDTO productCartDTO = productService.findProductCartByIdBuyProduct(id);
        model.addAttribute("recipientCartDTO",recipientCartDTO);
        model.addAttribute("customerCartDTO",customerCartDTO);
        model.addAttribute("productCartDTO",productCartDTO);
        model.addAttribute("id",id);
        return "admin/cart/detail";
    }
    @GetMapping({UrlConstants.URL_ADMIN_CART_ORDER})
    public String order( @PathVariable Long id,  RedirectAttributes redirect) {
        if(buyProductServicel.updateStatusByIdBuyProduct(id)){
            redirect.addFlashAttribute("msg","Thành công");
            return "redirect:"+UrlConstants.URL_ADMIN+UrlConstants.URL_ADMIN_CART_INDEX;
        }else {
            redirect.addFlashAttribute("msg","Error");
            return "redirect:"+UrlConstants.URL_ADMIN+"/cart/detail/"+id;
        }

    }
}
