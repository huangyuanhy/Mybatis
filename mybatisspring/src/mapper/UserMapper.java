package mapper;

import java.util.List;

import po.User;


public interface UserMapper {

	//根据id进行查询
	public User findUserById(int id) throws Exception;
	
}
