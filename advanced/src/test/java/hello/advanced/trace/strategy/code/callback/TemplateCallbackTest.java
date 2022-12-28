package hello.advanced.trace.strategy.code.callback;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

@Slf4j
public class TemplateCallbackTest {

    /**
     * 템플릿 콜백 패턴: 익명 내부 클래스, 람다
     */
    @Test
    public void callbackV1() throws Exception {
        //given
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("비즈니스 로직 익명 내부 클래스");
            }
        });
        //when

        template.execute(() -> log.info("비즈니스 로직 람다"));
        //then

    }


    static class Person implements Comparable<Person> {
        int age;

        public Person(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(Person person) {
            return this.age - person.age;
        }
    }

    static class Child {
        int age;
        int level;
        public Child (int age, int level) {
            this.age = age;
            this.level = level;
        }
    }


    @Test
    public void 람다() throws Exception {
        //given
        PriorityQueue<Person> queue = new PriorityQueue<>();
        PriorityQueue<Child> queue2 = new PriorityQueue<>(
                (child, t1) -> {

                    if (child.age == t1.age) {
                        return child.level - t1.level;
                    }
                    return child.age - t1.age;
                }
        );


        //when
        queue.add(new Person(10));
        queue.add(new Person(11));

        queue2.add(new Child(12, 14));
        queue2.add(new Child(13, 14));

        //then
        System.out.println(queue.poll());
        System.out.println(queue2.poll().age);
    }



}
