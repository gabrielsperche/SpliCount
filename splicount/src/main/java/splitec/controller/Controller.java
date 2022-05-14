package splitec.controller;

import org.springframework.web.bind.annotation.*;
import splitec.entities.User;
import splitec.service.Service;

@RestController
@RequestMapping("/api")
public class Controller extends Service {
    @GetMapping("/user/{id}")
    String getUserNameById(@PathVariable String id) {
        return getUserName(id);
    }

    @PostMapping("/auth")
    public String teste(@RequestBody User user){
        return "ok";
    }

    @GetMapping("/teste")
    String teste(){
        return "Murilo";
    }
}