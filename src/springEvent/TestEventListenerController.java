package springEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestEventListenerController {

    @Autowired
    private MyTestEventPubLisher publisher;

    @RequestMapping(value = "/testPublishEvent1" )
    public void testPublishEvent(){
        publisher.pushListener("erty's test for spring event");
    }
}