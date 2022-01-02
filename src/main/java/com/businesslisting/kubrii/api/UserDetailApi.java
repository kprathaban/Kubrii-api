package com.businesslisting.kubrii.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.businesslisting.kubrii.bo.UserDetailBO;

@RestController
public interface UserDetailApi {
	
	
	/**
	 * Create UserDetail
	 * @param userDetailsBO
	 */
	@PostMapping("/userdetail")
	public void createUserDetail(@RequestBody UserDetailBO userDetailsBO);
	
	
	/**
	 * Get User Detail based on userId
	 * @param userId
	 * @return UserDetailBO
	 */
	@GetMapping("/userdetail/{userId}")
	public UserDetailBO getUserDetail(@PathVariable Integer userId);
	
	
	
	/**
	 * Get all UserDetails
	 * @return List<UserDetailBO>
	 */
	@GetMapping("/userdetails")
	public List<UserDetailBO> getUserDetails();

	
	/**
	 * Delete a UserDetail based on userId and retrieve rest of the users from the DB
	 * 
	 * @param userId
	 * @return List<UserDetailBO> 
	 */
	@DeleteMapping("/userdetail/{userId}")
	public List<UserDetailBO> removeUserDetail(@PathVariable Integer userId);
	
	
	
	/**
	 * Update a User Detail and display the updated User Details
	 * 
	 * @param userDetailsBO
	 * @return UserDetailBO
	 */
	@PutMapping("/userdetail")
	public UserDetailBO updateUserDetail(@RequestBody UserDetailBO userDetailsBO);

}
