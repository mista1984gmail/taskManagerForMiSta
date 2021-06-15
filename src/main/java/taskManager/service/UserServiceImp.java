package taskManager.service;

import lombok.extern.slf4j.Slf4j;
import taskManager.domain.*;
import taskManager.repository.UserRepository;

import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;

@Slf4j
public class UserServiceImp implements UserService {

    private UserRepository repository;
    public static final Consumer<User> LOG_ACTION = user ->
            log.info(user.getNameUser() + ": " + user.getId());
    public final Consumer<Task> LOG_ACTION_DEAD_LINE = task ->
            log.info(task.getNameTask() + ": " + Duration.between(getTimeNow(),task.getDateOfDelivery()).toDays());

    public UserServiceImp(UserRepository repository) {
        this.repository = repository;
    }

    public LocalDateTime getTimeNow(){
        LocalDate date = LocalDate.now(); // получаем текущую дату
        int year = date.getYear();
        int month = date.getMonthValue();
        int dayOfMonth = date.getDayOfMonth();
        LocalDateTime ldtFTCreation=LocalDateTime.of(year,month,dayOfMonth,0,0);
        return ldtFTCreation;
    }

    @Override
    public void saveUser(@NotNull User user) throws Exception {
        log.info("Trying to save user: {}", user);
        boolean isUserSaved = repository.saveUser(user);
        String success = isUserSaved ? "" : "not ";
        log.info("User was {}saved: {}", success, user);
    }

    @Override
    public User getUser(int id) throws Exception {
        log.info("Trying to get user with id = '{}'", id);
        Optional<User> user = repository.getUser(id);
        if (user.isPresent()) {
            log.info("{} is gotten", user.get());
            return user.get();
        } else {
            log.info("Creating new user because no user with id");
            return User.builder().id(id).build();
        }
    }
    @Override
    public void showShortInfo() throws Exception {
        log.info("Showing short info about users");
        repository.getUsers().forEach(LOG_ACTION);
    }

    @Override
    public void deleteUser(int id) throws Exception {
        log.info("Trying to delete user with id= '{}'", id);
        repository.deleteUser(id);
        }

    @Override
    public void showTaskInfo(int id) throws Exception {
        log.info("Showing task users");
        log.info(String.valueOf(repository.tasks(id)));
    }

    @Override
    public Task addTask() throws Exception {
        Scanner scanner = new Scanner(System.in);
        log.info("Name Task: ");
        String nameTask=scanner.nextLine();
        log.info("Task Content: ");
        String taskContent=scanner.nextLine();
        log.info("Priority 1 - HIGH; 2 - MIDDLE; 3 - LOW");
        int i = scanner.nextInt();
        Priority priority=null;
        switch (i){
            case 1:
                priority = Priority.HIGH;
                break;
            case 2:
                priority = Priority.MIDDLE;
                break;
            case 3:
                priority = Priority.LOW;
                break;
            default:
                log.info("There is no such option, please choose another option.");
        }
        log.info("Status 1 - APPOINTED; 2 - IN_PROCESS; 3 - COMPLETED;"
                + " 4 - NOT_COMPLETED; 5 - DELETED");
        int j = scanner.nextInt();
        Status status=null;
        switch (i){
            case 1:
                status = Status.APPOINTED;
                break;
            case 2:
                status = Status.IN_PROCESS;
                break;
            case 3:
                status = Status.COMPLETED;
                break;
            case 4:
                status = Status.NOT_COMPLETED;
                break;
            case 5:
                status = Status.DELETED;
                break;
            default:
                log.info("There is no such option, please choose another option.");
        }

        LocalDate date = LocalDate.now(); // получаем текущую дату
        int year = date.getYear();
        int month = date.getMonthValue();
        int dayOfMonth = date.getDayOfMonth();
        LocalDateTime ldtFTCreation=LocalDateTime.of(year,month,dayOfMonth,0,0);

        log.info("Enter the due date for the task");
        log.info("Enter year");
        int yearOfDeadLine = scanner.nextInt();
        log.info("Enter month");
        int monthOfDeadLine = scanner.nextInt();
        log.info("Enter day");
        int dayOfDeadLine = scanner.nextInt();


        LocalDateTime ldtFTDelivery=LocalDateTime.of(yearOfDeadLine,monthOfDeadLine,dayOfDeadLine,0,0);

        Task task = new OneTimeTask(nameTask,taskContent,priority, status,ldtFTCreation,ldtFTDelivery);
        return task;
    }

    @Override
    public void showDeadLineInfo(int id) throws Exception {
        log.info("Showing task users");
        repository.tasks(id).forEach(LOG_ACTION_DEAD_LINE);
    }

    @Override
    public void sortTaskByPriority(int id) throws Exception {
        log.info("Showing task users");
        List<Task>taskList=repository.tasks(id);
        Collections.sort(taskList, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.getPriority().getI() > o2.getPriority().getI()) {
                    return 1;
                } else if (o1.getPriority().getI() < o2.getPriority().getI()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for (Task task:taskList) {
            System.out.println(task);
        }
    }
}
