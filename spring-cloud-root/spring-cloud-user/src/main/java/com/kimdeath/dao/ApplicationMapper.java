package com.kimdeath.dao;

import java.util.List;

import org.spring.cloud.common.exception.DataTransfromException;
import org.springframework.web.bind.annotation.PathVariable;

import com.kimdeath.domain.Application;
import com.kimdeath.domain.ApplicationDTO;

/**
 * Created by jiazaibo on 17-2-15.
 */
public interface ApplicationMapper {

    public List<Application> getApplicationsByUserId(@PathVariable("userId") int userId)throws DataTransfromException;
    
    public List<ApplicationDTO> getAllApplication();
    
}
