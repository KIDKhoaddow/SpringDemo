package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.ICRUDService;

import java.io.File;
import java.io.IOException;

@Controller
public class ProductPageController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    ICRUDService<Product> productService;

    @ModelAttribute("products")
    public Iterable<Product> productList() {
        return productService.findAll();
    }

    @ModelAttribute("NewProduct")
    public Product newProduct() {
        return new Product();
    }


    @GetMapping("/Product")
    public String productListPage() {
        return "adminView/ListProduct";
    }

    @PostMapping("/Product")
    public String homePage(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        setImageOfCar(product);
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Create Successfully!");
        return "redirect:http://localhost:8080/Product";
    }

    @GetMapping("/{id}")
    public ModelAndView displayProductById(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/adminView/ListProduct");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    private void setImageOfCar(Product product) {
        MultipartFile image = product.getImage();
        String imageUrl = image.getOriginalFilename();
        try {
            FileCopyUtils.copy(image.getBytes(), new File(fileUpload + image.getOriginalFilename()));
        } catch (IOException ex) {
            System.err.println("Error");
        }
        product.setPictureProduct(imageUrl);
    }
}
