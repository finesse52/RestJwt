package finesse52.restjwtproject.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {
    @GetMapping("/insecurity")
    public String getInsecurityPage() {
        return "Insecurity Page";
    }
}
