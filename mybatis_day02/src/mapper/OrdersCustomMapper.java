package mapper;

import java.util.List;

import dao.Orders;
import pojo.OrdersCustom;

public interface OrdersCustomMapper {
	//��ѯ����������ϸ��Ϣ

	public List<Orders> findOrdersAndOrderDetail() throws Exception;
	//��ѯ����������ѯ�û���Ϣʵ��resulttype����
		public List<OrdersCustom> findOrdersUser() throws Exception;
		//��ѯ����������ѯ�û���Ϣʹ��resultmap�����
		
		public List<Orders> findOrdersUserResultMap() throws Exception;
}
