import group.Group;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer{
    private List<Group> projectgroepen;

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o);
    }

    private void getGroupStatus(Group g) {
        System.out.println(g);
    }
}
