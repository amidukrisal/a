package com.service.a;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AController {

    @RequestMapping("/getA")
    public String getServiceA(){
        return "Service A ( From Service A)";
    }

    @RequestMapping("/getB")
    public String getServiceB(@Value("${app.serviceb.uri}") String uri){
        String buri = uri+"/getB";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(buri, String.class);
        return result + "<br/>"+"<br/>"+"Calling From Service A";
    }

    @RequestMapping("/getC")
    public String getServiceC(@Value("${app.servicec.uri}") String uri){
        String curi = uri+"/getC";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(curi, String.class);
        return result + "<br/>"+"<br/>"+"Calling From Service A";
    }

    @RequestMapping("/getCFromB")
    public String getServiceCFromB(@Value("${app.serviceb.uri}") String urib, @Value("${app.servicec.uri}") String uric){
        String buri = urib+"/getC";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(buri, String.class);
        return result + "<br/>"+"<br/>"+"Calling From Service A";
    }

    @RequestMapping("/getBFromC")
    public String getServiceBFromC(@Value("${app.serviceb.uri}") String urib, @Value("${app.servicec.uri}") String uric){
        String curi = uric+"/getB";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(curi, String.class);
        return result + "<br/>"+"<br/>"+"Calling From Service A";
    }
}
