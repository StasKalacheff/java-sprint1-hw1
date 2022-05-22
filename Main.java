import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        printMenu();
        int userInput = scanner.nextInt();
        while (true) {
           if (userInput == 1) {
               stepTracker.saveSteps();
           } else if (userInput == 2) {
               stepTracker.statMonth();
            } else if (userInput == 3) {
               stepTracker.newGoalSteps();
           } else if (userInput == 4) {
               break;
           } else {
               System.out.println("Извините, такой команды пока нет.");
           }
           printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }
    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }
}




