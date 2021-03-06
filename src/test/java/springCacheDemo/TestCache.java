package springCacheDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.greenloud.Student;
import com.greenloud.StudentService;

public class TestCache {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        StudentService studentService = context.getBean(StudentService.class);
        Student student1 = studentService.putStudent(1);
        System.out.println(student1);
        
        //清缓存
        //studentService.clearCache(1);
        
        Student student2 = studentService.putStudent(1);
        System.out.println(student2);
        
        
	}
}
