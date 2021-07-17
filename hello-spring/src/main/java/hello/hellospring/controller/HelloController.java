package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping ("hello")
    public String hello (Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }
    @GetMapping ("hello-mvc")
    public String helloMvc (@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping ("hello-string")
    @ResponseBody //http 에서의 body부를 의미함. 즉, html body에 직접 넣겠다라는 의미 즉, view로 가지않음
    //문자로 그대로 가는 것이다. 그대로 데이터가 넘어감
    public String helloString (@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping ("hello-api")
    @ResponseBody
    public Hello helloApi (@RequestParam ("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

        //json으로 넘어간다.
    }

    static class Hello {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
