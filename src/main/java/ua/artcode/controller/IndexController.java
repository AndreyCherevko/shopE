package ua.artcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.artcode.dto.LoginDto;
import ua.artcode.dto.RegistrationDto;
import ua.artcode.exception.InvalidPasswordException;
import ua.artcode.exception.NoSuchFoundProductException;
import ua.artcode.exception.NoUserFoundException;
import ua.artcode.manager.ClientManager;
import ua.artcode.manager.ProductManager;
import ua.artcode.model.Client;
import ua.artcode.model.Product;
import ua.artcode.model.ProductType;
import ua.artcode.utils.MassageManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by andrey on 23.03.15.
 */
@Controller
public class IndexController {

    @Autowired
    private ClientManager clientManager;
    @Autowired
    private ProductManager productManager;
    @Autowired
    MassageManager massageManager;
    public IndexController() {
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    @RequestMapping(value = "/")
    public String home(Model model){
        model.addAttribute("loginDto", new LoginDto());
        model.addAttribute("client",null);
        model.addAttribute("productTypes", ProductType.values());
        return "index";
    }

    @RequestMapping(value = "/registration")
    public String registration(Model model){
        model.addAttribute("regDto", new RegistrationDto());
        return "registration";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginDto") LoginDto client, Model model, HttpServletRequest request) {
        Client currentClient = null;
        try {
            currentClient = clientManager.signIn(client.getLogin(), client.getPass());
            model.addAttribute("client",currentClient);
            request.getSession();
        } catch (Exception e) {
            String massage = massageManager.getMassage(e.getMessage());
            model.addAttribute("errorName",e.getMessage());
            model.addAttribute("mas",massage);
            return "error";
        }
        return "index";
    }
    @RequestMapping(value = "/{slug}")
    public String redirect(HttpServletRequest request,Model model){
        String[] massForUrl = request.getRequestURL().toString().split("/");
        String productName = massForUrl[massForUrl.length-1];
        List<Product> listOfProduct = null;
        try {
            listOfProduct = productManager.getProducts(1,1,ProductType.valueOf(productName));
            model.addAttribute("productName",productName);
            model.addAttribute("listOfProduct",listOfProduct);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "products";
    }
    @RequestMapping(value="/registration")
    public String reg(@ModelAttribute("regDto")RegistrationDto registrationDto, Model model,HttpServletRequest request){
        clientManager.register(registrationDto.getUsername(),registrationDto.getPassword(),registrationDto.getPhone(),registrationDto.getEmail());
        try {
            Client currentClient = clientManager.getClient(registrationDto.getUsername());
            model.addAttribute("client",currentClient);
        } catch (NoUserFoundException e) {
            String massage = massageManager.getMassage(e.getMessage());
            model.addAttribute("errorName",e.getMessage());
            model.addAttribute("mas",massage);
            return "error";
        }
        return "index";
    }
}

