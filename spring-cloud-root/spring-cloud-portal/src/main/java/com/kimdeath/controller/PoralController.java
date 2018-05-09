
package com.kimdeath.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kimdeath.api.Hystrix.IModeClient;
import com.kimdeath.api.Hystrix.IRabbitmqClients;
import com.kimdeath.api.fegin.mvc.IFeginClient;
import com.kimdeath.api.fegin.orgin.IFileSystemClient;
import com.kimdeath.api.fegin.orgin.IUserClient;
import com.kimdeath.domain.ApplicationDTO;

@RestController
public class PoralController {
	@Autowired
	private IFileSystemClient IFileSystemClient;
	@Autowired
	private IFeginClient IFeginClient;
	@Autowired
	private IUserClient IUserClient;

	@GetMapping("/testFegin")
	public List<ApplicationDTO> feginTest(int a) {
		if (a > 0) {
			return IUserClient.queryApplications();

		}
		List<ApplicationDTO> re = new ArrayList<>();
		re.add(IUserClient.querySingleApplications());
		return re;
	}
	
	@GetMapping("/testFegin2")
	public String feginTest() {
		return IFeginClient.testFeginByPassWord();
	}

	// --------------------------------------------------------------
	// @PostMapping("/uploadFile")
	// public byte[] uploadFile(MultipartFile file) throws IOException{
	// return IrabbitmqClient.uploadFile(file.getInputStream());
	// }
//	@GetMapping("/queryApplications")
//	public List<ApplicationDTO> queryApplications() {
//		return IRabbitmqClients.queryApplicationFallBackFactory();
//	}
}
