package hello.aop.blog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Slf4j
@Component
public class BlogSaveInterRepository {

    public void saveInternal() {
        log.info("[BlogRepository.saveInternal 실행]");
    }
}
