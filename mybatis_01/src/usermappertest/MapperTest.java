package usermappertest;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.User;
import dao.UserCustom;
import dao.UserCustomVo;

import usermapper.UserMapper;

public class MapperTest {
	private SqlSessionFactory sqlSessionFactory;
	//�˴���ִ��һ�Σ���ʼ��sqlsession
	@Before
	public void setup() throws IOException{
		//�����ļ�
				InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
				//�����ػ�����
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);		
	}

	////ʹ��pojo���� usercustom ����̬sql�����ۺϲ�ѯ
		@Test
		public void sql_Test() throws Exception {
			
			//ͨ�������õ�sqlsession  �˶���һ�����ڷ������ڣ�������߳�����
			SqlSession sqlSession=sqlSessionFactory.openSession();
			
			//��ȡmapper������� ��  �ӿڶ�Ӧ��ʵ�������
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);

			UserCustom userCustom=new UserCustom();
			UserCustomVo userCustomVo=new UserCustomVo();
			
			userCustom.setName("om");
			userCustom.setAge(15);
			userCustomVo.setUserCustom(userCustom);
			List<UserCustom> sql_queryTest = mapper.sql_queryTest(userCustomVo);
			sqlSession.close();
			System.out.println(sql_queryTest);
		}
	
	//resultamp���������Ĳ���
	@Test
	public void findUserResultMapTest() throws Exception {
		
		//ͨ�������õ�sqlsession  �˶���һ�����ڷ������ڣ�������߳�����
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//��ȡmapper������� ��  �ӿڶ�Ӧ��ʵ�������
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		//�������ķ���
		User user = mapper.findUserResultMap(1);
		sqlSession.close();
		System.out.println(user.getName());
	}
	
	
	@Test
	public void testFindUserById() throws Exception {
		
		//ͨ�������õ�sqlsession  �˶���һ�����ڷ������ڣ�������߳�����
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//��ȡmapper������� ��  �ӿڶ�Ӧ��ʵ�������
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		//�������ķ���
		User user = mapper.findUserById(1);
		sqlSession.close();
		System.out.println(user.getName());
	}
	
	@Test
	public void testfindUserByName()throws Exception {
		
		//ͨ�������õ�sqlsession  �˶���һ�����ڷ������ڣ�������߳�����
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//��ȡmapper������� ��  �ӿڶ�Ӧ��ʵ�������
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		//�������ķ���
		List<User> list=mapper.findUserByName("om");
	
		sqlSession.close();
			System.out.println(list);
		
	}

}

















