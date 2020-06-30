package com.training.ykb.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonProvisionRest2 {

    @PostMapping("/provision")
    public void provision(@RequestBody final Person person) {
    }

    @GetMapping("/deactivate")
    public void deactivate(@RequestParam("id") final long personId) {
    }

    @PostMapping("/update")
    public void update(@RequestBody final Person person) {
    }

    @GetMapping("/get")
    public void get(@RequestParam("id") final long personId) {
    }


}
