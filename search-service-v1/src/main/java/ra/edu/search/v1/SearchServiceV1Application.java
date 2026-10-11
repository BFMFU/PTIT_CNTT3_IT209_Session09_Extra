package ra.edu.search.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api/search")
public class SearchServiceV1Application {

    public static void main(String[] args) {
        // Chạy trên port 8081
        System.setProperty("server.port", "8081");
        SpringApplication.run(SearchServiceV1Application.class, args);
    }

    @GetMapping
    public String search() {
        return "V1";
    }
}
