package hello.aop.blog;

public interface BlogService {
    String load(Long blogId);
    void save(String content);
}
