package nabil.project.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



    @RestController
    @CrossOrigin(origins = "http://localhost:63342")
    public class Testcontroller {


        @PostMapping("/test")
        public ResponseEntity<String> registerVendor(@RequestParam String username, @RequestParam String password, @RequestParam String description) {

            return ResponseEntity.ok("Hello world");
        }

    }
