package info.natebowang.wbqly.qlyuser;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QlyuserController {

    @PreAuthorize("#username == authentication.name")
    @RequestMapping(value = "/haha")
    public String findByUsernameWithSe(@RequestParam("username") String username) {
        return username;
    }

}
