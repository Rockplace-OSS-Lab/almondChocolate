package almond.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import almond.domain.User;
import almond.domain.UserRole;
import almond.repository.UserRepository;
import almond.repository.UserRoleRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Transactional
	public void registrationProcess(User user) {
		user.generatorKey();
		userRepository.save(user);
	}

	@Transactional
	public void registrationOk(String email, String okKey) throws Exception {
		User user = userRepository.findByEmail(email);

		if (!user.getOkKey().equals(okKey)) {
			throw new Exception("okKey 불일치!");
		}
		user.updateStatus();
		UserRole userRole = new UserRole(user);
		userRoleRepository.save(userRole);
		userRepository.save(user);
	}
}
