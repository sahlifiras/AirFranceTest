package com.airfrance.testfirassahli.dto;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserDTO {
    public String id;
    @NotNull(message = "Firstname is required")
    @NotBlank(message = "Firstname must be mentionned correctly")
    public String firstName;
    @NotNull(message = "Lastname is required")
    @NotBlank(message = "Lastname must be mentionned correctly")
    public String lastName;
    @NotNull(message = "Birth date is required")
    public Date birthDate;
    @NotNull(message = "Address is required")
    @NotBlank(message = "Address must be mentionned correctly")
    public String address;
    public Boolean activeUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(Boolean activeUser) {
        this.activeUser = activeUser;
    }
}
