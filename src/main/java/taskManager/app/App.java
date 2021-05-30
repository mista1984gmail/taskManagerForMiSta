package taskManager.app;

import taskManager.domain.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        LocalDateTime ldtFTCreation=LocalDateTime.of(2021,5,23,10,5);
        LocalDateTime ldtFTDelivery=LocalDateTime.of(2021,5,30,10,5);
        OneTimeTask oneTimeTask =
                new OneTimeTask("First","Do smth",Priority.LOW, Status.APPOINTED,ldtFTCreation,ldtFTDelivery);


        LocalDateTime ldtSTCreation=LocalDateTime.of(2021,5,21,21,00);
        LocalDateTime ldtSTDelivery=LocalDateTime.of(2021,5,27,10,5);
        RepeatableTask repeatableTask =
                new RepeatableTask("Second","Read smth",Priority.MIDDLE,Status.APPOINTED,ldtSTCreation,ldtSTDelivery,"two times a week");

        List<Task>taskList=new ArrayList<>();

        User user = new User("Stas");
        user.setId(1);

        user.addTask(taskList,oneTimeTask);
        user.addTask(taskList,repeatableTask);

        System.out.println(taskList);
        System.out.println("____________");

        user.sortByPriority(taskList);

        System.out.println(taskList);

        user.sortByName(taskList);
        System.out.println("____________");

        System.out.println(taskList);


    }
}
