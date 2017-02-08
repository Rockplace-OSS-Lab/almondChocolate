package com.rockplace.almond.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rockplace.almond.domain.User;
import com.rockplace.almond.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void registrationProcess(User user) {
		user.setOkKey(user.okKey());
		userRepository.save(user);
	}

	@Transactional
	public void registrationOk(String email, String okKey) throws Exception {
		User user = userRepository.findByEmail(email);

		if (!user.getOkKey().equals(okKey)) {
			throw new Exception("okKey 불일치!");
		}
		user.update();
		userRepository.save(user);
	}
}
