package com.kimdeath.service;

import java.util.List;

import org.spring.cloud.common.exception.DataTransfromException;
import org.spring.cloud.common.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.kimdeath.constrants.SystemConstrants;
import com.kimdeath.constrants.SystemExpConstants;
import com.kimdeath.dao.UserMapper;
import com.kimdeath.domain.User;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by chenjl on 17-2-14.
 */
@Component
//@CacheConfig(cacheNames = "testUser")//配置了该数据访问对象中返回的内容将存储于名为testUser的缓存对象中,或者@Cacheable缓存也可以解决该该问题
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public List<User> getUsers() throws ServiceException{
        return userMapper.getUsers();
    }
    
	public PageInfo<User> getUsersInfo(Integer pageNum, Integer pageSize) throws ServiceException{
		Page<User> pageRes=PageHelper.startPage(pageNum, pageSize);
		userMapper.getUsers();
		return pageRes.toPageInfo();
	}

    public int createUser(User user) throws ServiceException{
        this.userMapper.create(user);
        return Integer.valueOf(user.getId());
    }

    public void delUserById(String id) throws ServiceException{
    	 userMapper.delUserById(id);
    }
    @Cacheable(value="tUser",key="#id")
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
