package storysflower.com.storysflower.controllers.admin;

import org.mortbay.jetty.servlet.AbstractSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import storysflower.com.storysflower.constants.UrlConstants;
import storysflower.com.storysflower.dto.UserDTO;
import storysflower.com.storysflower.services.UserService;
import storysflower.com.storysflower.utils.ErrorUtil;
import storysflower.com.storysflower.validator.NameUserValidator;
import storysflower.com.storysflower.validator.RePassWordValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(UrlConstants.URL_ADMIN)
public class AdminUserController {
    @Autowired
    UserService userService;
    @Autowired
    RePassWordValidator rePassWordValidator;
    @Autowired
    NameUserValidator nameUserValidator;

    @GetMapping({UrlConstants.URL_ADMIN_USER_INDEX})
    public  String index(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDTO userLogin = userService.findUserByIdUser((long) 1);
        session.setAttribute("userLogin",userLogin);
        List<UserDTO> listUser = userService.findAll();
        model.addAttribute("userLogin", userLogin);
        model.addAttribute("listUser", listUser);
        return "admin/user/index";
    }
    @GetMapping({UrlConstants.URL_ADMIN_USER_EDIT})
    public  String edit(Model model, @PathVariable(value = "id", required = false) Long id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserDTO userDTO = userService.findUserByIdUser(id);
        UserDTO userLogin = (UserDTO) session.getAttribute("userLogin");
        if (userLogin.getRole().equals("ADMIN") || id == userLogin.getId()) {
            model.addAttribute("userDTO", userDTO);
            return "admin/user/edit";
        } else {
            return "admin/error404";
        }
    }
    @PostMapping({UrlConstants.URL_ADMIN_USER_EDIT})
    public  String edit(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult rs, Model model,HttpServletRequest request,
                        @PathVariable(value = "id", required = false) Long id, RedirectAttributes redirec){
        HttpSession session = request.getSession();
        UserDTO userLogin = (UserDTO)session.getAttribute("userLogin");
        userDTO.setId(id);
        boolean check = true;
        if("".equals(userDTO.getPassWord())){
            System.out.println("done");
            String pw= userService.findUserByIdUser(id).getPassWord();
            userDTO.setPassWord(pw);
            userDTO.setRePassWord(pw);
            check = false;
        }
        rePassWordValidator.validate(userDTO,rs);
        nameUserValidator.validate(userDTO, rs);
        if (rs.hasErrors()) {
            List<ObjectError> errorList = rs.getAllErrors();
           if(!check){
               errorList= ErrorUtil.delError(errorList);
           }
            if(errorList.size() != 0) {
                System.out.println("AAA");
                model.addAttribute("userDTO",userService.findUserByIdUser(id));
                model.addAttribute("msg", "Please correct the errors in form!");
                model.addAttribute("rs", rs);
                model.addAttribute("errorList", errorList);
                return "admin/user/edit";
            }
        }
        if(userLogin.getRole().equals("ADMIN")){
            userDTO.setRole("ROLE_ADMIN");
        }else {
            userDTO.setRole("ROLE_USER");
        }
        if(!userService.edit(userDTO)){
        /*error*/
        }
        model.addAttribute("msg", "Thành công");
        return "redirect:"+UrlConstants.URL_ADMIN+UrlConstants.URL_ADMIN_USER_INDEX;
    }

    @GetMapping({UrlConstants.URL_ADMIN_USER_DEL})
    public  String del(Model model, HttpServletRequest request, RedirectAttributes redirec,
                       @PathVariable(value = "id", required = false) Long id){
        HttpSession session = request.getSession();
        UserDTO userLogin = (UserDTO) session.getAttribute("userLogin");
        if(userLogin.getId()==id) return "admin/error404";
        if(!userService.del(id)){
            /*error*/
        }
        redirec.addFlashAttribute("msg", "Xóa thành công");
        System.out.println("xóa thành công");
        return "redirect:"+UrlConstants.URL_ADMIN+UrlConstants.URL_ADMIN_USER_INDEX;
    }
    @GetMapping({UrlConstants.URL_ADMIN_USER_ADD})
    public  String add(Model model, HttpServletRequest request){
        return "admin/user/add";
    }

    @PostMapping({UrlConstants.URL_ADMIN_USER_ADD})
    public  String add(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult rs, Model modelMap){
        rePassWordValidator.validate(userDTO,rs);
        nameUserValidator.validate(userDTO, rs);
        if (rs.hasErrors()) {
            List<ObjectError> errorList =rs.getAllErrors();
            modelMap.addAttribute("userDTO",userDTO);
            modelMap.addAttribute("msg", "Please correct the errors in form!");
            modelMap.addAttribute("rs", rs);
            modelMap.addAttribute("errorList", errorList);
            return "admin/user/add"; // chỉ được dùng return , ko dong redic
        }
        userDTO.setRole("ROLE_USER");
        if(!userService.addUser(userDTO)){
            modelMap.addAttribute("userDTO",userDTO);
            modelMap.addAttribute("msg","Error!");
            return "admin/user/index";
        }
        modelMap.addAttribute("msg","Thành công!");
        return "admin/user/index";
    }
}
