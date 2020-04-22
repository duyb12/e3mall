package com.du.copy;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//		搜索return ReflectionUtils.invokeMethod查看样例
		return ReflectionUtils.invokeMethod(method, this, args);
	}
}
