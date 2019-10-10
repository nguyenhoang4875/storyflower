package storysflower.com.storysflower.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import storysflower.com.storysflower.dto.ProductDTO;

import java.util.Arrays;
import java.util.List;

/**
 * @author ntynguyen
 */
@Controller
@RequestMapping("api/test")
public class Test {
    @RequestMapping(
            method= RequestMethod.POST,
            consumes="application/json")
    public @ResponseBody
    List<String> test(@RequestBody ProductDTO spittle) {
        return Arrays.asList("a", "b");
    }

}
