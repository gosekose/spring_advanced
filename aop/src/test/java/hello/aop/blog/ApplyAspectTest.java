package hello.aop.blog;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@Import({ApplyAspect.AllLoad.class, ApplyAspect.AllSave.class, ApplyAspect.AllService.class})
class ApplyAspectTest {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    BlogService blogService;

    @Test
    @DisplayName("BlogRepository save AOP 로그 확인")
    public void saveRepository() throws Exception {
        blogRepository.save("안녕하세요");
    }

    @Test
    @DisplayName("BlogRepository save 실패 AOP 로그 확인")
    public void failSaveRepository() throws Exception {
        Assertions.assertThatThrownBy(() -> blogRepository.save(null))
                        .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("BlogRepository load AOP 로그 확인")
    public void loadRepository() throws Exception {
        String load = blogRepository.load(14L);
        assertThat(load).isEqualTo("안녕하세요");
    }

    @Test
    @DisplayName("BlogRepository load 실패 AOP 로그 확인")
    public void failLoadRepository() throws Exception {
        Assertions.assertThatThrownBy(() -> blogRepository.load(null))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("BlogService save AOP 로그 확인")
    public void saveService() throws Exception {
        blogService.save("안녕하세요");
    }

    @Test
    @DisplayName("BlogService save 실패 AOP 로그 확인")
    public void failSaveService() throws Exception {
        Assertions.assertThatThrownBy(() -> blogService.save(null))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("BlogService load AOP 로그 확인")
    public void loadService() throws Exception {
        String load = blogService.load(14L);
        assertThat(load).isEqualTo("안녕하세요");
    }

    @Test
    @DisplayName("BlogService load 실패 AOP 로그 확인")
    public void failLoadService() throws Exception {
        Assertions.assertThatThrownBy(() -> blogService.load(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

}