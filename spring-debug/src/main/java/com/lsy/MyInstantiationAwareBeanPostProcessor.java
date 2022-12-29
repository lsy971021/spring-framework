package com.lsy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;

public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		if (beanClass == Person.class) {
			System.out.println("MyBeanFactoryPostProcessor is start to postProcessBeforeInstantiation~");
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(beanClass);
			//设置回调函数（在动态代理时候进行什么回调操作）
			enhancer.setCallback(new MyMethodIntercept());
			Person o = (Person) enhancer.create();
			System.out.println("创建单例对象：" + o);
			return o;
		}
		return null;
	}
}
