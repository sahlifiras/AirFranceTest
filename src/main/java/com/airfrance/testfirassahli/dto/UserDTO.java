package com.airfrance.testfirassahli.dto;


import com.airfrance.testfirassahli.validation.AdultsOnly;
import com.airfrance.testfirassahli.validation.LiveInFrance;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * DTO Class of User
 *
 * @author firas.sahli
 */
public class UserDTO {
    public String id;
    @NotNull(message = "Firstname is required")
    @NotBlank(message = "Firstname must be mentionned correctly")
    public String firstName;
    @NotNull(message = "Lastname is required")
    @NotBlank(message = "Lastname must be mentionned correctly")
    public String lastName;
    @NotNull(message = "Birth date is required")
    @AdultsOnly(message = "minimum age is 18")
    public Date birthDate;
    @NotNull(message = "Address is required")
    @NotBlank(message = "Address must be mentionned correctly")
    @LiveInFrance(message = "Address must be in France")
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

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", activeUser=" + activeUser +
                '}';
    }
}
