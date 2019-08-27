package probe.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import org.springframework.stereotype.Service;
import probe.model.Member;
import probe.model.MembersGroup;

@Service
public class Finder {
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

    public Set<String> findOldMembers(List<MembersGroup> groups) {
        Set<String> memberNames = new HashSet<>();
        for (MembersGroup membersGroup : groups) {
            for (Member member : membersGroup.getMembers()) {
                if (member.getAge() > 50) {
                    String name = member.getName();
                    memberNames.add(name);
                }
            }
        }
        return memberNames;
    }
}
