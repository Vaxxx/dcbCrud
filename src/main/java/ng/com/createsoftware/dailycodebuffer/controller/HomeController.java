package ng.com.createsoftware.dailycodebuffer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${welcome.message.config}")
    private String welcomeMsg;

    @GetMapping("/")
    public String vaxWorld(){
        return welcomeMsg;
    }

}
