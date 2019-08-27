package probe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class MembersGroup {
    private final String groupName;
    private final List<Member> members;
}
