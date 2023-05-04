package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller

public class WebController {

//    @RequestMapping("/")
//    public String home(){
//        System.out.println("hi");
//        return "index";
//    }
//
//    @GetMapping("about")
//    public String about(){
//        return "about";
//    }
//*********************************************************

    @Autowired
    UserDao userDao;

    @RequestMapping("/")
    public String home(Model m){
        System.out.println("index page");

        List<User> u=userDao.getUser();
        m.addAttribute("user",u);
        return "index";
    }

    // add product
    @RequestMapping("/add-product")
    public String addProduct(Model m) {
        m.addAttribute("title", "add product");
        return "add_product_form";
    }

    // handle add product form
    @RequestMapping(value = "/handle-product", method = RequestMethod.POST)
    public RedirectView handleProduct(@ModelAttribute User user, HttpServletRequest request) {
        System.out.print(user);
        userDao.createProduct(user);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }

    // delete handler
    @RequestMapping("/delete/{userId}")
    public RedirectView deleteProduct(@PathVariable("userId") int userId, HttpServletRequest request) {
        this.userDao.deleteProduct(userId);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }


    // update product
    @RequestMapping("/update/{userId}")
    public String updateForm(@PathVariable("userId") int userId, Model model) {
        User user = this.userDao.getPtoduct(userId);
        model.addAttribute("user", user);
        return "update_form";
    }

    @RequestMapping(value = "editsave", method = RequestMethod.POST)
    public RedirectView update(@ModelAttribute("user") User user, HttpServletRequest request) {
        this.userDao.setUpdate(user);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }
}
