package com.company;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;

class LocationDatabase
{ //declare each location's information include id,location's name, area, maximum capacity and average time per person
    static class Location1
    {
        int id=1;
        String name="Pavilion";
        int area=100*90;
        int maximum_capacity=area/4;
        int average_time=70;
    }

    static class Location2
    {
        int id=2;
        String name="Lotus";
        int area=85*90;
        int maximum_capacity=area/4;
        int average_time=60;
    }

    static class Location3
    {
        int id=3;
        String name="Mid Valley";
        int area=80*85;
        int maximum_capacity=area/4;
        int average_time=55;
    }

    static class Location4
    {
        int id=4;
        String name="Giant";
        int area=80*75;
        int maximum_capacity=area/4;
        int average_time=50;
    }

    static class Location5
    {
        int id=5;
        String name="The Garden";
        int area=70*70;
        int maximum_capacity=area/4;
        int average_time=40;
    }
}

class SocialBubble{
    public static void social_distance_practice(double north,double south, double east ,double west,int choice) { //print out the social distancing instruction
        Random rd = new Random(); //generate a random boolean value
        if (north < 2 || south < 2 || east < 2 || west < 2) {
            if (rd.nextBoolean()) // check whether the boolean value is ture
            {
                determine_distance(north,south,east,west);
                System.out.println("\nSince you did not practice social distance(around 2 meter) with another person and someone around you has been detected as close contact.\nHence your status will be set as causal contact!");
                print_casual_statement(choice); //print out the casual contact statement
            }
            else //false boolean value
            {
                System.out.println("No one surrounding you had been detected as close contact."); //print out some details
                System.out.println("Please make sure that you follow the instruction below to practice social distancing.");
                determine_distance(north,south,east,west); //determine the location
                print_normal_statement(choice); //print the normal statement
            }

        }
    }

    public static void determine_distance(double north,double south, double east ,double west){
        String[] direction = {"north", "south", "east", "west"}; //array to store the direction
        System.out.println("Social distancing instruction:");
        if (north < 2) { //check the north distance which is less than 2 meter
            north = 2 - north;
            System.out.println("Please move away from " + direction[0] + " by " + String.format("%.1f",north) + " meter");
        }
        if (south < 2) { //check the south distance which is less than 2 meter
            south = 2 - south;
            System.out.println("Please move away from " + direction[1] + " by " + String.format("%.1f",south) + " meter");
        }
        if (east < 2) { //check the east distance which is less than 2 meter
            east = 2 - east;
            System.out.println("Please move away from " + direction[2] + " by " + String.format("%.1f",east) + " meter");
        }
        if (west < 2) { //check the west distance which is less than 2 meter
            west = 2 - west ;
            System.out.println("Please move away from " + direction[3] + " by " + String.format("%.1f",west) + " meter");
        }
    }

    //print out the casual contact user's status
    public static void print_casual_statement(int choice){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // the date in the format "yyyy/MM/dd"
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");   // the time in the format "HH:mm:ss"
        LocalDate localDate = LocalDate.now(); //get the current date
        LocalTime localTime = LocalTime.now(); //get the current time
        if(choice==1){
            System.out.println("\nUser's status:");
            System.out.println("Student ID:20297564\n" + "Name:Lee Boon Kah\n" + "Location ID:1\n"+ "Location:Pavilion\nCurrent Data:"+ date.format(localDate) + "\n"+"Current Time:"+ time.format(localTime)+"\n" +"Status:Casual contact");
        }
        else if(choice==2){
            System.out.println("\nUser's status:");
            System.out.println("Student ID:20297564\n" + "Name:Lee Boon Kah\n" + "Location ID:2\n"+ "Location:Lotus\nCurrent Data:"+ date.format(localDate) + "\n" +"Current Time:"+ time.format(localTime)+"\n"+"Status:Casual contact");

        }
        else if(choice ==3){
            System.out.println("\nUser's status:");
            System.out.println("Student ID:20297564\n" + "Name:Lee Boon Kah\n" + "Location ID:3\n"+ "Location:Mid Valley\nCurrent Data:"+ date.format(localDate) + "\n"+"Current Time:"+ time.format(localTime)+"\n"+"Status:Casual contact");

        }
        else if(choice==4){
            System.out.println("\nUser's status:");
            System.out.println("Student ID:20297564\n" + "Name:Lee Boon Kah\n" + "Location ID:4\n"+ "Location:Giant\nCurrent Data:"+ date.format(localDate) + "\n"+"Current Time:"+ time.format(localTime)+"\n"+"Status:Casual contact");

        }
        else if(choice ==5){
            System.out.println("\nUser's status:");
            System.out.println("Student ID:20297564\n" + "Name:Lee Boon Kah\n" + "Location ID:5\n"+ "Location:The Garden\nCurrent Data: "+ date.format(localDate) +"\n"+"Current Time:"+ time.format(localTime)+"\n"+"Status:Casual contact");

        }
    }
    //print out the normal user's status
    public static void print_normal_statement(int choice){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // the date in the format "yyyy/MM/dd"
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");  // the time in the format "HH:mm:ss"
        LocalDate localDate = LocalDate.now(); //get the current date
        LocalTime localTime = LocalTime.now(); //get the current time

        if(choice==1){
            System.out.println("\nUser's status:");
            System.out.println("Student ID:20297564\n" + "Name:Lee Boon Kah\n" + "Location ID:1\n"+ "Location:Pavilion\nCurrent Data:"+ date.format(localDate) + "\n"+"Current Time:"+ time.format(localTime)+ "\n" +"Status:Normal");
        }

        else if(choice==2){
            System.out.println("\nUser's status:");
            System.out.println("Student ID:20297564\n" + "Name:Lee Boon Kah\n" + "Location ID:2\n"+ "Location:Lotus\nCurrent Data:"+ date.format(localDate) + "\n"+"Current Time:"+ time.format(localTime)+ "\n"+"Status:Normal");
        }

        else if(choice ==3){
            System.out.println("\nUser's status:");
            System.out.println("Student ID:20297564\n" + "Name:Lee Boon Kah\n" + "Location ID:3\n"+ "Location:Mid Valley\nCurrent Data:"+ date.format(localDate) + "\n"+"Current Time:"+ time.format(localTime)+"\n"+"Status:Normal");
        }

        else if(choice==4){
            System.out.println("\nUser's status:");
            System.out.println("Student ID:20297564\n" + "Name:Lee Boon Kah\n" + "Location ID:4\n"+ "Location:Giant\nCurrent Data:"+ date.format(localDate) + "\n"+"Current Time:"+ time.format(localTime)+"\n"+"Status:Normal");
        }

        else if(choice ==5){
            System.out.println("\nUser's status:");
            System.out.println("Student ID:20297564\n" + "Name:Lee Boon Kah\n" + "Location ID:5\n"+ "Location:The Garden\nCurrent Data:"+ date.format(localDate) + "\n"+"Current Time:"+ time.format(localTime)+"\n"+"Status:Normal");
        }
    }

}

public class ProactiveSD extends SocialBubble {

    public static void main(String[] args) {
        LocationDatabase.Location1 L1 = new LocationDatabase.Location1(); //use the data in the class LocationDatabase
        LocationDatabase.Location2 L2 = new LocationDatabase.Location2();
        LocationDatabase.Location3 L3 = new LocationDatabase.Location3();
        LocationDatabase.Location4 L4 = new LocationDatabase.Location4();
        LocationDatabase.Location5 L5 = new LocationDatabase.Location5();
        int choice,choice_input;
        String new_input ;
        Scanner sc = new Scanner(System.in); //scan for input
        String menu = ("Please choose your location that you want to go " + "\n"+"Specification:1-5 are for location picking and 6 is to exit the program\n" + "1." + L1.name + "\n" + "2." + L2.name + "\n" + "3." + L3.name + "\n" + "4." + L4.name + "\n" + "5." + L5.name + "\n" + "6.Exit the program" );
        Random rand = new Random();
        int visitors1 = rand.nextInt(L1.maximum_capacity); //random generator of the visitor based on the maximum capacity
        int visitors2 = rand.nextInt(L2.maximum_capacity);
        int visitors3 = rand.nextInt(L3.maximum_capacity);
        int visitors4 = rand.nextInt(L4.maximum_capacity);
        int visitors5 = rand.nextInt(L5.maximum_capacity);
        double distance_north, distance_south, distance_east, distance_west; //declare the distance
        do {
            System.out.println(menu); //print the menu
            System.out.print("\nSelection: ");  //prompt for the user to input the selection
            //error handling once the user had inserted the string or alphabet
            new_input = null;
            try {
                choice_input = Integer.parseInt(sc.nextLine());
                choice = choice_input; //assign the choice_input's value into the choice which is the global variable
            } catch (Exception e){
                choice = 0;    //assign the choice to zero which is a default value
            }
            int key = 1;

            switch (choice) {
                case 1 -> {
                    System.out.println("\nYour choice: "+choice+"\n"+ "\nLocation's information:"); //display the user's choice and location's information
                    System.out.println("ID:" + L1.id + "\n" + "Location: " + L1.name + "\n" + "Location's area: " + L1.area + " square meters\n" + "Maximum capacity of the location: " + L1.maximum_capacity + " people\n" + "Average time per person mostly stay: " + L1.average_time + " minutes\n");
                    if (visitors1 >= L1.maximum_capacity) {
                        System.out.println("The maximum capacity of the location has been reached.The average time per person to wait is around " + L1.average_time + " minutes");
                        System.out.println("Do you want to wait?");
                        System.out.println("If Yes, please insert Y and you will queue up for the inserted location."); //specification of Y
                        System.out.println("If No, please insert N and you can reinsert the new location that you want to go."); //specification of N
                        System.out.print("Enter your choice(Y/N): "); //prompt the user to enter the input
                        String inputStr = sc.nextLine(); //scan the user input
                        while (key == 1) { //key is used to continue the loop
                            switch (inputStr) {
                                case "y", "Y" -> { // Y and y are accepted
                                    System.out.println("You are queueing up for "+ L1.name +"."+"The time estimated to wait is around "+L1.average_time+ " minutes" +".Sorry for the inconvenient");
                                    System.out.println("Waiting.....\n");
                                    new_input = inputStr; //assign the inputStr value into the new_input which is the global variable
                                    key = 0;  //exit the while loop
                                }

                                case "N", "n" ->{ // N and n are accepted
                                    new_input = inputStr; //assign the inputStr value into the new_input which is the global variable
                                    key = 0;  //exit the while loop
                                }

                                default -> { //Invalid input(error handling)
                                    System.out.println("Invalid input!");
                                    System.out.print("Please reenter again(Y/N): ");//prompt for the user to reenter again
                                    inputStr = sc.nextLine(); //scan the user input
                                    }
                                }
                            }
                        }
                    if (visitors1<L1.maximum_capacity) //to check whether the random generator of visitor is less than the maximum capacity
                    {
                        System.out.println("The location's current capacity is " + visitors1 + " person" + " \nYou may enter the " + L1.name + ".\n"); //print current capacity
                    }
                }
                // case 2,3,4 and 5 have the same concept of the code, the only different is their object name
                case 2 -> {
                    System.out.println("\nYour choice:"+choice+"\n"+ "\nLocation's information:"); //display the user's choice and location's information
                    System.out.println("ID:" + L2.id + "\n" + "Location: " + L2.name + "\n" + "Location's area: " + L2.area + " square meters\n" + "Maximum capacity of the location: " + L2.maximum_capacity + " people\n" + "Average time per person mostly stay: " + L2.average_time + " minutes\n");
                    if (visitors2 >= L2.maximum_capacity) {
                        System.out.println("The maximum capacity of the location has been reached.The average time per person to wait is around " + L2.average_time + " minutes");
                        System.out.println("Do you want to wait?");
                        System.out.println("If Yes, please insert Y and you will queue up for the inserted location.");
                        System.out.println("If No, please insert N and you can reinsert the new location that you want to go.");
                        System.out.print("Enter your choice(Y/N): ");
                        String inputStr = sc.nextLine();
                        while (key == 1) {
                            switch (inputStr) {
                                case "y", "Y" -> {
                                    System.out.println("You are queueing up for "+ L2.name +"."+"The time estimated to wait is around "+L2.average_time+" minutes" +".Sorry for the inconvenient");
                                    System.out.println("Waiting.....\n");
                                    new_input = inputStr;
                                    key = 0;
                                }
                                case "N", "n" ->{
                                    new_input = inputStr;
                                    key = 0;
                                }

                                default -> {
                                    System.out.println("Invalid input!");
                                    System.out.print("Please reenter again(Y/N): ");
                                    inputStr = sc.nextLine();
                                    }
                                }
                            }
                        }
                    if (visitors2<L2.maximum_capacity){
                        System.out.println("The location's current capacity is " + visitors2 + " person" + " \nYou may enter the " + L2.name + ".\n");
                    }
                }

                case 3 -> {
                    System.out.println("\nYour choice:"+choice+"\n"+ "\nLocation's information:");
                    System.out.println("ID:" + L3.id + "\n" + "Location: " + L3.name + "\n" + "Location's area: " + L3.area + " square meters\n" + "Maximum capacity of the location: " + L3.maximum_capacity + " people\n" + "Average time per person mostly stay: " + L3.average_time + " minutes\n");
                    if (visitors3 >= L3.maximum_capacity) {
                        System.out.println("The maximum capacity of the location has been reached.The average time per person to wait is around " + L3.average_time + " minutes");
                        System.out.println("Do you want to wait?");
                        System.out.println("If Yes, please insert Y and you will queue up for the inserted location.");
                        System.out.println("If No, please insert N and you can reinsert the new location that you want to go.");
                        System.out.print("Enter your choice(Y/N): ");
                        String inputStr = sc.nextLine();
                        while (key == 1) {
                            switch (inputStr) {
                                case "y", "Y" -> {
                                    System.out.println("You are queueing up for "+ L3.name +"."+"The time estimated to wait is around "+L3.average_time+" minutes" +".Sorry for the inconvenient");
                                    System.out.println("Waiting.....\n");
                                    new_input = inputStr;
                                    key = 0;
                                }

                                case "N", "n" ->{
                                    new_input = inputStr;
                                    key = 0;
                                }

                                default -> {
                                    System.out.println("Invalid input!");
                                    System.out.print("Please reenter again");
                                    inputStr = sc.nextLine();
                                    }
                                }
                            }
                        }
                    if (visitors3<L3.maximum_capacity){
                        System.out.println("The location's current capacity is " + visitors3 + " person" + " \nYou may enter the " + L3.name + ".\n");
                    }
                }

                case 4 -> {
                    System.out.println("\nYour choice:"+choice+"\n"+ "\nLocation's information:");
                    System.out.println("ID:" + L4.id + "\n" + "Location: " + L4.name + "\n" + "Location's area: " + L4.area + " square meters\n" + "Maximum capacity of the location: " + L4.maximum_capacity + " people\n" + "Average time per person mostly stay: " + L4.average_time + " minutes\n");
                    if (visitors4 >= L4.maximum_capacity) {
                        System.out.println("The maximum capacity of the location has been reached.The average time per person to wait is around " + L4.average_time + " minutes");
                        System.out.println("If Yes, please insert Y and you will queue up for the inserted location.");
                        System.out.println("If No, please insert N and you can reinsert the new location that you want to go.");
                        System.out.print("Enter your choice(Y/N): ");
                        String inputStr = sc.nextLine();
                        while (key == 1) {
                            switch (inputStr) {
                                case "y", "Y" -> {
                                    System.out.println("You are queueing up for "+ L4.name +"."+"The time estimated to wait is around "+L4.average_time+" minutes" +".Sorry for the inconvenient");
                                    System.out.println("Waiting.....\n");
                                    new_input = inputStr;
                                    key = 0;
                                }
                                case "N", "n" -> {
                                    new_input = inputStr;
                                    key = 0;
                                }

                                default -> {
                                    System.out.println("Invalid input!");
                                    System.out.print("Please reenter again(Y/N): ");
                                    inputStr = sc.nextLine();
                                    }
                                }
                            }
                        }
                    if (visitors4<L4.maximum_capacity)
                    {
                       System.out.println("The location's current capacity is " + visitors1 + " person" + " \nYou may enter the " + L4.name + ".\n");
                   }
                }

                case 5 -> {
                    System.out.println("\nYour choice:"+choice+"\n"+ "\nLocation's information:");
                    System.out.println("ID:" + L5.id + "\n" + "Location: " + L5.name + "\n" + "Location's area: " + L5.area + " square meters\n" + "Maximum capacity of the location: " + L5.maximum_capacity + " people\n" + "Average time per person mostly stay: " + L5.average_time + " minutes\n");
                    if (visitors5 >= L5.maximum_capacity) {
                        System.out.println("The maximum capacity of the location has been reached.The average time per person to wait is around " + L5.average_time);
                        System.out.println("If Yes, please insert Y and you will queue up for the inserted location.");
                        System.out.println("If No, please insert N and you can reinsert the new location that you want to go.");
                        System.out.print("Enter your choice(Y/N): ");
                        String inputStr = sc.nextLine();
                        while (key == 1) {
                            switch (inputStr) {
                                case "y", "Y" -> {
                                    System.out.println("You are queueing up for "+ L5.name +"."+"The time estimated to wait is around "+L5.average_time+" minutes" +".Sorry for the inconvenient");
                                    key = 0;
                                }

                                case "N", "n" ->{
                                    new_input = inputStr;
                                    key = 0;
                                }

                                default -> {
                                    System.out.println("Invalid input!");
                                    System.out.print("Please reenter again(Y/N): ");
                                    inputStr = sc.nextLine();
                                    }
                                }
                            }
                        }
                    if (visitors5<L5.maximum_capacity)
                    {
                        System.out.println("The location's current capacity is " + visitors1 + " person" + " \nYou may enter the " + L5.name + ".\n");
                    }
                }

                case 6 -> { //exit the program
                    System.out.println("You choose to exit the program...");
                    System.exit(0);
                }
                //default value to prevent the user inserted the invalid number
                default -> {
                    System.out.println("\nInvalid option!");
                    System.out.println("Please enter the valid number between 1 to 6!");
                    }
            }
        //condition of the do-while loop
        } while ((choice < 1) || (choice > 6) || Objects.equals(Objects.equals(new_input, "N"), true) || (Objects.equals(Objects.equals(new_input, "n"), true)));

        if (Objects.equals(Objects.equals(new_input, "Y"), true) || Objects.equals(Objects.equals(new_input, "y"), true)) //check the input of the Y/N option
        {
            switch (choice){
                case 1-> System.out.println("Thank you for waiting. You can enter "+ L1.name+" now.\n");
                case 2-> System.out.println("Thank you for waiting. You can enter "+ L2.name+" now.\n");
                case 3-> System.out.println("Thank you for waiting. You can enter "+ L3.name+" now.\n");
                case 4-> System.out.println("Thank you for waiting. You can enter "+ L4.name+" now.\n");
                case 5-> System.out.println("Thank you for waiting. You can enter "+ L5.name+" now.\n");
            }
        }
        System.out.println("Enter the distance(in meter) with other in four direction(north, south, east, west)");
        do{//error handling in North
            System.out.println("North:");
            while (!sc.hasNextDouble()) {//check the input is a number or not
                System.out.println("That's not a number! Please enter a positive number!\nNorth:");
                sc.next();
            }
            distance_north = sc.nextDouble();
            if(distance_north<=0){ //make sure that the input is a positive number
                System.out.println("Please reenter a positive number!");
            }
        }while (distance_north <= 0);

        do{//error handling in South
            System.out.println("South:");
            while (!sc.hasNextDouble()) {//check the input is a number or not
                System.out.println("That's not a number! Please enter a positive number!\nSouth:");
                sc.hasNextDouble();
            }
            distance_south = sc.nextDouble();
            if(distance_south<=0){//make sure that the input is a positive number
                System.out.println("Please reenter a positive number!");
            }
        } while (distance_south <= 0);

        do{ //error handling in East
            System.out.println("East:");
            while (!sc.hasNextDouble()) {//check the input is a number or not
                System.out.println("That's not a number! Please enter a positive number!\nEast:");
                sc.next();
            }
            distance_east = sc.nextDouble();
            if(distance_east<=0){//make sure that the input is a positive number
                System.out.println("Please reenter a positive number!");
            }
        } while (distance_east <= 0);

        do{//error handling in West
            System.out.println("West:");
            while (!sc.hasNextDouble()) {//check the input is a number or not
                System.out.println("That's not a number! Please enter a positive number!\nWest:");
                sc.next();
            }
            distance_west = sc.nextDouble();
            if(distance_west<=0){//make sure that the input is a positive number
                System.out.println("Please reenter a positive number!");
            }
        } while (distance_west <= 0);

        if(distance_north<2 || distance_south<2 || distance_east<2 || distance_west<2){ //if one of the distance is less than 2 meter
            social_distance_practice(distance_north,distance_south,distance_east,distance_west,choice); //print out the instruction
        }

        if(distance_north>=2 && distance_south>=2 && distance_east>=2 && distance_west>=2){ //if all the distance are more than 2 meters
            System.out.println("Appreciate your effort in practicing social distancing! Good Job!");
            print_normal_statement(choice); //print the normal status
        }
    }
}