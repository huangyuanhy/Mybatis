package dao;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import po.User;

//����ʵ����
public class UserDao extends SqlSessionDaoSupport{
	//SqlSessionDaoSupport�������� sqlSessionFactory�����ˣ��������������ʡ��
/*	private SqlSessionFactory sqlSessionFactory;
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}*/
	
	public User findUserById(int id) throws IOException{
		SqlSession sqlSession=this.getSqlSession();
		//ͨ��sqlsession �������ݿ�
		User user = sqlSession.selectOne("test.findUserById", 1);
		
		return user;
	}
}