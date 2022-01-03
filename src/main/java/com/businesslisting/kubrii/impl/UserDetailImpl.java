package com.businesslisting.kubrii.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.businesslisting.kubrii.api.UserDetailApi;
import com.businesslisting.kubrii.bo.UserDetailBO;
import com.businesslisting.kubrii.service.UserDetailService;

@Component
public class UserDetailImpl implements UserDetailApi {

	@Autowired
	private UserDetailService userDetailService;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public UserDetailBO getUserDetail(Integer userId) {

		return userDetailService.getUserDetail(userId);
	}

	@Override
	public void createUserDetail(UserDetailBO userDetailsBO) {
		userDetailService.createUserDetail(userDetailsBO);
	}

	@Override
	public List<UserDetailBO> getUserDetails() {
		return userDetailService.getUserDetails();

	}

	@Override
	public List<UserDetailBO> removeUserDetail(Integer userId) {
		return userDetailService.removeUserDetail(userId);

	}

	@Override
	public UserDetailBO updateUserDetail(UserDetailBO userDetailsBO) {

		return userDetailService.updateUserDetail(userDetailsBO);
	}

	@Override
	public String displayHome() {

		String empName = restTemplate.getForObject("http://employee-service-api/employee", String.class);

		return empName;
	}

}
