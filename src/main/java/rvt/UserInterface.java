package rvt;

import java.util.Scanner;

public class UserInterface {
     private TodoList todolist;
            private Scanner scanner;        

            public UserInterface(TodoList todolist) {
                this.todolist = todolist;
                this.scanner = scanner;
            }

            public void start() {
                while(true) {
                    System.out.print("Command: ");
                    String command = scanner.nextLine();

                    if(command.equals("stop")) {
                        break;
                    }
                    if(command.equals("add")) {
                        System.out.print("Task: ");
                        String answer = scanner.nextLine();
                        todolist.add(answer);
                    }

                    if(command.equals("list")) {
                        todolist.print();
                    }
                    if(command.equals("remove")) {
                        System.out.println("fuck niggers");
                        int answer = scanner.nextInt();
                        todolist.remove(answer);
                    }

                }
            }
        }

