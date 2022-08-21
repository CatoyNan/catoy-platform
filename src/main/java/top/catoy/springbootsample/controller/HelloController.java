package top.catoy.springbootsample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.catoy.springbootsample.exception.ServiceException;
import top.catoy.springbootsample.model.BaseResponse;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("hello")
    public BaseResponse<String> hello() {
        return BaseResponse.ok("hello");
    }
}
