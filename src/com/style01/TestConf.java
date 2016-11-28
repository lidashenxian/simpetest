package com.style01;

import java.util.Properties;

public class TestConf {
	public static void main(String[] args) throws Exception {
		// 创建Properties对象，用于加载、存储属性键值（key-value）对。
		Properties props = new Properties();
		
		// 从类路径中加载属性文件（conf.properties）
		// 所谓类路径就是Java程序运行时加载类的路径。Java程序在运行时，会使用ClassLoader把类加载到内存中。只不过这个操作有JVM自动完成，程序员一般是不需要理会的。
		// 
		props.load(ClassLoader.getSystemResourceAsStream("conf.properties"));

		// 通过属性名获取属性数值
		System.out.println(props.getProperty("username"));
		System.out.println(props.getProperty("password"));
		
		// 向控制台输出属性信息
		props.list(System.out);

		Conf conf = Conf.loadConf();

		System.out.println("Username: " + conf.getUsername());

		System.out.println("Password: " + conf.getPassword());

	}
}
