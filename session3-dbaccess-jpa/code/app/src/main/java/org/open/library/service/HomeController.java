package org.open.library.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index(){
        StringBuilder data = new StringBuilder();
        data.append("<html>");
        data.append("<title>Welcome to Open Library</title>");
        data.append("<body><center><h1>Welcome to Open Library Service</h1>");
        data.append("<br><br><h3>Click on <a href=\"/swagger-ui.html\">this link</a> to test the API</h3>");
        data.append("</center></body>");
        data.append("</html>");
        return data.toString();
    }
}
