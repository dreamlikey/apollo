package com.wdq.basic;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wudq
 * @date 2019/1/29
 */
public class Extends {

    public static void main(String[] args) {
        Set incrementHashSet = new IncrementHashSet();
    }
}

class IncrementHashSet<E> extends HashSet<E> {

    public int count;

    @Override
    public boolean add(E e) {
        count++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
    }
}