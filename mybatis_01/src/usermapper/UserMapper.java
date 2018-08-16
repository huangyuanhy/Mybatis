package usermapper;

import java.util.List;

import dao.User;
import dao.UserCustom;
import dao.UserCustomVo;

public interface UserMapper {
	
	//ʹ��pojo���� usercustom ����̬sql�����ۺϲ�ѯ
	public List<UserCustom> sql_queryTest(UserCustomVo userCustomVo) throws Exception;
	
	//ʹ��resultmap��������
	public User findUserResultMap(int id) throws Exception;
	//����id���в�ѯ
	public User findUserById(int id) throws Exception;
	//ģ����ѯ  ���ܷ��ض���
	public List<User> findUserByName(String name) throws Exception;
	//�����û�
	public void insertUser(User user) throws Exception;
	//ɾ���û�
	public void deleteUser(int id) throws Exception;
	
}
