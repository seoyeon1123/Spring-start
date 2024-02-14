package hello.hellospring.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!!");
        return "hello";
    };
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //HTTP Body부분에 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private  String name;
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }

    }
    @GetMapping("diarys")
    @ResponseBody
    public Diary getDiary(@RequestParam("email") String email){
        Diary diary = new Diary();
        diary.setEmail(email);
        return diary;
    }
    static class Diary{
        private String email;
        private String tittle;

        public String getEmail(){
            return email;
        }
        public void setEmail(String email){
            this.email = email;
        }
        public String getTittle(){
            return tittle;
        }
        public void setTittle(String tittle){
            this.tittle = tittle;
        }
    }

}
