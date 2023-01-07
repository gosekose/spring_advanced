package hello.advanced.autoproxy;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/join")
@RequiredArgsConstructor
public class AutoProxyController {

    private final AutoProxyService autoProxyService;

    @GetMapping
    public ResponseEntity joinTeam(@RequestParam("name") String name) {
        autoProxyService.joinTeam(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
