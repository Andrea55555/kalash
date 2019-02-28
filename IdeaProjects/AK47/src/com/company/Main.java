import java.util.Scanner;

public class Main {

    enum FireType {
        SINGLE,
        AUTOMATIC
    }

    static class AK47 {
        FireType type = FireType.AUTOMATIC;
        int clip = 30;
        boolean firstClip;

        public void fire() {
            if (clip > 0) {
                switch (type) {
                    case SINGLE:
                        clip = clip - 1;
                        break;
                    case AUTOMATIC:
                    default:
                        clip = clip - 5;
                        break;
                }
            } else {
                System.out.print("Патроны тю тю");
                recharge();
            }
        }

        public void recharge() {
            clip = 30;
            System.out.print("Перезаряжен");
        }

        public void printType() {
            String msg;
            switch (type) {
                case SINGLE:
                    msg = "Cтреляет одиночными";
                    break;
                case AUTOMATIC:
                default:
                    msg = "Cтреляете очередью";
                    break;
            }
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        AK47 myAK47 = new AK47();
        System.out.print("Для выхода нажмите \"Х\".\n");
        System.out.print("Для стельбы одиночными патронами введите 1 иначе будет автоматическая стрельба.\n");

        while (myScanner.hasNext()) if (myScanner.hasNextInt()) {
            int number = myScanner.nextInt();
            if (number == 1) {
                myAK47.type = FireType.SINGLE;
            } else {
                myAK47.type = FireType.AUTOMATIC;
            }
            break;
        } else {
            System.out.println("Извините, но это явно не число. Попробуйте ещё раз");
            break;
        }
        System.out.println("Нажмите 5 для выхода.");
        System.out.println("Нажмите 0 для выстрела и 9 для перезарядки.\n");

        while (myScanner.hasNext()) {
            if (myScanner.hasNextInt()) {
                int input2 = myScanner.nextInt();
                if (input2 == 0) {
                    myAK47.fire();
                    System.out.println("Огонь\n");
                } else if (input2 == 9) {
                    myAK47.recharge();
                    System.out.println("Перезаредил\n");
                } else if (input2 == 5) {
                    System.out.println("Выход\n");
                    break;
                }
            } else {
                System.out.println("Извините, но это явно не число. Попробуйте ещё раз");
                break;
            }
        }

        myScanner.close();
    }
}