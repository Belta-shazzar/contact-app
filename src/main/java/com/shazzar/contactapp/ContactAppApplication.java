package com.shazzar.contactapp;

import com.shazzar.contactapp.entity.Contact;
import com.shazzar.contactapp.entity.User;
import com.shazzar.contactapp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactAppApplication.class, args);
    }
}