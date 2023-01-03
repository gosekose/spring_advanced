package hello.advanced.proxy.code;

import hello.advanced.decorator.concrete.ConcreteClient;
import hello.advanced.decorator.concrete.ConcreteLogic;
import org.junit.jupiter.api.Test;

public class TimeProxyTest {

    @Test
    void addProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }

}
