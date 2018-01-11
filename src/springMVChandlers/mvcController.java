package springMVChandlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


/***
 * 
 * @SessionAttributes(value= {"person","time"},types={String.class})
 * 除了可以通过属性名指定需要放到会话中的属性外（实际上使用的是value属性值）
 * 还可以通过模型属性的对象类型指定那些模型需要放到回话中（实际上使用的是types属性值）
 *  
 * 只能放在类的上面不能放在 方法的上面
 *
 */
@Controller
//@SessionAttributes(value= {"person"},types={String.class})
public class mvcController {
	private static final String SUCCESS = "test";
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@RequestMapping("helowMyView")
	public String testView(){
		return "helowview";
	}
	
	//=================================================
	/**
	 * 有@modelAttribute标记的方式  会在每个目标方法执行之前被springMVC调用
	 * @ModelAttribute
	//这样会报错  说你的name 没有值
						public void getPerson(@RequestParam(value="name" ) String name,Map<String, Object> map){
							if(name!=null){
							 Person person=	new Person("Erty", 11);
							 System.out.println("get the person from db:"+person);
							 map.put("person", person);
							}
						}
	 */
	@ModelAttribute
	public void getPerson(String name,Map<String, Object> map){
		System.out.println(map.getClass().getSimpleName());;
		
		if(name!=null){
		 Person person=	new Person("Erty", 11);
		 System.out.println("get the person from db:"+person);
		 map.put("person", person);
		}
	}
	
	
	@RequestMapping("/topersion")
	public String topersion(Person person,Locale locale) {
		System.out.println("form person show :" + person);
		String val= messageSource.getMessage("i18n.username", null, locale);
		System.out.println(val);
		return SUCCESS;
	}
	
	//===========================================================
	
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(Person person) {
		//person.setName("lail");
		System.out.println("update :" + person);

		return SUCCESS;
	}
	
	@RequestMapping(value="testSessionAttribute")
	public String testSessionAttribute(Map<String , Object> map){
		String view=SUCCESS;
		Person a= new Person();
//		Person person= new Person("yanghaoxiang", 26);
//		map.put("person", person);
		map.put("a", "persons");
		return  view;
		
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return SUCCESS;
	}



	/*
	 * headers 需要使用浏览器 才能获得header
	 */
	@RequestMapping(value = "/testParamsAndHeaders",headers={"Accept-Language=zh-CN,zh;q=0.8"})
	  //params = { "userName!=name", "age!=10" })
	public String testParamsAndHeaders(Person person) {
		System.out.println("testParamsAndHeaders");

		return SUCCESS;
	}

	/*
	 * RequestMapping 支持ANT风格的通配符
	 * ？匹配一个字符
	 * * 任意字符
	 * ** 匹配多层路径
	 * 
	 */
	@RequestMapping(value = "/testAnt/*/abc")
	public String testAnt() {

		System.out.println("test:/testAnt/*/abc");
		return SUCCESS;
	}

	/*
	 * PathVariable 用来映射URL 中的占位符到目标方法的参数中
	 */
	@RequestMapping(value = "/testPathVariable/{id}")
	public String testPathVariable(@PathVariable(value = "id") Integer id) {
		System.out.println("testPathVariable:" + id);
		return SUCCESS;
	}
	
	
	
	/*
	 * 使用requestparam用来映射请求参数  
	 * value 请求参数的参数名
	 * required 该参数是否是必须的
	 * defaultvalue 请求参数的默认值
	 * 
	 * 
	 * 还有requestheader  会映射请求头信息  和上面的一样  但是需要用浏览器来
	 *
	 */
	@RequestMapping(value="testReqestParam")
	public String testReqestParam(@RequestParam(value="userName") String userName,
								  @RequestParam(value="age", defaultValue="0") int age	){
			
		System.out.println("testReqestParam userName:"+userName+" , age:"+age);
		return SUCCESS;
		
	}
	
	@RequestMapping("testModelAndView")
	public ModelAndView testModelAndView(){
		String viewName=SUCCESS;
		ModelAndView andView= new ModelAndView(viewName);
		andView.addObject("time",new Date());
		return andView;
		
	}
	@RequestMapping(value="testMap")
	public String testMap(Map<String , Object> map){
		map.put("input",Arrays.asList("yang","hao","xiang"));
		return SUCCESS;
	}
	
	
	@RequestMapping("testRedirect")
	public String testRedirect(){
		System.out.println("testRedirect");
		return "redirect:index.jsp";
	}
	
	  @RequestMapping("/session/test/{id}/{name}")  
	    public ModelAndView localsessionAttributes(@PathVariable Integer id,@PathVariable String name,HttpSession session){  
	        session.setAttribute("currentUser", new Person(name, id));  
	        ModelAndView mav = new ModelAndView("test");  
	        return mav;  
	    }  
	  
	  
	  @RequestMapping("/session/attributes")  
	    public ModelAndView sessionAttributesage(HttpSession session){  
		  Person u = (Person)session.getAttribute("currentUser");  
	        System.out.println(u.getName());  
	        ModelAndView mav = new ModelAndView("test");  
	        return mav;  
	    }  
	
}