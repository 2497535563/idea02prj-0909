package edu.soft2.designproxy.DynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理: jdk方式....
 */
public class AgentJdk implements InvocationHandler {
    private Object obj;

    public AgentJdk(final Object obj){
        super();
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk代理，权限校验...");
        Object object = method.invoke(obj,args);
        System.out.println("jdk代理，日志记录...");
        return object;
    }
}
