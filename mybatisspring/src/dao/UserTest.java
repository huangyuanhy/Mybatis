package dao;

/**
 * ԭʼdao����
 */

import java.io.IOException;
import java.io.InputStream;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.User;

public class UserTest {
	ApplicationContext application;
	@Before
	public void SetupContext() {
		application=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}
	//����Id���в�ѯ
	@Test
	public void findUserByIdTest() throws IOException {
		
		UserDao userDao = (UserDao) application.getBean("userDao");
		
		User findUserById = userDao.findUserById(1);
		System.out.println(findUserById);
	}
}
















