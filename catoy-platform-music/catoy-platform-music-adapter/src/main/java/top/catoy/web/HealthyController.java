package top.catoy.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/")
public class HealthyController {
    @GetMapping
    public String healthy() {
        return "hello world!222";
    }

    public static class Student {
        int id;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        Date date;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

    }
}
