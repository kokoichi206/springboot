package com.example.demodemo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloController {

    @GetMapping("/")
    fun index(model: Model): String {
        // Model is used to pass variables to templates
        model.addAttribute("message", "Hello Wo")
        // return value is HTML file name, and need to create a templates index file.
        return "index"
    }
}