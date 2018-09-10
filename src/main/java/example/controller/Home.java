package example.controller;

import example.pojo.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;

@Controller
public class Home {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public ModelAndView json() {
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        mv.addObject("name", "hi");
        mv.addObject("age", "99");
        return mv;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<String> list() {
        ArrayList<String> array = new ArrayList<String>();
        array.add("test");
        array.add("test2");
        return array;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody
    People user() {
        People p = new People();
        p.setAge("16");
        p.setName("lily");
        return p;
    }


    @RequestMapping(value = "/userself")
    public ModelAndView userself() {
        ModelAndView modelAndView = new ModelAndView("myname");
        modelAndView.addObject("name", "测试页面");
        modelAndView.addObject("nihao", "你好，");
        return modelAndView;
    }


}