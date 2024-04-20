package com.crud.simpleCrudApplication;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class FrontController {
	
	private final UserRepo userRepo;
	
	public FrontController(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	@PostMapping("/saveUser")
	public User postMethodName(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	@GetMapping("/getUser")
	public List<User> getMethodName() {
		return userRepo.findAll();
	}
	
	@GetMapping("/getUser/{id}")
	public User getUserById(@PathVariable Integer id) {
		return userRepo.findAllById(id);
	}
	
	@PutMapping("putUser/{id}")
	public ResponseEntity putMethodName(@PathVariable Integer id, @RequestBody User user) {
		
		User cuser = userRepo.findAllById(id);
		cuser.setName(user.getName());
		cuser.setEmail(user.getName());
		cuser = userRepo.save(user);
		
		
		return ResponseEntity.ok(cuser);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteUser(@PathVariable Integer id , @RequestBody User user){
		userRepo.deleteById(id);
		return ResponseEntity.ok(user);
	}

	

}
