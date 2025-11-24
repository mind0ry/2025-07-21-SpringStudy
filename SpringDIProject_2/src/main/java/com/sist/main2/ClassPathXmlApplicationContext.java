package com.sist.main2;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.*;
public class ClassPathXmlApplicationContext implements ApplicationContext {
	
	private Map clsMap=new HashMap();
	public ClassPathXmlApplicationContext(String path) {
		try {
			SAXParserFactory spf=SAXParserFactory.newInstance();
			SAXParser sp=spf.newSAXParser();
			XMLParse xml=new XMLParse();
			sp.parse(new File(path), xml);
			clsMap=xml.getMap();
		} catch (Exception ex) {}
	}
	@Override
	public Object getBean(String key) {
		// TODO Auto-generated method stub
		return clsMap.get(key);
	}
}
