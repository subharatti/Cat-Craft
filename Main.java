import java.util.Scanner;

public class Main {
    public static String[] nameCats(Scanner scanner) {
        boolean validCats = false;
        String cat1 = "", cat2 = "", cat3 = "";
        while (!validCats) {
            try {
                System.out.print("Enter Cat Name 1: ");
                cat1 = scanner.nextLine();
                System.out.print("Enter Cat Name 2: ");
                cat2 = scanner.nextLine();
                System.out.print("Enter Cat Name 3: ");
                cat3 = scanner.nextLine();

                if (cat1.matches("[a-zA-Z]+") && cat2.matches("[a-zA-Z]+") && cat3.matches("[a-zA-Z]+")) {
                    validCats = true;
                } else {
                    throw new Exception("Cat names should be alphabetical characters!");
                }
            } catch (Exception e) {
                System.out.println("Invalid Choice! " + e.getMessage());
            }
        }
        return new String[]{cat1, cat2, cat3};
    }

    public static void mainProgram(String cat1Name, String cat2Name, String cat3Name, Scanner scanner) {
        boolean quit = false;
        Cat cat1 = new Cat(cat1Name);
        Cat cat2 = new Cat(cat2Name);
        Cat cat3 = new Cat(cat3Name);

        while (!quit) {
            System.out.println("------------------------------------------------------------");
            System.out.println("1. " + cat1.toString());
            System.out.println("2. " + cat2.toString());
            System.out.println("3. " + cat3.toString());

            System.out.println("\n1. Feed    2. Hit    3. Night    4. Quit");
            try {
                System.out.print("\nChoice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice < 1 || choice > 4) {
                    throw new Exception("Invalid Choice! Pick between 1-4.");
                } else if (choice == 4) {
                    quit = true;
                    System.out.println("Thank you for playing!");
                } else if (choice == 3) {
                    System.out.print("Which cat? ");
                    int catChoice = Integer.parseInt(scanner.nextLine());
                    switch (catChoice) {
                        case 1 -> cat1.night();
                        case 2 -> cat2.night();
                        case 3 -> cat3.night();
                        default -> throw new Exception("Invalid cat choice, pick from cat 1-3.");
                    }
                } else if (choice == 2) {
                    System.out.print("Which cat? ");
                    int catChoice = Integer.parseInt(scanner.nextLine());
                    switch (catChoice) {
                        case 1 -> cat1.hit();
                        case 2 -> cat2.hit();
                        case 3 -> cat3.hit();
                        default -> throw new Exception("Pick from cat 1-3.");
                    }
                } else { // choice == 1 (feed)
                    System.out.print("Which cat? ");
                    int catChoice = Integer.parseInt(scanner.nextLine());
                    try {
                        switch (catChoice) {
                            case 1 -> cat1.feed();
                            case 2 -> cat2.feed();
                            case 3 -> cat3.feed();
                            default -> throw new Exception("Pick from cat 1-3.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid Choice! " + e.getMessage());
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Choice! Pick between 1-4.");
            } catch (Exception e) {
                System.out.println("Invalid Choice! " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] catNames = nameCats(scanner);
        mainProgram(catNames[0], catNames[1], catNames[2], scanner);
        scanner.close();
    }
}
