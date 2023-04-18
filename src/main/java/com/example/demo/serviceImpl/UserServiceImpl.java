package com.example.demo.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	private Optional<User> user;

	@Override
	public boolean userRegister(User user) {
		try {
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			System.out.println("Exception occured for : " + e);
		}
		return false;
	}

	@Override
	public User getUser(String UserId) {
		try {
			user = userRepository.findByUserId(UserId);
			if(ObjectUtils.isEmpty(user))
				throw new NullPointerException("User not exist.");
			return user.get();
		}
		catch(Exception e) {
			System.out.println("Exception : "+e);
		}
		return null;
	}

	@Override
	public boolean deleteUser(int id) {
		try {
//			user = userRepository.findByUserId(id);
			if(ObjectUtils.isEmpty(user))
				throw new NullPointerException("User not exist.");
			user.get().setDeleteFlag(Boolean.TRUE);
			userRepository.save(user.get());
			return true;
		} catch (Exception e) {
			System.out.println("Exception occured for : " + e);
		}
		return false;
	}
}
