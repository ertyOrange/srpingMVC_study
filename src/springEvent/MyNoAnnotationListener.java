package springEvent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyNoAnnotationListener implements ApplicationListener<MyTestEvent> {

	@Override
	public void onApplicationEvent(MyTestEvent arg0) {
		System.out.println("·Ç×¢½â¼àÌýÆ÷£º" + arg0.getMsg());

	}
	


}
