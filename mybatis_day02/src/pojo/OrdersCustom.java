/**
 * 
 */
package pojo;

import dao.Orders;

/**
 * @author Administrator
 *��������չ��
 */
public class OrdersCustom extends Orders{
	//����û�������
	private String name;
	private  Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
