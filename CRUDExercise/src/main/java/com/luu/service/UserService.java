package com.luu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luu.entity.User;
import com.luu.model.dto.UserDTO;
import com.luu.model.mapper.UserMapper;
import com.luu.model.request.CreateUserRequest;
import com.luu.repository.UserRepository;

@Service
public class UserService implements IUserService{
	
	@Autowired
    private UserRepository userRepository;
	@Override
	public UserDTO createUser(CreateUserRequest createUserRequest) {
		User user = new User();
		UserDTO userdto = new UserDTO();
		user.setUserName(createUserRequest.getUserName());
		user.setEmail(createUserRequest.getEmail());
		user.setAddress(createUserRequest.getAddress());
		userRepository.save(user);
		
		userdto.setUserName(user.getUserName());
		userdto.setEmail(user.getEmail());
		userdto.setAddress(user.getAddress());
		return userdto;
	     
	}

	@Override
	public User updateUser(CreateUserRequest createUserRequest, int id) {
		List<User> userList = userRepository.findAll();
		for (User user : userList) {
			if(id == user.getUserId()) {
				user.setUserName(createUserRequest.getUserName());
				user.setEmail(createUserRequest.getEmail());
				user.setAddress(createUserRequest.getAddress());
				return user;
			}
		}
		return null;
	}

	@Override
	public String deleteUser(int id) {
		userRepository.deleteById(id);
		return "Sucess";
	}

	@Override
	public UserDTO getUserById(int id) {
		 Optional<User> user = userRepository.findById(id);
	     return UserMapper.toUserDto(user.get());
	}

	@Override
	public UserDTO searchByNameOrEmail(String keyword) {
		List<UserDTO> userDTOList = getAllUsers();
		for (UserDTO userDTO : userDTOList) {
			if(keyword.equals(userDTO.getUserName()) || keyword.equals(userDTO.getEmail())) {
				return userDTO;
			}
		}
		return null;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> userList = userRepository.findAll();
		List<UserDTO> userDTOList = new ArrayList<>();
		for (User user : userList) {
			UserDTO userDTO = new UserDTO();
			userDTO.setUserName(user.getUserName());
			userDTO.setEmail(user.getEmail());
			userDTO.setAddress(user.getAddress());
			userDTOList.add(userDTO);
		}
		return userDTOList;
	}

}
