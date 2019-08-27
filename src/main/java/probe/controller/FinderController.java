package probe.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import probe.model.Member;
import probe.service.Finder;

@Controller
public class FinderController {

    @Autowired
    private Finder finder;

    @GetMapping("/find/younger/{age}")
    public @ResponseBody Member younger(@PathVariable("age") int age) {
        return new Member("someName", age);
    }

    @GetMapping("/find/old")
    public @ResponseBody Set<String> oldMemberNames() {
        return finder.findOldMembers(Finder.GROUPS_IN_MEMORY);
    }
}
