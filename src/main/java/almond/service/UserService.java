package almond.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import almond.domain.User;
import almond.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MailService mailService;
	
	@Transactional
	public void registrationProcess(User user) {
		user.setOkKey(user.createKey());
		User savedUser = userRepository.save(user);
		mailService.sendRegistrationMail(savedUser);
	}

	@Transactional
	public void registrationOk(String email, String okKey) throws Exception {
		User user = userRepository.findByEmail(email);

		if (!user.getOkKey().equals(okKey)) {
			throw new Exception("okKey 불일치!");
		}
		user.updateStatus();
		userRepository.save(user);
	}
}
