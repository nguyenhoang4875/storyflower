package storysflower.com.storysflower.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import storysflower.com.storysflower.services.OccasionService;
import storysflower.com.storysflower.services.ProductService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ntynguyen
 */
@Controller
@RequestMapping("/ajax/active")
public class test1 {
    @PostMapping()
//    public String getOccasionPage(){
//        return "fragments/admin-fr/header";
//    }
    public void getOccasionPage(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<p>Hello</p>");
    }
}
