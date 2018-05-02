package com.greenloud;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public class StudentService {
	 private Map<Integer, Student> stus = new HashMap<Integer, Student>();
	    {
	        stus.put(1, new Student("zhangsan",100));
	        stus.put(2, new Student("lisi", 106));
	    };
	    /**
	     *例子里的注解@Cacheable中存在有以下几个元素
    	 *value (也可使用 cacheNames) : 可看做命名空间，表示存到哪个缓存里了。
    	 *key : 表示命名空间下缓存唯一key,使用Spring Expression Language(简称SpEL,详见参考文献[5])生成。
    	 *condition : 表示在哪种情况下才缓存结果(对应的还有unless,哪种情况不缓存),同样使用SpEL
	     */
	    @Cacheable(value="students",key="#id")
	    public Student getStudent(int id){
	        System.out.println("getStudent: " + id);
	        return stus.get(id);
	    }
	    
	    /**
	     * @CacheEvict清除缓存
	     * @param id
	     */
	    @CacheEvict(value="students",key="#id")
	    public void clearCache(int id){
	    	
	    }
	    
	    @CachePut(value="students",key="#id")
	    public Student putStudent(int id) {
	    	System.out.println("getStudent: " + id);
	    	return stus.get(id);
		}
	    
	    
	    
}
