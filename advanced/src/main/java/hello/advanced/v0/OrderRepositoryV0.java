package hello.advanced.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {

    public void save(String itemId) {

        if (itemId.equals("ex")) {
            throw new IllegalStateException("에러 발생!");
        }

        doSleep(1000);

    }

    private void doSleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
