package schemas;

import java.util.ArrayList;
import java.util.List;

public class Group {

    //NOTE: groupSize also includes the users themselves, so groupSize == 1 means they are alone
    private int groupSize;
    private boolean withSignificantOther;
    private boolean withFamily;
    private List<GroupMember> members = new ArrayList<>();

    public Group(int groupSize, boolean withSignificantOther, boolean withFamily) {
        this.groupSize = groupSize;
        this.withSignificantOther = withSignificantOther;
        this.withFamily = withFamily;
    }

    public List<GroupMember> getMembers() {
        return members;
    }

    public void setMembers(List<GroupMember> members) {
        this.members = members;
    }

    public void addMember(GroupMember member) {
        this.members.add(member);
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public boolean isWithSignificantOther() {
        return withSignificantOther;
    }

    public void setWithSignificantOther(boolean withSignificantOther) {
        this.withSignificantOther = withSignificantOther;
    }

    public boolean isWithFamily() {
        return withFamily;
    }

    public void setWithFamily(boolean withFamily) {
        this.withFamily = withFamily;
    }
}
