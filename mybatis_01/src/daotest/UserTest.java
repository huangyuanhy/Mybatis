package daotest;



import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import dao.User;

public class UserTest {
	
	//�����û���Ϣ
	@Test
	public void updateUserTest() throws IOException {
		//�����ļ�
		InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//�����ػ�����
		SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
		//ͨ�������õ�sqlsession
		SqlSession sqlSession=build.openSession();
		
		User user=new User();
		//��������id ����ȫ������
		user.setId(1);
		user.setName("guowenjing");
		user.setAge(24);
		//ͨ��sqlsession �������ݿ�
		sqlSession.update("test.updateUser",user);
		//�ύ����
		sqlSession.commit();

		//�ͷ���Դ
		sqlSession.close();
	}
	//ɾ���û���Ϣ
	@Test
	public void deleteUserTest() throws IOException {
		//�����ļ�
		InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//�����ػ�����
		SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
		//ͨ�������õ�sqlsession
		SqlSession sqlSession=build.openSession();
		
		//ͨ��sqlsession �������ݿ�
		sqlSession.delete("test.deleteUser",4);
		//�ύ����
		sqlSession.commit();

		//�ͷ���Դ
		sqlSession.close();
	}
	
	//����û�
	
			@Test
			public void InsertUserTest() throws IOException {
				//�����ļ�
				InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
				//�����ػ�����
				SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
				//ͨ�������õ�sqlsession
				SqlSession sqlSession=build.openSession();
				
				User user=new User();
				user.setAge(15);
				user.setName("tom");
				
				//ͨ��sqlsession �������ݿ�
				sqlSession.insert("test.insertUser",user);
				//�ύ����
				sqlSession.commit();

				//��ȡ�ղŲ��������ֵ
				System.out.println("��������ݵ�idΪ"+user.getId());
				
				//�ͷ���Դ
				sqlSession.close();
			}
	
	//�����û�������ģ����ѯ
	
		@Test
		public void findUserByNameTest() throws IOException {
			//�����ļ�
			InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			//�����ػ�����
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
			//ͨ�������õ�sqlsession
			SqlSession sqlSession=build.openSession();
			//ͨ��sqlsession �������ݿ�
			List<User> list= sqlSession.selectList("test.findUserByName", "tom");
			for(User user:list)
			System.out.println(user.getName());
			
			//�ͷ���Դ
			sqlSession.close();
		}
	
	//����Id���в�ѯ
	
	@Test
	public void findUserByIdTest() throws IOException {
		//�����ļ�
		InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//�����ػ�����
		SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
		//ͨ�������õ�sqlsession
		SqlSession sqlSession=build.openSession();
		//ͨ��sqlsession �������ݿ�
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		
		//�ͷ���Դ
		sqlSession.close();
	}
}
