package com.kimdeath.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.cloud.common.exception.DataTransfromException;
import org.spring.cloud.common.utils.CommonTools;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimdeath.dao.ApplicationMapper;
import com.kimdeath.dao.UserMapper;
import com.kimdeath.domain.Application;
import com.kimdeath.domain.ApplicationDTO;
import com.kimdeath.domain.User;

/**
 * Created by jiazaibo on 17-2-15.
 */
@Service
public class ApplicationService {
	private static final  Log logger=LogFactory.getLog(ApplicationService.class);
    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private UserMapper userMapper;

    public List<Application> getApplicationsByUserId(int userId) throws DataTransfromException {
        return this.applicationMapper.getApplicationsByUserId(userId);
    }
    
    public ArrayList<ApplicationDTO> getAllApplication() throws DataTransfromException{
    	return handle(applicationMapper.getAllApplication());
    }
    private ArrayList<ApplicationDTO> handle(List<ApplicationDTO> res) throws DataTransfromException{
    	LinkedList<ApplicationDTO> ss=new LinkedList<ApplicationDTO>();
    	for (ApplicationDTO applicationDTO : res) {
    		ApplicationDTO appTO=new ApplicationDTO();
    		BeanUtils.copyProperties(applicationDTO, appTO);
    		if(!CommonTools.isNullOrEmpty(applicationDTO.getCreatedBy())){
    			User usr=userMapper.getUserById(applicationDTO.getCreatedBy());
    			if (!CommonTools.isNullOrEmpty(usr)) {
    				appTO.setLinkMan(usr.getNickName());
				}
    		}
    		ss.add(appTO);
		}
    	  ArrayList<ApplicationDTO> arrayList = new ArrayList<>(ss); 
    	return arrayList;
    }
}

