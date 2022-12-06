package com.cloudcomputing.models;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountModel {
	private int accountID;
	private String username;
	private String password;
	private String type;
	
	public AccountModel(String username, String password, String type) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
	}
}	
