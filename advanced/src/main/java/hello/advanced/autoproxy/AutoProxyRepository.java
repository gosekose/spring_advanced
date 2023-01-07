package hello.advanced.autoproxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
public class AutoProxyRepository {

    public void join(String name) {

        try{

            if (name.equals("error")) {
                throw new IllegalArgumentException("error");
            }

            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
