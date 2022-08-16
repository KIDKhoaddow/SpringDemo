package controller;


import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomePageController {
    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("/User")
    public String userListPage() {
        return "adminView/ListUser";
    }

    @GetMapping(value = {"/", "/home"})
    public String homePage() {
        return "adminView/DashBoard";
    }


}
