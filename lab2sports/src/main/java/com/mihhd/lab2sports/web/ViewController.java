//package com.mihhd.lab2sports.web;
//
//import com.mihhd.lab2sports.service.CategoryService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("lab/eimt")
//public class ViewController {
//    private CategoryService categoryService;
//
//    @GetMapping("/")
//    public String getIndex(){
//        return "index";
//    }
//
//    @GetMapping("/menu")
//    public String getMenu (Model model){
//        model.addAttribute("category", this.categoryService.findAllCategories());
//        return "menu";
//    }
//
//    @GetMapping("/menu/{id}")
//    public String getCategoryMenu (Model model, @PathVariable("id") Long id){
//        model.addAttribute("category", this.categoryService.findCategoryById(id));
//        return"categoryMenu";
//    }
//}
