package mapper;

import java.util.List;

import po.User;


public interface UserMapper {

	//����id���в�ѯ
	public User findUserById(int id) throws Exception;
	
}
