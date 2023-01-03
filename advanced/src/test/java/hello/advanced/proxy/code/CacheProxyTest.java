package hello.advanced.proxy.code;

import org.junit.jupiter.api.Test;

public class CacheProxyTest {

    @Test
    void cacheProxyTest() {
        RealSubject realSubject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject);

    }
}
