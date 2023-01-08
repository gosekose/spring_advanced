package hello.aop.blog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class BlogRepository {

    public void save(String content) {

        log.info("[BlogRepository.save 실행]");
        if (content == null) {
            log.info("[BlogRepository.save 에러]");
            throw new IllegalArgumentException();
        }

        log.info("[BlogRepository.save 저장]");
    }

    public String load(Long blogId) {

        log.info("[BlogRepository.load 실행]");

        if (blogId == null) {
            log.info("[BlogRepository.load 에러]");
            throw new IllegalArgumentException();
        }

        log.info("[BlogRepository.load 성공]");
        return "안녕하세요";
    }
}
