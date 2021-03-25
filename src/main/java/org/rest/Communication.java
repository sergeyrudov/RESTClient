package org.rest;

import org.rest.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/api/v1/companies";

    public List<Company> getAllCompanies() {
        ResponseEntity<List<Company>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Company>>() {
                        });
        return responseEntity.getBody();
    }

    public Company getCompany(int id) {
        return restTemplate.getForObject(URL + "/" + id, Company.class);
    }

    public void saveCompany(Company company) {
        int id = company.getId();
        if (id == 0) {
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(URL, company, String.class);
            System.out.println("New company was added to DB");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, company);
            System.out.println("Company with ID " + id + " was updated!");
        }
    }

    public void deleteCompany(int id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("Company with id: " + id + " was deleted");
    }
}
