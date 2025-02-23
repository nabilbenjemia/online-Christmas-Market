package src;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import src.Model.Vendor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestConfig.class)
public class MarketControllerTest {

    @Autowired
    private RestTemplate restTemplate;

    private List<Vendor> vendors;

    private static final String BASE_URL = "http://localhost:8080/market";

    @Test
    public void testRegisterAndGetVisitors() {
        // Step 1: Register a visitor
        String registerUrl = BASE_URL + "/visitor/register?username=userr&password=iloveu";
        ResponseEntity<String> registerResponse = restTemplate.postForEntity(registerUrl, null, String.class);
        assertEquals("Visitor registered successfully", registerResponse.getBody());

        // Step 2: Get all visitors
        String getVisitorsUrl = BASE_URL + "/visitor/all";
        ResponseEntity<String> visitorsResponse = restTemplate.getForEntity(getVisitorsUrl, String.class);

        System.out.println(visitorsResponse.getBody());
        // Step 3: Check that the visitor is in the list
        assertTrue(visitorsResponse.getBody().contains("userr"));
    }

    @Test
    public void test2() {
        String getVisitorsUrl = BASE_URL + "/vendor/all";
        String registerUrl = BASE_URL + "/vendor/register?username=vendor&password=iloveu&description=testtt";
        ResponseEntity<String> registerResponse = restTemplate.postForEntity(registerUrl, null, String.class);
        restTemplate.postForEntity(BASE_URL + "/vendor/register?username=ABC Gmbh&password=iloveu&description=testtt", null, String.class);
        restTemplate.postForEntity(BASE_URL + "/vendor/register?username=Souvenir QQ&password=iloveu&description=testtt", null, String.class);
        restTemplate.postForEntity(BASE_URL + "/vendor/register?username=DLC Gmbh &password=iloveu&description=testtt", null, String.class);
        restTemplate.postForEntity(BASE_URL + "/vendor/register?username=Sweatshirts Anna&password=iloveu&description=testtt", null, String.class);
        restTemplate.postForEntity(BASE_URL + "/vendor/register?username=Obaba&password=iloveu&description=testtt", null, String.class);

        System.out.println(registerResponse.getBody());
        ResponseEntity<String> visitorsResponse = restTemplate.getForEntity(getVisitorsUrl, String.class);
        System.out.println(visitorsResponse.getBody());
    }

    @Test
    public void testgetVendor() {
        String getVisitorsUrl = BASE_URL + "/vendor/Obaba/products";
        ResponseEntity<String> getResponse = restTemplate.getForEntity(getVisitorsUrl, null, String.class);
        System.out.println(getResponse.getStatusCode());
        System.out.println(getResponse.getBody());
    }

    @Test
    public void testAddProducts() {
        // Define the vendor ID and request parameters
        String vendorId = "Obaba";
        String addProductsUrl = BASE_URL + "/vendor/" + vendorId + "/products?type=ChristmasSouvenir&description=the+best&price=15.5&amount=5";

        // Make a POST request
        ResponseEntity<String> postResponse = restTemplate.postForEntity(addProductsUrl, null, String.class);

        // Print the response for debugging
        System.out.println("Response: " + postResponse.getBody());
        System.out.println("Status Code: " + postResponse.getStatusCode());

        // Assert that the status code is OK (200)
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());

        // Assert that the response body confirms goods were added
        //assertEquals("3 Goods added successfully", postResponse.getBody());

        //ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + "/vendor/" + vendorId, String.class);
        //System.out.println(response.getBody());

    }
    //todo must be logged in to add to cart
    //todo return the amount of only available products
    @Test
    void testAddToCart() {
        String visitorId = "nabil";
        String vendorId = "Obaba";
        String productType = "ChristmasSouvenir";
        int amount = 1;


        //restTemplate.postForEntity(BASE_URL + "/visitor/register?username=" + visitorId +"&password=n", null, String.class);

        //restTemplate.postForEntity(BASE_URL + "/visitor/login?username=" + visitorId +"&password=nabil", null, String.class);

        String addToCartUrl = BASE_URL + "/cart/" + visitorId + "/" + vendorId + "?type=" + productType + "&amount=" + amount;
        System.out.println(addToCartUrl);
        ResponseEntity<String> response = restTemplate.postForEntity(addToCartUrl, null, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode()); // Assuming successful response is OK
        System.out.println(response.getBody()); // Verifying response message

    }

    @Test
    void testPurchase() {
        String visitorId = "nabil";
        String purchaseURL = BASE_URL + "/visitor/" + visitorId + "/purchase";
        ResponseEntity<String> response = restTemplate.postForEntity(purchaseURL, null, String.class);
    }



}