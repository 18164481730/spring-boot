package com.tangzhihe.dao;

import java.util.List;
import com.tangzhihe.domain.User;
import com.tangzhihe.util.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface UserDao extends MyMapper<User>{
	public List<User> queryUserList(@Param("entity")User user);
}