package springEvent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyAnnotationListener {
	@EventListener
	public void listener1(MyTestEvent event) {
		System.out.println("ע�������1:" + event.getMsg());
	}
}
