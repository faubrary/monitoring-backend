package probe.model;

public class Member {
    private final String name;
    private final int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
