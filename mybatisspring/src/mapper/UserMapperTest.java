package mapper;



import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.User;

public class UserMapperTest {
	ApplicationContext application;
	@Before
	public void SetupContext() {
		application=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}
	//����Id���в�ѯ
	@Test
	public void test() throws Exception {
		UserMapper bean = (UserMapper) application.getBean("userMapper");
		User findUserById = bean.findUserById(1);
		System.out.println(findUserById);
	}

}
