package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.management.Query;

public class BusinessCardRun {
    public void run()
    {
        BusinessCardParse bcp = new BusinessCardParse();
        bcp.process();
    }
}

class BusinessCardParse
{
    public void process()
    {
        String result = "{\n" +
                "    \"name\": \"Vsevolod\",\n" +
                "    \"surname\": \"Ievgiienko\",\n" +
                "    \"phones\": [\"044-256-78-90\", \"066-123-45-67\"],\n" +
                "    \"sites\": [\"http://site1.com\", \"http://site2.com\"],\n" +
                "    \"address\": {\n" +
                "         \"country\": \"UA\",\n" +
                "         \"city\": \"Kyiv\",\n" +
                "         \"street\": \"abcd\"\n" +
                "    }\n" +
                "}";

        Gson gson = new GsonBuilder().create();
        PersonalInfo pi = (PersonalInfo) gson.fromJson(result, PersonalInfo.class);

        System.out.println("  :" + pi.name + pi.address.country );

        System.out.println("JSON:\n\t" + gson.toJson(pi));
    }
}

class Address
{
    String country;
    String city;
    String street;
}

class PersonalInfo
{
    String name;
    String surname;
    String []phones;
    String []sites;
    Address address;
}