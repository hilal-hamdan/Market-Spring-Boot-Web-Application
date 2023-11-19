package com.example.market.model;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "inquiry")
public class Contact extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int inquiryId;

    private String status;

    @NotBlank(message = "Name must not be blank!")
    @Size(min = 3, message = "Name must be at least 3 characters long!")
    private String name;

    @NotBlank(message = "Mobile number must not be blank!")
    @Pattern(regexp = "([0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNum;

    @NotBlank(message = "Email must not be blank!")
    @Email(message = "Please provide a valid email address!")
    private String email;

    @NotBlank(message = "Subject must not be blank!")
    @Size(min = 5, message = "Subject must be at least 5 chars long!")
    private String subject;

    @NotBlank(message = "Message must not be blank!")
    @Size(min = 10, message = "Message must be at least 10 chars long!")
    private String message;

}

