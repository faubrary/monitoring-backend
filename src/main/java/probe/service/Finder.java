package probe.service;

import org.springframework.stereotype.Service;
import probe.model.Member;
import probe.model.MembersGroup;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class Finder {
    // Данные могут храниться в хранилище в виде статических значений (хардкод) ...
    public static final List<MembersGroup> GROUPS_IN_MEMORY = Arrays.asList(
            new MembersGroup("MG A", Arrays.asList(
                    new Member("A10", 10),
                    new Member("A20", 20),
                    new Member("A30", 30),
                    new Member("A40", 40),
                    new Member("A50", 50),
                    new Member("A51", 51)
            )),
            new MembersGroup("MG B", Arrays.asList(
                    new Member("B11", 11),
                    new Member("B31", 31),
                    new Member("B51", 51)
            ))
    );

    /*
        2)
        Отрефакторить класс Finder с применяем Java 8 Stream API для использования его в REST
        сервисе.
        ...
        Приветствуется архитектурный рефакторинг.

        fa: смысла в  interface OldMemberFinder не увидел, выпилил.
     */
    public Set<String> findOldMemberNames(List<MembersGroup> groups) {
        return findMembers(groups, m -> m.getAge() > 50).map(Member::getName).collect(Collectors.toSet());
    }

    public Stream<Member> findMembers(List<MembersGroup> groups, Predicate<Member> memberPredicate) {
        return groups.stream().flatMap(g -> g.getMembers().stream()).filter(memberPredicate);
    }
}
