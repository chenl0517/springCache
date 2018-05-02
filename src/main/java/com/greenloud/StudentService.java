package com.greenloud;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;

public class StudentService {
	 private Map<Integer, Student> stus = new HashMap<Integer, Student>();
	    {
	        stus.put(1, new Student("zhangsan",100));
	        stus.put(2, new Student("lisi", 106));
	    };
	    /**
	     *condition 用来添加缓存条件 
	     */
	    @Cacheable(value="students",condition="#id<2")
	    public Student getStudent(int id){
	        System.out.println("getStudent: " + id);
	        return stus.get(id);
	    };
}
