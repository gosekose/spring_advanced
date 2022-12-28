package hello.advanced.threadlocal;

import hello.advanced.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalTest {

    private ThreadLocalService service = new ThreadLocalService();

    @Test
    void field() {
        log.info("main start");

        Runnable userA = ()-> {
            service.logic("userA");
        };

        Runnable userB = ()-> {
            service.logic("userA");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("threadA");

        Thread threadB = new Thread(userB);
        threadB.setName("threadB");

        threadA.start();
        sleep(2000);
        threadB.start();

        sleep(2000);
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
