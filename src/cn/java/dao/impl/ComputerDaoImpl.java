package cn.java.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.java.entity.Computer;

public class ComputerDaoImpl {

	private static SqlSession session = null;

	@Before
	public void init() {
		// 1、得到SqlSession
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();

		InputStream ins;
		try {
			ins = Resources.getResourceAsStream("mybatis.xml");
			SqlSessionFactory ssf = sfb.build(ins);
			session = ssf.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	  // 修改数据
    @Test
    public void updateComputer() {
        // 1、封装需要修改的参数信息
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("computer_name", "戴尔笔记本");
        parameter.put("price", "9000");
        parameter.put("id", 7L);
        // 2、调用SqlSession类中的相关方法
        int flag = session.update("cn.java.dao.impl.ComputerDaoImpl.updateComputer", parameter);
        session.commit();
        // 3、查看结果
        System.out.println(flag);
    }
    
    @Test
    public void deleteComputer(){
    	int flag = session.delete("cn.java.dao.impl.ComputerDaoImpl.deleteComputer", 7);
    	
    	session.commit();
    	System.out.println(flag);
    }
    
}
