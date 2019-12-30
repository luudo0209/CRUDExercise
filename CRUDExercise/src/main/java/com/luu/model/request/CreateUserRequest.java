package com.luu.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CreateUserRequest {
	
	@NotNull(message = "User name is required")
    @NotEmpty(message = "User name is required")
    @ApiModelProperty(
            example="Duc Luu",
            notes="User name cannot be empty",
            required=true
    )
	private String userName;
	
	@NotNull(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @Email(message = "Please provide a valid email")
    @ApiModelProperty(
            example="ducluu@gmail.com",
            notes="Email cannot be empty",
            required=true
    )
	private String email;
	
	@NotNull(message = "Address is required")
    @NotEmpty(message = "Address is required")
    @ApiModelProperty(
            example="Tan Trieu, Thanh Tri, Ha Noi",
            notes="Address cannot be empty",
            required=true
    )
	private String address;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
