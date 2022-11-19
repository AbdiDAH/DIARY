

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int userChoice;

        do {
            System.out.println("Hi welcome, you have now accessed this diary," +
                    " go ahead and choise an alternativ throw 1-3");
            Diaryserver.DiaryMenu();

            userChoice=scanner.nextInt();
            switch (userChoice){
                case 1:
                    Diaryserver.AddDiariesToJson();

                    break;

                case 2:

                    Diaryserver.readdiaries();

                    break;

                case 3:
                    Diaryserver.TheEnd();

                    break;
                case 4:
                    Diaryserver.Error();

                default:
                    System.out.println("Try again");
            }
        }
        while (userChoice !=3);


    }
}
