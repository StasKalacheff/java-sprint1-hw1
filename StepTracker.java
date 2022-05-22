import java.util.Scanner;

public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter();
    int[][] monthToData;
    int goalSteps = 10000;
    public StepTracker(Scanner scanner) {
        monthToData = new int[12][30];
    }

    public int newGoalSteps() {
        System.out.println("Введите новую цель по количеству шагов в день");
        int newSteps = scanner.nextInt();
        if (newSteps < 0) {
            System.out.println("Значение не может быть отрицательным");
        } else {
            goalSteps = newSteps;
            System.out.println("Ваша новая цель: " + goalSteps + " шагов в день \n");
        }
        return goalSteps;
    }

    public void saveSteps() {
        System.out.println("За какой месяц Вы хотите ввести значение? Введите: 1-Январь...12-Декабрь");
        int month = scanner.nextInt() - 1;
            if (month < 0 || month > 11) {
                System.out.println("Вы ввели неверное значение! Ведите: 1-Январь...12-Декабрь \n");
            } else {
                System.out.println("За какой день Вы хотите ввести значение? Введите: 1 - 30");
                int day = scanner.nextInt() - 1;
                    if (day < 0 || day > 29) {
                        System.out.println("Вы ввели неверное значение! Ведите: 1 - 30 \n");
                    } else {
                        System.out.println("Введите количество шагов");
                        int steps = scanner.nextInt();
                        if (steps < 0) {
                            System.out.println("Не вводите отрицательное значение! \n");
                        } else {
                            monthToData[month][day] = steps;
                        }
                    }
            }

    }
    public void statMonth() {
        System.out.println("За какой месяц хотите узнать статистику? Ведите: 1-Январь...12-Декабрь");
        int sumMonth = 0;
        int maxMonth = 0;
        int middleMonth = 0;
        int maxSeries = 0;
        int series = 0;
        int month = scanner.nextInt() - 1;
        if (month < 0 || month > 11) {
            System.out.println("Вы ввели неверное значение! Ведите: 1-Январь...12-Декабрь \n");
        } else {
            for (int i = 0; i < monthToData[month].length; i++) {
                System.out.print(i + 1 + " День: " + monthToData[month][i] + ", ");
                sumMonth = sumMonth + monthToData[month][i];
                if (monthToData[month][i] > maxMonth) {
                    maxMonth = monthToData[month][i];
                }
                middleMonth = sumMonth / monthToData[month].length;
                if (monthToData[month][i] >= goalSteps) {
                    series++;
                    if (series > maxSeries) {
                        maxSeries = series;
                    }
                } else {
                    series = 0;
                }
            }
            System.out.println("Общее количество шагов за месяц: " + sumMonth);
            System.out.println("Максимальное пройденное количество шагов в месяце: " + maxMonth);
            System.out.println("Среднее количество шагов: " + middleMonth);
            System.out.println("Пройденная дистанция (в км) " + converter.converterKm(sumMonth));
            System.out.println("Количество сожжённых килокалорий " + converter.converterKcal(sumMonth));
            System.out.println("Лучшая серия: " + maxSeries);
        }
    }

}
