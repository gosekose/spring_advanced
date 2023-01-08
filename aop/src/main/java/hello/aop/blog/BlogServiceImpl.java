package hello.aop.blog;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Override
    public String load(Long blogId) {

        log.info("[BlogService.load 실행]");
        String content = blogRepository.load(blogId);
        log.info("[BlogService.load 완료] content = {}", content);

        return content;
    }


    @Override
    public void save(String content) {

        log.info("[BlogService.save 실행]");
        blogRepository.save(content);
        log.info("[BlogService.save 완료]");

    }
}
