package edu.soft2.designproxy.DynamicProxy.jdk;

import java.lang.reflect.Proxy;

/**
 * 测试类
 * 注，依赖roxy类
 */
public class Test {
    public static void main(String[] aegs){
        AgentCglib agent = new AgentCglib();
        Dao dao = (Dao) agent.getInstance(UserDao.class);
        dao.add();
        dao.delete();
        dao.update();
        dao.query();






      /*  Dao dao = (Dao) Proxy.newProxyInstance(
                Dao.class.getClassLoader(),
              new Class[]{Dao.class},
              new AgentJdk(new UserDao()));
        dao.add();
        dao.delete();
        dao.update();
        dao.query();*/
    }
}
