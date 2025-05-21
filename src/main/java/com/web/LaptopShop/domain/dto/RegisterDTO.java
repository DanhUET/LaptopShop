package com.web.LaptopShop.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class RegisterDTO {
    @Size(min = 2, message = "FirstName mcó ít nhất 2 kí tự")
    private String firstName;

    @Size(min = 2, message = "LastName có ít nhất 2 kí tự")
    private String lastName;

    @Email(message = "Email không đúng hoặc đã tồn tại", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    private String password;
    private String confirmPassword;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
