package com.sist.main3;
import java.util.*;
// 컨테이너 => Factory Pattern
public class ApplicationContext {
	private Map clsMap=new HashMap();
	public ApplicationContext() {
		clsMap.put("a", new A());
		clsMap.put("b", new B());
		clsMap.put("c", new C());
	}
	public Print getBean(String key) {
		return (Print)clsMap.get(key);
	}
}
