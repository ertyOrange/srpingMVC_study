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
 * ���˿���ͨ��������ָ����Ҫ�ŵ��Ự�е������⣨ʵ����ʹ�õ���value����ֵ��
 * ������ͨ��ģ�����ԵĶ�������ָ����Щģ����Ҫ�ŵ��ػ��У�ʵ����ʹ�õ���types����ֵ��
 *  
 * ֻ�ܷ���������治�ܷ��� ����������
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
	 * ��@modelAttribute��ǵķ�ʽ  ����ÿ��Ŀ�귽��ִ��֮ǰ��springMVC����
	 * @ModelAttribute
	//�����ᱨ��  ˵���name û��ֵ
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
	 * headers ��Ҫʹ������� ���ܻ��header
	 */
	@RequestMapping(value = "/testParamsAndHeaders",headers={"Accept-Language=zh-CN,zh;q=0.8"})
	  //params = { "userName!=name", "age!=10" })
	public String testParamsAndHeaders(Person person) {
		System.out.println("testParamsAndHeaders");

		return SUCCESS;
	}

	/*
	 * RequestMapping ֧��ANT����ͨ���
	 * ��ƥ��һ���ַ�
	 * * �����ַ�
	 * ** ƥ����·��
	 * 
	 */
	@RequestMapping(value = "/testAnt/*/abc")
	public String testAnt() {

		System.out.println("test:/testAnt/*/abc");
		return SUCCESS;
	}

	/*
	 * PathVariable ����ӳ��URL �е�ռλ����Ŀ�귽���Ĳ�����
	 */
	@RequestMapping(value = "/testPathVariable/{id}")
	public String testPathVariable(@PathVariable(value = "id") Integer id) {
		System.out.println("testPathVariable:" + id);
		return SUCCESS;
	}
	
	
	
	/*
	 * ʹ��requestparam����ӳ���������  
	 * value ��������Ĳ�����
	 * required �ò����Ƿ��Ǳ����
	 * defaultvalue ���������Ĭ��ֵ
	 * 
	 * 
	 * ����requestheader  ��ӳ������ͷ��Ϣ  �������һ��  ������Ҫ���������
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