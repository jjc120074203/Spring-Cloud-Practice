package com.kimdeath.dao;


import java.util.List;

import com.isoftstone.cityinsight.exception.type.DataTransfromException;
import com.kimdeath.domain.User;

/**
 * Created by jiazaibo on 17-2-14.
 */
public interface UserMapper {

    public List<User> getUsers()throws DataTransfromException;

    public int create(User demoUser) throws DataTransfromException;

    public User getUserById(String id) throws DataTransfromException;

    public User getUserByName(String name)throws DataTransfromException;
     //底层数据异常demo2
    public void testCreateExp1() throws DataTransfromException;
    
    
//    public TestDockerInfo testDockerInfo() throws DataTransfromException;
}
