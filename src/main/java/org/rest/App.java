package org.rest;

import org.rest.configuration.MyConfig;
import org.rest.entity.Company;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication",
                Communication.class);

        System.out.println("---------------------------------------");

        // show all companies
        List<Company> allCompanies = communication.getAllCompanies();
        System.out.println(allCompanies);

        System.out.println("---------------------------------------");
        // show company with id
        Company company = communication.getCompany(1);
        System.out.println(company);

        System.out.println("---------------------------------------");
        // save to DB
        Company cmp = new Company("Arsenal", "1764");
        communication.saveCompany(cmp);

        System.out.println("---------------------------------------");
        // delete from DB
        communication.deleteCompany(3);
    }
}
