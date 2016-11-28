package com.style01;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Conf {
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}




	public static Conf loadConf() {
		
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(ClassLoader.getSystemResource("conf.xml"));
			Element root = doc.getRootElement();
			
			Element userInfo = root.element("user-info");
			
			Conf conf = new Conf();
			
			conf.username = userInfo.element("username").getText().trim();
//			conf.password = userInfo.element("password").getText().trim();
			conf.password = userInfo.elementTextTrim("password");
			
			return conf;
			
		} catch (DocumentException e) {
			throw new RuntimeException("加载配置文件失败",e);
		}
	}
}
