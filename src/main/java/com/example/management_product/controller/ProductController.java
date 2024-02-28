package com.example.management_product.controller;

import com.example.management_product.model.Product;
import com.example.management_product.service.IProductService;
import com.example.management_product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private static IProductService iProductService = new ProductService();

    @GetMapping("")
    public String list(Model model) {
        List<Product> products = iProductService.findAll();
        model.addAttribute("products", products);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("products", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        product.setId((int) (Math.random() * 1000));
        iProductService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Product product) {
        iProductService.update(product.getId(), product);
        return "redirect: /products";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes attributes) {
        iProductService.delete(product.getId());
        attributes.addFlashAttribute("success", "remove product successfully");
        return "redirect: /products";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String searchName, Model model) {
        List<Product>products = iProductService.findByName(searchName);
        model.addAttribute("product", products);
        return "/list";
    }

}
