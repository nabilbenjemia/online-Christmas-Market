package org.example;


import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
// Add this line
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
        System.out.println("Application is running");
    }

    @Bean
    ApplicationRunner run(RestTemplate restTemplate) {
        return args -> {
            String BASE_URL = "http://localhost:8080/market";
            String registerUrl = BASE_URL + "/vendor/register?username=vendor&password=iloveu&description=testtt";
/*
            restTemplate.postForEntity(registerUrl, null, String.class);
            restTemplate.postForEntity(BASE_URL + "/vendor/register?username=ABC Gmbh&password=iloveu&description=testtt", null, String.class);
            restTemplate.postForEntity(BASE_URL + "/vendor/register?username=Souvenir QQ&password=iloveu&description=testtt", null, String.class);
            restTemplate.postForEntity(BASE_URL + "/vendor/register?username=DLC Gmbh&password=iloveu&description=testtt", null, String.class);
            restTemplate.postForEntity(BASE_URL + "/vendor/register?username=Sweatshirts Anna&password=iloveu&description=testtt", null, String.class);
            restTemplate.postForEntity(BASE_URL + "/vendor/register?username=Obaba&password=iloveu&description=testtt", null, String.class);


 */
            restTemplate.postForEntity(BASE_URL + "/vendor/register?username=Twinkle Lights&password=1234&description=Specializes in colorful Christmas lights for every home and occasion.", null, String.class);
            restTemplate.postForEntity(BASE_URL + "/vendor/register?username=Snowy Souvenirs&password=1234&description=Offering handcrafted Christmas ornaments and festive keepsakes.", null, String.class);
            restTemplate.postForEntity(BASE_URL + "/vendor/register?username=Frosted Apparel&password=1234&description=Features cozy Christmas sweaters and winter wear for the season.", null, String.class);
            restTemplate.postForEntity(BASE_URL + "/vendor/register?username=Gingerbread Treasures&password=1234&description=A selection of gingerbread-themed souvenirs and holiday decor.", null, String.class);
            restTemplate.postForEntity(BASE_URL + "/vendor/register?username=Reindeer Gifts&password=1234&description=Sells unique Christmas gifts, including festive decorations and warm clothing.", null, String.class);

            System.out.println("Vendors registered successfully!");

            restTemplate.postForEntity(BASE_URL + "/vendor/Twinkle Lights/products?type=ChristmasLights&description=Brighten your holidays with our vibrant, energy-efficient Christmas lights. Perfect for indoor and outdoor decorations.&price=15.5&amount=5", null, String.class);

            System.out.println("Vendor Twinkle Lights added ChristmasLights successfully!");
        };
    }

}
