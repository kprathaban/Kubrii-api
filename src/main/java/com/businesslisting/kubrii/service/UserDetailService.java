package com.businesslisting.kubrii.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.businesslisting.kubrii.bo.UserDetailBO;
import com.businesslisting.kubrii.entity.UserDetail;
import com.businesslisting.kubrii.repository.UserDetailsRepository;

@Service
public class UserDetailService {

	@Autowired
	private UserDetailsRepository userDetailsRepository;



	public UserDetailBO getUserDetail(Integer userId) {

		UserDetail userDetail = userDetailsRepository.findById(userId).get();

		// Converting Entry back to Business Object
		UserDetailBO userDetailsBO = new UserDetailBO();
		userDetailsBO.setUserId(userDetail.getId());
		userDetailsBO.setUsername(userDetail.getUsername());
		userDetailsBO.setDept(userDetail.getUserDept());

		return userDetailsBO;

	}

	
	public void createUserDetail(UserDetailBO userDetailsBO) {

		// Setting Business Object to Entiy
		UserDetail userDetails = new UserDetail();
		userDetails.setUsername(userDetailsBO.getUsername());
		userDetails.setUserDept(userDetailsBO.getDept());

		// call for adding data to DB.
		userDetailsRepository.save(userDetails);

	}

	/**
	 * Returns all the user information.
	 * 
	 * @return List<UserDetailsBO>
	 */

	public List<UserDetailBO> getUserDetails() {

		List<UserDetailBO> userDetailsBOs = new ArrayList<>();
		List<UserDetail> userDetails = (List<UserDetail>) userDetailsRepository.findAll();

		// converting entity Object to Business Object
		userDetails.forEach(userDetail -> userDetailsBOs.add(createUserDetailBO(userDetail)));
		return userDetailsBOs;

	}

	private UserDetailBO createUserDetailBO(UserDetail userDetail) {

		UserDetailBO userDetailsBO = new UserDetailBO();
		userDetailsBO.setUserId(userDetail.getId());
		userDetailsBO.setUsername(userDetail.getUsername());
		userDetailsBO.setDept(userDetail.getUserDept());

		return userDetailsBO;

	}

	public List<UserDetailBO> removeUserDetail(Integer userId) {
		userDetailsRepository.deleteById(userId);
		return getUserDetails();

	}

	public UserDetailBO updateUserDetail(UserDetailBO userDetailsBO) {
		
		// Setting Business Object to Entiy
		UserDetail userDetails = new UserDetail();
		userDetails.setId(userDetailsBO.getUserId());
		userDetails.setUsername(userDetailsBO.getUsername());
		userDetails.setUserDept(userDetailsBO.getDept());

		// call for adding data to DB.
		userDetailsRepository.save(userDetails);
		
		return getUserDetail(userDetails.getId());
		
	}

}
