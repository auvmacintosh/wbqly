package info.natebowang.wbqly.qlyuser;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class QlyuserController {

    @PreAuthorize("#username == authentication.name")
    @RequestMapping(value = "/haha/{username}")
    public String findByUsernameWithSe(@PathVariable("username") String username) {
        return username;
    }

}
