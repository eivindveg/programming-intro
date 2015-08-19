package ninja.eivind.haas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class HelloController {

    @RequestMapping("/hello/{name}")
    public ModelAndView hello(@PathVariable String name) {
        return new ModelAndView("hello", "name", name);
    }

    @RequestMapping("/aloha/{name}")
    public ModelAndView aloha(@PathVariable String name) {
        return new ModelAndView("aloha", "name", name);
    }

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
