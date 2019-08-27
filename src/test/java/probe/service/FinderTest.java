package probe.service;

import org.junit.Test;
import probe.model.Member;
import probe.model.MembersGroup;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;

/*
    3)
    Написать модульные тесты. Тестирование классов модели исключить.
 */
public class FinderTest {
    @Test
    public void findMembers() {
        Member m11, m12, m21;
        List<MembersGroup> mg = Arrays.asList(
                new MembersGroup("TG1", Arrays.asList(
                        (m11 = new Member("11", 20)),
                        (m12 = new Member("12", 30)),
                        new Member("13", 40)
                )),
                new MembersGroup("TG2", Arrays.asList(
                        (m21 = new Member("21", 11)),
                        new Member("22", 31),
                        new Member("23", 51)
                ))
        );
        List<Member> actual = new Finder().findMembers(mg, m -> m.getAge() < 31).collect(Collectors.toList());

        assertThat(actual).containsExactlyInAnyOrder(m11, m12, m21);
    }

    @Test
    public void findOldMemberNames() {
        List<MembersGroup> mg = Arrays.asList(
                new MembersGroup("TG1", Collections.singletonList(
                        new Member("1_40", 40)
                )),
                new MembersGroup("TG2", Arrays.asList(
                        new Member("2_31", 31),
                        new Member("2_51", 51),
                        new Member("2_99", 99)
                ))
        );
        Set<String> actual = new Finder().findOldMemberNames(mg);

        assertThat(actual).containsExactlyInAnyOrder("2_51", "2_99");
    }
}