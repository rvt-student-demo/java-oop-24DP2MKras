package rvt;

import java.util.ArrayList;

public class TodoList {
     private ArrayList<String> list = new ArrayList<>();
    public void add(String task){
        list.add(task);
    }
    public void print() {
        int i = 1;
        for (String task : list) {
            System.out.println(i + 1 + ": " + task);
        }
    }
    public void remove(int number) {
            list.remove(number - 1);
    }
    public static void main(String[] args) {
        TodoList list = new TodoList();
        list.add("read the course material");
        list.add("watch the latest fool us");
        list.add("take it easy");

        list.print();
        list.remove(2);

        System.out.println();
        list.print();
    }
}

