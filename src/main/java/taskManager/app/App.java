package taskManager.app;

import taskManager.domain.OneTimeTask;
import taskManager.domain.Priority;
import taskManager.domain.RepeatableTask;
import taskManager.domain.Status;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        LocalDateTime ldtFTCreation=LocalDateTime.of(2021,5,23,10,5);
        LocalDateTime ldtFTDelivery=LocalDateTime.of(2021,5,30,10,5);
        OneTimeTask oneTimeTask =
                new OneTimeTask("First","Do smth",Priority.HIGH, Status.APPOINTED,ldtFTCreation,ldtFTDelivery);
        System.out.println(oneTimeTask.toString());

        LocalDateTime ldtSTCreation=LocalDateTime.of(2021,5,21,21,00);
        LocalDateTime ldtSTDelivery=LocalDateTime.of(2021,5,27,10,5);
        RepeatableTask repeatableTask =
                new RepeatableTask("Second","Read smth",Priority.LOW,Status.APPOINTED,ldtSTCreation,ldtSTDelivery,"two times a week");
        System.out.println(repeatableTask.toString());

    }
}
