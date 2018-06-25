package com.mihhd.lab2sports.web.controllers;

import com.mihhd.lab2sports.config.Layout;
import com.mihhd.lab2sports.model.Manufacturer;
import com.mihhd.lab2sports.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manufacturer")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @Layout("layout/master")
    @GetMapping("/add")
    public String addManufacturer(Model model){
        Manufacturer manufacturer = new Manufacturer();
        model.addAttribute("manufacturer", manufacturer);
        return "forms/manufacturer.Add";
    }

    @Layout("layout/master")
    @PostMapping("/save")
    public String saveManufacturer(@ModelAttribute Manufacturer manufacturer) {
        manufacturerService.save(manufacturer);
        return "common/success";
    }

}
