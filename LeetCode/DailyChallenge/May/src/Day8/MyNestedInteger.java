package Day8;

import java.util.List;

public class MyNestedInteger implements NestedInteger {
    private final Integer value;
    private final List<NestedInteger> list;

    MyNestedInteger(Integer value) {
        this.value = value;
        this.list = null;
    }
    MyNestedInteger(List<NestedInteger> list) {
        this.value = null;
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        return value != null;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
