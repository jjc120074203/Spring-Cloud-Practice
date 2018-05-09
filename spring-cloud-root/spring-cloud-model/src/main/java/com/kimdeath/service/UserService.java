package com.kimdeath.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isoftstone.cityinsight.exception.type.ServiceException;
import com.kimdeath.constrants.SystemConstrants;
import com.kimdeath.constrants.SystemExpConstants;
import com.kimdeath.dao.UserMapper;
import com.kimdeath.domain.User;

/**
 * Created by jiazaibo on 17-2-14.
 */
@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public List<User> getUsers() throws ServiceException{
        return userMapper.getUsers();
    }

    public int createUser(User user) throws ServiceException{
        this.userMapper.create(user);
        return Integer.valueOf(user.getId());
    }

    public User getUserById(int id)throws ServiceException{
        return this.userMapper.getUserById(id+"");
    }

    public User getUserByName(String name) throws ServiceException{
        return  this.userMapper.getUserByName(name);
    }
    
    //底层数据异常demo2
    public void testCreateExp1() throws ServiceException{
    	try {
			this.userMapper.testCreateExp1();//框架异常属于Exception异常,需要做封装 防止Ibais代码出现
		} catch (Exception e) {
			//从框架中获取 底层框架异常信息 同事封装自定义的错误码
			throw new ServiceException(SystemExpConstants.common.USER_DATA_MODEL_SYSTEM_ERROR,new Object[]{SystemConstrants.params.USER_PARAMS_SVC_USER},e.getMessage());
		}
    }
    
    
}
