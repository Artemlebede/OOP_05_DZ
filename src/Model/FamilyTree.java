package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<T extends Person> implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        if (member == null) throw new IllegalArgumentException("Member cannot be null");
        members.add(member);
    }

    public List<T> getMembers() {
        return new ArrayList<>(members);
    }

    public void sortByName() {
        members.sort((a, b) -> a.getName().compareTo(b.getName()));
    }

    public void sortByBirthYear() {
        members.sort((a, b) -> Integer.compare(a.getBirthYear(), b.getBirthYear()));
    }
}