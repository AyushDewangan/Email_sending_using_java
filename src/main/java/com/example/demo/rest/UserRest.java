package com.example.demo.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.EmailServiceOptima;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRest {

	@Autowired
	private UserService userService;
	@Autowired
	private EmailServiceOptima emailServiceOptima;

	@PostMapping("/register")
	public ResponseEntity<String> userRegister(@Validated @RequestBody User user) {
		try {
			System.out.println("enter for registering user");
			boolean register = false;
			boolean mailSendFlag = false;
			String subject = "Hey... " + user.getUserName();
			String body = "Hello your credentials are here : " + user.toString();
			register = userService.userRegister(user);
			if (register == false) {
				return new ResponseEntity<>("issue while register user.", HttpStatus.BAD_REQUEST);
			}
			mailSendFlag = emailServiceOptima.sendEmail(user.getEmailId(), subject, body);
			System.out.println("exit from userRegister method");
			return new ResponseEntity<>("Mail Sended : " + mailSendFlag, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
		return new ResponseEntity<>("error while user Register.", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getUser{UserId}")
	public User getUser(@PathVariable String UserId) {
		return userService.getUser(UserId);
	}

	@DeleteMapping("/deleteUser/{id}")
	public boolean deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}

	

}
