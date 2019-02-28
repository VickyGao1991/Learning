package com.test.main;

		import com.test.app.Appconfig;
		import com.test.beanfactorypostprocessor.TestBeanFactoryPostProcessor;
		import com.test.dao.IMyDao;
		import com.test.dao.TestDao;
		import com.test.dao.TestImportDao;
		import org.springframework.context.annotation.AnnotationConfigApplicationContext;
		import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// 方式一: XML
//		ClassPathXmlApplicationContext cpxac = new ClassPathXmlApplicationContext();
//		TestDao testDao1 =  (TestDao)cpxac.getBean("TestDao");
//		testDao1.query();

		// 方式二: JavaConfig
		/**
		 * AnnotationConfigApplicationContext (后面用 registry 代称) 构造器中做了以下事情：
		 * 1. 父类构造器里初始化了一个 DefaultListableBeanFactory，包含一个beanDefinitionMap 和一个 beanDefinitionNames
		 * 2. 构造了一个reader.这个reader 会读取application 和 spring 的bean,并放入到Spring bean 工厂中
		 * 		2.1 reader 构造器里，注册若干个后置处理器 （详情查看AnnotationConfigUtils.registerAnnotationConfigProcessors()）
		 * 3. 构造了一个scanner,
		 * 4. 把registry构造方法传入的class （e.g.Appconfig.class）作为bean 也注册到 registry 的 DefaultListableBeanFactory中
		 * 5. refresh（）// TODO
		 *
		 * 注意：
		 * #2.1注册后置处理器 和 #4 注册Appconfig 都是
		 * 通过 registry.registerBeanDefinition(beanName, definition); 放入到registry的 defaultListableBeanFactory中的beanDefinitionMap的
		 *
		 * */
		AnnotationConfigApplicationContext acac2 = new AnnotationConfigApplicationContext(Appconfig.class); //把spring所有的前提环境准备好
		//TestDao testDao2 = acac2.getBean(TestDao.class);
		//testDao2.query();
		TestImportDao testImportDao = acac2.getBean(TestImportDao.class); // 通过 ImportSelector.selectImports 注入bean
		testImportDao.query();
		IMyDao proxyDao = (IMyDao)acac2.getBean("testDao"); // 模拟spring aop开关 @EnableMyAOP
		proxyDao.query();

		// 方式三: JavaConfig
//		AnnotationConfigApplicationContext acac3 = new AnnotationConfigApplicationContext();
//		acac3.register(Appconfig.class);
//		acac3.close();

		/**
		 *
		 * Spring往bean 工厂添加bean 的方式:
		 * 1. acac.register
		 * 2. scan()
		 * 3.ImportBeanDefinitionRegistrar
		 *
		 *
		 * */

	}
}
