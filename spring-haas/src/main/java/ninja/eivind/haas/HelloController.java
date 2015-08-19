package ninja.eivind.haas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
@RequestMapping("")
public class HelloController {

    @RequestMapping("/hello/{name}")
    public ModelAndView hello(@PathVariable String name) {
        return new ModelAndView("hello", "name", name);
    }

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
