package usermapper;

import java.util.List;

import dao.User;
import dao.UserCustom;
import dao.UserCustomVo;

public interface UserMapper {
	
	//使用pojo对象 usercustom 及动态sql进行综合查询
	public List<UserCustom> sql_queryTest(UserCustomVo userCustomVo) throws Exception;
	
	//使用resultmap输出结果集
	public User findUserResultMap(int id) throws Exception;
	//根据id进行查询
	public User findUserById(int id) throws Exception;
	//模糊查询  可能返回多条
	public List<User> findUserByName(String name) throws Exception;
	//插入用户
	public void insertUser(User user) throws Exception;
	//删除用户
	public void deleteUser(int id) throws Exception;
	
}
