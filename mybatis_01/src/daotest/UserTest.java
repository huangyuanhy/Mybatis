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
	
	//跟新用户信息
	@Test
	public void updateUserTest() throws IOException {
		//配置文件
		InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建回话工厂
		SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
		//通过工厂得到sqlsession
		SqlSession sqlSession=build.openSession();
		
		User user=new User();
		//必须设置id 否则将全部更新
		user.setId(1);
		user.setName("guowenjing");
		user.setAge(24);
		//通过sqlsession 操作数据库
		sqlSession.update("test.updateUser",user);
		//提交事务
		sqlSession.commit();

		//释放资源
		sqlSession.close();
	}
	//删除用户信息
	@Test
	public void deleteUserTest() throws IOException {
		//配置文件
		InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建回话工厂
		SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
		//通过工厂得到sqlsession
		SqlSession sqlSession=build.openSession();
		
		//通过sqlsession 操作数据库
		sqlSession.delete("test.deleteUser",4);
		//提交事务
		sqlSession.commit();

		//释放资源
		sqlSession.close();
	}
	
	//添加用户
	
			@Test
			public void InsertUserTest() throws IOException {
				//配置文件
				InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
				//创建回话工厂
				SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
				//通过工厂得到sqlsession
				SqlSession sqlSession=build.openSession();
				
				User user=new User();
				user.setAge(15);
				user.setName("tom");
				
				//通过sqlsession 操作数据库
				sqlSession.insert("test.insertUser",user);
				//提交事务
				sqlSession.commit();

				//获取刚才插入的主键值
				System.out.println("插入的数据的id为"+user.getId());
				
				//释放资源
				sqlSession.close();
			}
	
	//根据用户名进行模糊查询
	
		@Test
		public void findUserByNameTest() throws IOException {
			//配置文件
			InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			//创建回话工厂
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
			//通过工厂得到sqlsession
			SqlSession sqlSession=build.openSession();
			//通过sqlsession 操作数据库
			List<User> list= sqlSession.selectList("test.findUserByName", "tom");
			for(User user:list)
			System.out.println(user.getName());
			
			//释放资源
			sqlSession.close();
		}
	
	//根据Id进行查询
	
	@Test
	public void findUserByIdTest() throws IOException {
		//配置文件
		InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建回话工厂
		SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
		//通过工厂得到sqlsession
		SqlSession sqlSession=build.openSession();
		//通过sqlsession 操作数据库
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		
		//释放资源
		sqlSession.close();
	}
}
