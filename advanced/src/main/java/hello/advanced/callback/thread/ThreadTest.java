package hello.advanced.callback.thread;

import java.util.UUID;

public class ThreadTest {

    static class Log {
        private String log;
        private String message;

        public Log(String message) {
            this.log = UUID.randomUUID().toString().substring(0, 7);
            this.message = message;
        }

        public String getLog() {
            return log;
        }

        public String getMessage() {
            return message;
        }
    }

    public static void main(String[] args) {

        ThreadLocal<Log> logA = new ThreadLocal<>();
        logA.set(new Log("setLog1"));

        ThreadLocal<Log> logB = new ThreadLocal<>();
        logA.set(new Log("setLog2"));


    }

}
