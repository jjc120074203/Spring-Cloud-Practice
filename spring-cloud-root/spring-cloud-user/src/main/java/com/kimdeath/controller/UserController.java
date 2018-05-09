package com.kimdeath.controller;

import java.util.List;

import org.spring.cloud.common.exception.ServiceException;
import org.spring.cloud.common.web.result.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.kimdeath.domain.User;
import com.kimdeath.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/app")
public class UserController {

	@Autowired
	private UserService userService;
	
	@ApiOperation(value="获取用户信息")
	@GetMapping("/getUsers")
	public List<User> getUsers() throws ServiceException {
		return userService.getUsers();
	}
	@ApiOperation(value="获取用户信息Id")
	@GetMapping("/getUserById")
	public User getUserById(int id) throws ServiceException {
		return userService.getUserById(id);
	}

	@ApiOperation(value="获取用户信息分页")
	@GetMapping("/getUsersInfo")
	public PageInfo<User> getUsersInfo(Integer pageNum, Integer pageSize) throws ServiceException {
		return userService.getUsersInfo(pageNum, pageSize);
	}

	@ApiOperation(value="删除用户信息分页")
	@PostMapping("/delUserById")
	public void delUserById(String id) throws ServiceException {
		userService.delUserById(id);
	}
	
	@ApiOperation(value="创建用户信息分页")
	@PostMapping("/createUser")
	public int createUser(@RequestBody User user) throws ServiceException {
		return userService.createUser(user);
	}
}
