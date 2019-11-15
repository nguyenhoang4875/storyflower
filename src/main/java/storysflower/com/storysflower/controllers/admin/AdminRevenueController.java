package storysflower.com.storysflower.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import storysflower.com.storysflower.constants.UrlConstants;
import storysflower.com.storysflower.dto.RevenueDTO;
import storysflower.com.storysflower.services.RevenueService;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(UrlConstants.URL_ADMIN)
public class AdminRevenueController {
    @Autowired
    RevenueService revenueService;

    @GetMapping({UrlConstants.URL_ADMIN_REVENUE_INDEX})
    public  String edit(Model model, @PathVariable(value = "id", required = false) Long id, HttpServletRequest request) {
        List<RevenueDTO> listRevenueDTOS = revenueService.findAllRevenue();
        model.addAttribute("listRevenueDTOS", listRevenueDTOS);
        return "admin/revenue/index";
    }
    @GetMapping({UrlConstants.URL_ADMIN_REVENUE_DETAIL})
    public String detail(Model model,@PathVariable(value = "date", required = false) String date){

        RevenueDTO revenueDTO = revenueService.findRevenueDTOByDate(date);
        if(revenueDTO == null) return  "";
        model.addAttribute("revenueDTO",revenueDTO);
        return "admin/revenue/detail";
    }

    @GetMapping({UrlConstants.URL_ADMIN_REVENUE_SEARCH})
    public String search(){
        return "redirect:"+UrlConstants.URL_ADMIN+UrlConstants.URL_ADMIN_REVENUE_INDEX;
    }

    @PostMapping({UrlConstants.URL_ADMIN_REVENUE_SEARCH})
    public  String edit(Model model, @RequestParam(value = "bdaymonth") String bdaymonth){
        if("".equals(bdaymonth))  return "redirect:"+UrlConstants.URL_ADMIN+UrlConstants.URL_ADMIN_REVENUE_INDEX;
        String month =  bdaymonth.split("-")[1];
        String year = bdaymonth.split("-")[0];
        RevenueDTO revenueDTO = revenueService.findRevenueDTOByDate(month+"-"+year);

        if(revenueDTO == null) {
            revenueDTO = new RevenueDTO();
            revenueDTO.setDate(month+"-"+year);
            revenueDTO.setTotalMoney(0.0);
        }
        model.addAttribute("revenueDTO",revenueDTO);
        return "admin/revenue/detail";
    }

}
