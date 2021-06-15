package taskManager.app;

import lombok.extern.slf4j.Slf4j;
import taskManager.db.BD;
import taskManager.domain.*;
import taskManager.repository.UserRepositoryImp;
import taskManager.service.UserServiceImp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Slf4j
public class App {
    public static final UserRepositoryImp USER_REPOSITORY = new UserRepositoryImp();
    public static final UserServiceImp USER_SERVICE = new UserServiceImp(USER_REPOSITORY);
    public static void main(String[] args) throws Exception {

        //Создание Пользователя

        //createUser();

        //загрузка БД

       BD.getInstance().load();

        int userInput = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            // instructions
            log.info("Type 0 to stop");//выход из приложения
            log.info("Type 1 to show short info");//показ информации о пользователях
            log.info("Type 2 to delete user");//удаление пользователя
            log.info("Type 3 to show task user");//показать задчи пользователя
            log.info("Type 4 to add user");//добавить пользователя
            log.info("Type 5 to add user task");//добавить пользователю задачу
            log.info("Type 6 to find out how many days are left until deadLine");//сколько дней до сдачи задания
            log.info("Type 7 sort tasks by priority");//сортировка по приоритету задач

            // reading input
            userInput = scanner.nextInt();

            // choosing option
            switch (userInput) {
                case 0:
                    log.info("Goodbye!");
                    break;
                case 1:
                    USER_SERVICE.showShortInfo();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    showTasksUser();
                    break;
                case 4:
                    addUser();
                    break;
                case 5:
                    addUserTask();
                    break;
                case 6:
                    deadLineDay();
                    break;
                case 7:
                    sortByPriority();
                    break;
                default:
                    log.info("There is no such option, please choose another option.");
            }

        } while (userInput != 0);

        BD.getInstance().save();
    }

    private static void sortByPriority() throws Exception {
        int id;
        log.info("Input information id User for sort by priority");
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextInt();
        USER_SERVICE.sortTaskByPriority(id);
    }


    private static void deadLineDay() throws Exception {
        int id;
        log.info("Input information id User for show tasks of deadLine");
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextInt();
        USER_SERVICE.showDeadLineInfo(id);
    }

    private static void showTasksUser() throws Exception {
        int id;
        log.info("Input information id User for show tasks");
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextInt();
        USER_SERVICE.showTaskInfo(id);
    }




    private static void deleteUser() throws Exception {
        int idForDelete;
        log.info("Input information id User for delete");
        Scanner scanner = new Scanner(System.in);
        idForDelete = scanner.nextInt();
        USER_SERVICE.deleteUser(idForDelete);
    }



    private static void addUser() throws Exception {
        User.UserBuilder builder = User.builder();

        log.info("Input information about User");
        Scanner scanner = new Scanner(System.in);

        log.info("Name: ");
        builder.nameUser(scanner.nextLine());
        builder.taskList(new ArrayList<>());
        User user = builder.build();

        USER_SERVICE.saveUser(user);
    }
    private static void addUserTask() throws Exception {
        log.info("Input information about User what put task");
        Scanner scanner = new Scanner(System.in);
        int idUser=scanner.nextInt();
        User user = USER_SERVICE.getUser(idUser);
        List<Task>taskList= user.getTaskList();
        taskList.add(USER_SERVICE.addTask());
    }


    private static void createUser() throws Exception {
        LocalDateTime ldtFTCreation=LocalDateTime.of(2021,5,23,10,5);
        LocalDateTime ldtFTDelivery=LocalDateTime.of(2021,5,30,10,5);
        OneTimeTask oneTimeTask =
                new OneTimeTask("First","Do smth", Priority.LOW, Status.APPOINTED,ldtFTCreation,ldtFTDelivery);


        LocalDateTime ldtSTCreation=LocalDateTime.of(2021,5,21,21,00);
        LocalDateTime ldtSTDelivery=LocalDateTime.of(2021,5,27,10,5);
        RepeatableTask repeatableTask =
                new RepeatableTask("Second","Read smth",Priority.MIDDLE,Status.APPOINTED,ldtSTCreation,ldtSTDelivery,"two times a week");

        List<Task> taskList=new ArrayList<>();
        taskList.add(oneTimeTask);
        taskList.add(repeatableTask);

        User.UserBuilder builder = User.builder();
        builder.id(5).nameUser("Aliona").taskList(taskList);
        User user = builder.build();
        USER_SERVICE.saveUser(user);
        BD.getInstance().executeSaveOperation(user);
        BD.getInstance().save();
    }
}
