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
	//此代码执行一次，初始化sqlsession
	@Before
	public void setup() throws IOException{
		//配置文件
				InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
				//创建回话工厂
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);		
	}

	////使用pojo对象 usercustom 及动态sql进行综合查询
		@Test
		public void sql_Test() throws Exception {
			
			//通过工厂得到sqlsession  此对象一定放在方法体内，避免多线程问题
			SqlSession sqlSession=sqlSessionFactory.openSession();
			
			//获取mapper代理对象 即  接口对应的实现类对象
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
	
	//resultamp输出结果集的测试
	@Test
	public void findUserResultMapTest() throws Exception {
		
		//通过工厂得到sqlsession  此对象一定放在方法体内，避免多线程问题
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//获取mapper代理对象 即  接口对应的实现类对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		//调用它的方法
		User user = mapper.findUserResultMap(1);
		sqlSession.close();
		System.out.println(user.getName());
	}
	
	
	@Test
	public void testFindUserById() throws Exception {
		
		//通过工厂得到sqlsession  此对象一定放在方法体内，避免多线程问题
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//获取mapper代理对象 即  接口对应的实现类对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		//调用它的方法
		User user = mapper.findUserById(1);
		sqlSession.close();
		System.out.println(user.getName());
	}
	
	@Test
	public void testfindUserByName()throws Exception {
		
		//通过工厂得到sqlsession  此对象一定放在方法体内，避免多线程问题
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//获取mapper代理对象 即  接口对应的实现类对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		//调用它的方法
		List<User> list=mapper.findUserByName("om");
	
		sqlSession.close();
			System.out.println(list);
		
	}

}

















