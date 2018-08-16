package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.Orders;
import mapper.OrdersCustomMapper;
import pojo.OrdersCustom;

public class OrdersCustomMapperTest {
	private SqlSessionFactory sqlSessionFactory;
	//此代码执行一次，初始化sqlsession
	@Before
	public void setup() throws IOException{
		//配置文件
				InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
				//创建回话工厂
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);		
	}
	
	
	//查询订单及其详细信息
	@Test
	public void testOrdersUserAndDetail() throws Exception {
		SqlSession openSession = sqlSessionFactory.openSession();
		OrdersCustomMapper mapper = openSession.getMapper(OrdersCustomMapper.class);
		List<Orders> findOrdersUser = mapper.findOrdersAndOrderDetail();
		System.out.println(findOrdersUser);
		openSession.close();
	}
	//查询订单关联查询用户信息实用resulttype类型
	@Test
	public void testFindOrdersUser() throws Exception {
		SqlSession openSession = sqlSessionFactory.openSession();
		OrdersCustomMapper mapper = openSession.getMapper(OrdersCustomMapper.class);
		List<OrdersCustom> findOrdersUser = mapper.findOrdersUser();		
		System.out.println(findOrdersUser);
		
		SqlSession openSession1 = sqlSessionFactory.openSession();
		OrdersCustomMapper mapper1 = openSession1.getMapper(OrdersCustomMapper.class);
		List<OrdersCustom> findOrdersUser1 = mapper.findOrdersUser();		
		System.out.println(findOrdersUser1);
		openSession.close();
	}
	//查询订单关联查询用户信息使用resultmap结果集

	@Test
	public void testFindOrdersUserresultMap() throws Exception {
		SqlSession openSession = sqlSessionFactory.openSession();
		OrdersCustomMapper mapper = openSession.getMapper(OrdersCustomMapper.class);
		List<Orders> findOrdersUserResultMap = mapper.findOrdersUserResultMap();
		System.out.println(findOrdersUserResultMap);
		openSession.close();
	}
	

}
