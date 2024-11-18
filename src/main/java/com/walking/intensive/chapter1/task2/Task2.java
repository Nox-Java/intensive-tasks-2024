package com.walking.intensive.chapter1.task2;

/**
 * Реализуйте метод getFlatLocation(), который будет принимать параметрами следующие данные:
 * <ul>
 * <li> Количество этажей в доме;
 * <li> Количество подъездов;
 * <li> Номер нужной квартиры.
 * </ul>
 *
 * <p>Необходимо определить подъезд, этаж и расположение нужной квартиры относительно лифта,
 * руководствуясь следующими правилами:
 * <ul>
 * <li> На этаже 4 квартиры;
 * <li> Нумерация квартир возрастает по часовой стрелке.
 * </ul>
 *
 * <p>Примеры строки, возвращаемой из метода:
 * <ul>
 * <li> 1 кв – 1 подъезд, 1 этаж, слева от лифта, влево
 * <li> 2 кв – 1 подъезд, 1 этаж, слева от лифта, вправо
 * <li> 3 кв – 1 подъезд, 1 этаж, справа от лифта, влево
 * <li> 4 кв – 1 подъезд, 1 этаж, справа от лифта, вправо
 * </ul>
 *
 * <p>Если для дома с указанной этажностью и количеством подъездов квартиры с заданным номером не существует,
 * метод должен вернуть строку "Такой квартиры не существует".
 *
 * <p>Если хотя бы один из указанных параметров некорректный - например, отрицательное число или 0,
 * метод должен вернуть строку "Некорректные входные данные".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task2 {
    public static void main(String[] args) {
        int floorAmount = 1;
        int entranceAmount = 1;
        int flatNumber = 4;

        System.out.println(getFlatLocation(floorAmount, entranceAmount, flatNumber));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {

        int entranceNumber;
        int floorNumber;
        String flatLocation = "";

        if (floorAmount > 0 || entranceAmount > 0 || flatNumber > 0) {
            if (flatNumber > floorAmount * entranceAmount * 4) {
                return "Такой квартиры не существует";
            }
            entranceNumber = ((flatNumber - 1) / (floorAmount * 4)) + 1;
            floorNumber = floorAmount - (((entranceNumber * floorAmount * 4) - flatNumber) / 4);

            flatLocation = switch (flatNumber % 4) {
                case 0 -> "справа от лифта, вправо";
                case 1 -> "слева от лифта, влево";
                case 2 -> "слева от лифта, вправо";
                case 3 -> "справа от лифта, влево";
                default -> flatLocation;
            };

            return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + " этаж, " + flatLocation;

        }
        return "Некорректные входные данные";
    }
}
