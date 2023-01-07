package hello.advanced.autoproxy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutoProxyService {

    private final AutoProxyRepository autoProxyRepository;

    public void joinTeam(String name) {
        autoProxyRepository.join(name);
    }


}
