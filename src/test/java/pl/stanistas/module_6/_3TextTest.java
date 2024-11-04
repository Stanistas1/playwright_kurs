package pl.stanistas.module_6;

import org.junit.jupiter.api.Test;
import pl.stanistas.common.BaseTest;

class _3TextTest extends BaseTest {

    @Test
    void textTest() {
        page.navigate("http://localhost:7080/notification_message_rendered");

//        System.out.println(page.innerHTML("#content"));
//        System.out.println(page.innerText("#content"));
 //       System.out.println(page.textContent("#content"));
        System.out.println(page.getAttribute("div img", "alt"));


    }
}
