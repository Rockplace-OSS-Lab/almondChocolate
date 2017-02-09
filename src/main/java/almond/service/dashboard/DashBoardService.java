package almond.service.dashboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import almond.domain.DashBoard;
import almond.repository.DashBoardRepository;

@Service
public class DashBoardService {
	
	@Autowired
	DashBoardRepository dashBoardRepository;
	
	public List<DashBoard> getDashboard(String accountId){
		return dashBoardRepository.findByAccountId(accountId);
	}
}
