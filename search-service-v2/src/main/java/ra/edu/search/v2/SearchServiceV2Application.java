package ra.edu.search.v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api/search")
public class SearchServiceV2Application {

    public static void main(String[] args) {
        // Chạy trên port 8082
        System.setProperty("server.port", "8082");
        SpringApplication.run(SearchServiceV2Application.class, args);
    }

    @GetMapping
    public String search() {
        return "V2";
    }
}
