package com.hr.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-06
 */
public class NestedIterator_341 implements Iterator<Integer> {

    private final List<Integer> rs;
    private final Iterator<Integer> iterator;

    public NestedIterator_341(List<NestedInteger> nestedList) {
        rs = new ArrayList<>();
        this.init(nestedList);
        this.iterator = rs.iterator();
    }

    private void init(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.isEmpty())
            return;

        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger())
                rs.add(nestedInteger.getInteger());
            else
                this.init(nestedInteger.getList());
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    public interface NestedInteger {

        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }

}
