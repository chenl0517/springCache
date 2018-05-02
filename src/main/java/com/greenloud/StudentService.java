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
	     * 根据参数对返回值进行缓存
	     */
	    @Cacheable(value="students")
	    public Student getStudent(int id){
	        System.out.println("getStudent: " + id);
	        return stus.get(id);
	    };
}
