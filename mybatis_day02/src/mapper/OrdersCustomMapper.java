package mapper;

import java.util.List;

import dao.Orders;
import pojo.OrdersCustom;

public interface OrdersCustomMapper {
	//查询订单及其详细信息

	public List<Orders> findOrdersAndOrderDetail() throws Exception;
	//查询订单关联查询用户信息实用resulttype类型
		public List<OrdersCustom> findOrdersUser() throws Exception;
		//查询订单关联查询用户信息使用resultmap结果集
		
		public List<Orders> findOrdersUserResultMap() throws Exception;
}
