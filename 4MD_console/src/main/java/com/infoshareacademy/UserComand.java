package com.infoshareacademy;

import java.util.Scanner;

import static java.lang.System.exit;



    public class UserComand {
        public static void main(String[] args) {


            int select;
            int select1;
            int select2;
            int select3;
            Scanner scanner = new Scanner(System.in);


            System.out.println("Witam, Wybierz opcje:");
            System.out.println("1 - Przepisy");
            System.out.println("2 - Moje przepisy");
            System.out.println("3 - Planner");
            System.out.println("4 - Lista zakupów");
            System.out.println("5 - exit");


            int option = 1;
            while (option == 1) {
                select = scanner.nextInt();
                switch (select) {
                    case 1:
                        System.out.println("Chciałbyś :");
                        System.out.println("1 - Wyszukiwarka przepisów");
                        System.out.println("2 - Najpopularniejsze przepisy");
                        System.out.println("3 - Najlepiej oceniany przepis");
                        int option1 = 1;
                        select1 = scanner.nextInt();
                        while (option1 == 1) {
                            switch (select1) {
                                case 1:
                                    System.out.println("test 1");
                                    //open search class
                                    option1++;
                                    break;
                                case 2:
                                    System.out.println("test 2");
                                    // open recipe class sort by popularity
                                    option1++;
                                    break;
                                case 3:
                                    System.out.println("test 3");
                                    // open recipe class sort by rating
                                    option1++;
                                    break;
                                default:
                                    System.out.println("nieprawidłowo wybrana opcja , spróbuj ponownie");
                                    select1 = scanner.nextInt();
                            }
                        }

                        option++;
                        break;

                    case 2:
                        System.out.println("Chciałbyś :");
                        System.out.println("1 - Moje zapisane przepisy");
                        System.out.println("2 - Dodaj nowy przepis");
                        System.out.println("3 - Edytuj przepis");
                        System.out.println("4 - Usuń zapisany przepis");
                        int option2 = 1;
                        select2 = scanner.nextInt();
                        while (option2 == 1) {
                            switch (select2) {
                                case 1:
                                    System.out.println("test 1");
                                    //open MyRecipe class
                                    option2++;
                                    break;
                                case 2:
                                    System.out.println("test 2");
                                    // Add to MyRecipe
                                    option2++;
                                    break;
                                case 3:
                                    System.out.println("test 3");
                                    // Eddit MyRecipe
                                    option2++;
                                    break;
                                case 4:
                                    System.out.println("test  4");
                                    //Delete Recipe
                                    option2++;
                                    break;
                                default:
                                    System.out.println("nieprawidłowo wybrana opcja , spróbuj ponownie");
                                    select1 = scanner.nextInt();
                                    option2++;
                                    break;
                            }
                        }
                        option++;
                        break;
                    case 3:
                        System.out.println("Chciałbyś :");
                        System.out.println("1 - Zobaczyć przepis zaplanowany na jutro");
                        System.out.println("2 - Zobaczyć przsepisy zaplanowane");
                        System.out.println("3 - Wyczyść Planner");

                        int option3 = 1;
                        select3 = scanner.nextInt();
                        while (option3 == 1) {
                            switch (select3) {
                                case 1:
                                    System.out.println("test 1");
                                    //show planned recipe(tomorrow)
                                    option3++;
                                    break;
                                case 2:
                                    System.out.println("test 2");
                                    // show all recipe in planner
                                    option3++;
                                    break;
                                case 3:
                                    System.out.println("test 3");
                                    // clear array in planer
                                    option3++;
                                    break;

                                default:
                                    System.out.println("nieprawidłowo wybrana opcja , spróbuj ponownie");
                                    select1 = scanner.nextInt();
                                    option3++;
                                    break;
                            }
                        }
                        option++;
                        break;
                    case 4:
                        System.out.println("test lista");
                        //show shoppinglist
                        option++;
                        break;
                    case 5:
                        exit(0);
                        break;
                    default:
                        System.out.println("Nieprawidłowo wybrana opcja, wybierz ponownie");

                }


            }
        }
    }


