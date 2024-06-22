package com.pedro.demo.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class Customer {
    @NotNull
    private String firstName;

    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String lastName = "";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

