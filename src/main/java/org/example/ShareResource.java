package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShareResource<T> {
    private final List<T> list=new ArrayList<>();
    private final Random random=new Random();

    public void addToList(T element){
        if (!list.contains(element)){
            list.add(element);
        }
    }
    public T removeFromList(){
        T element=null;
        if (!list.isEmpty()){
            element=list.remove(random.nextInt(list.size()));
        }
        return element;
    }

    public List<T> getList() {
        return list;
    }
}
