package probe.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import probe.model.Member;
import probe.service.Finder;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class FinderController {
    private Finder finder;

    /*
        1)
        На базе данного кода сделать минимальное spring boot приложение с
        REST API сервисом, который предоставляет список Member младше переданного возраста.
        Данные могут храниться в хранилище в виде статических значений (хардкод) или БД (in-
        memory).

        Ручная проверка: после
         ./gradlew bootRun
        запустить
         curl http://localhost:5687/find/younger/25
     */
    @GetMapping("/find/younger/{age}")
    public @ResponseBody
    List<Member> younger(@PathVariable("age") int age) {
        return finder.findMembers(Finder.GROUPS_IN_MEMORY, m -> m.getAge() < age).collect(Collectors.toList());
    }

    /*
        curl http://localhost:5687/find/old
     */
    @GetMapping("/find/old")
    public @ResponseBody
    Set<String> oldMemberNames() {
        return finder.findOldMemberNames(Finder.GROUPS_IN_MEMORY);
    }
}
