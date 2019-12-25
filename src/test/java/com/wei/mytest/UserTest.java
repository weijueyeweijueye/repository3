package com.wei.mytest;

import com.wei.bean.User;
import com.wei.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class UserTest {
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;
    Logger logger= Logger.getLogger(this.getClass());
    @Before
    public void init() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
    }
    @After
    public void after()
    {
        if(sqlSession!=null)
        {
            sqlSession.commit();
            sqlSession.close();
        }
    }
    @Test
    public void mytest()
    {
        sqlSession=sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserByIdAndPasswordAndUsername(80, "nini", "123");
        logger.info(user);
    }
    @Test
    public void mytest1()
    {
        sqlSession=sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserByPasswordAndUsername("nini", "123");
        logger.info(user);
    }
    @Test
    public void mytest2()
    {
        sqlSession=sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("xiha");
        user.setPassword("123");
        int i = mapper.insertUserByUser(user);
        logger.info(i);
    }

    @Test
    public void mytest3()
    {
        sqlSession=sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("xihas");
        user.setPassword("123");
        User user2 = new User();
        user2.setUsername("hehheheh");
        user2.setPassword("123");
        int i = mapper.insertUserByUsers(user,user2);
        logger.info(i);
    }
    @Test
    public void mytest4()
    {
        sqlSession=sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("nenen");
        user.setPassword("123");
        User user2 = new User();
        user2.setUsername("inni");
        user2.setPassword("123");
        int i = mapper.insertUserByUsers2(user,user2);
        logger.info(i);
    }

}
