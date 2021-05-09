package com.creditCard.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.creditCard.app.entity.CreditCardEntity;
import com.creditCard.app.entity.CreditCardForm;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("test")
public class IntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();
    @Test
    public void getAllCards() throws Exception{
        ResponseEntity<List<CreditCardEntity>> response = restTemplate.exchange(
                "http://localhost:"+port+"/api/v1/creditCard/getCreditCardDetails",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CreditCardEntity>>() {});
        List<CreditCardEntity> ccList = response.getBody();
        assertEquals(HttpStatus.OK,response.getStatusCode());
        //assertEquals(4,ccList.size());
    }

    @Test
    public void saveCar() throws Exception{
        CreditCardEntity cardEntity = new CreditCardEntity(1L, 188238329432L);
        CreditCardForm ccf = new CreditCardForm();
        ccf.setCardNumber("79927398713");
        ResponseEntity<CreditCardEntity> response = restTemplate.postForEntity("http://localhost:"+port+"/api/v1/creditCard/addCrediCard",
        		ccf, CreditCardEntity.class);
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
        assertNotNull(response.getBody().getCardNumber());
    }

    @Test
    public void save_emptyName_400() throws JSONException {
        String reqInJson = "{\"name\":\" \", \"cardNumber\":\"79927398713\",\"limit\":\"9888\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(reqInJson, headers);

        // send json with POST
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:"+port+"/api/v1/creditCard/addCrediCard", entity, String.class);
        //printJSON(response);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
  
    @Test
    public void save_NonNumericLimit_400() throws JSONException {
    	String reqInJson = "{\"name\":\" Manmohan\", \"cardNumber\":\"79927398713\",\"limit\":\"limit\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(reqInJson, headers);

        // send json with POST
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:"+port+"/api/v1/creditCard/addCrediCard", entity, String.class);
        //printJSON(response);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
    
    @Test
    public void save_emptyCreditCardNumber_400() throws JSONException {
    	String reqInJson = "{\"name\":\" Manmohan\", \"cardNumber\":\"\",\"limit\":\"9888\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(reqInJson, headers);

        // send json with POST
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:"+port+"/api/v1/creditCard/addCrediCard", entity, String.class);
        //printJSON(response);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }   
    
    
    @Test
    public void save_NonNumericCreditCardNumber_400() throws JSONException {
    	String reqInJson = "{\"name\":\" Manmohan\", \"cardNumber\":\"cc\",\"limit\":\"9888\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(reqInJson, headers);

        // send json with POST
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:"+port+"/api/v1/creditCard/addCrediCard", entity, String.class);
        //printJSON(response);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }  
    
    @Test
    public void save_violateLuhnAlgoCreditCardNumber_400() throws JSONException {
    	String reqInJson = "{\"name\":\" Manmohan\", \"cardNumber\":\"79927398712\",\"limit\":\"9888\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(reqInJson, headers);

        // send json with POST
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:"+port+"/api/v1/creditCard/addCrediCard", entity, String.class);
        //printJSON(response);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }  
    
    @Test
    public void save_violateMaxSizeCreditCardNumber_400() throws JSONException {
    	String reqInJson = "{\"name\":\" Manmohan\", \"cardNumber\":\"7992739871273247234234\",\"limit\":\"9888\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(reqInJson, headers);

        // send json with POST
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:"+port+"/api/v1/creditCard/addCrediCard", entity, String.class);
        //printJSON(response);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }  
    
    
    @Test
    public void save_violateMinSizeCreditCardNumber_400() throws JSONException {
    	String reqInJson = "{\"name\":\" Manmohan\", \"cardNumber\":\"7992\",\"limit\":\"9888\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(reqInJson, headers);

        // send json with POST
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:"+port+"/api/v1/creditCard/addCrediCard", entity, String.class);
        //printJSON(response);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }  
    
}
