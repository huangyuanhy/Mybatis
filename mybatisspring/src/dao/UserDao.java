package dao;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import po.User;

//方法实现类
public class UserDao extends SqlSessionDaoSupport{
	//SqlSessionDaoSupport方法里有 sqlSessionFactory属性了，所以下面的属性省略
/*	private SqlSessionFactory sqlSessionFactory;
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}*/
	
	public User findUserById(int id) throws IOException{
		SqlSession sqlSession=this.getSqlSession();
		//通过sqlsession 操作数据库
		User user = sqlSession.selectOne("test.findUserById", 1);
		
		return user;
	}
}