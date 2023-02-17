package com.example.demo.Model;

import java.io.*;
import java.util.*;

/**
 *This class stores the account of the users and the new account is added with the function in the class.
 * @author Boon Kah Lee
 */
public class Account implements Comparable<Account> {
    /**
     *The variable score is used store the score of the user
     */
    private long score;
    /**
     *The variable userName is used to keep the name of the user
     */
    private final String userName ;
    /**
     *The variable accounts is the arraylist that used to store all the user's account and name
     */
    private static ArrayList<Account> accounts = new ArrayList<>();

    /**
     * This function is the getter function to get content of the accounts arraylist
     * @return accounts arraylist
     */
    public static ArrayList<Account> getAccounts(){
        return accounts;
    }

    /**
     * This function is a setter function
     * @param userName assigns it to the userName
     * @param score assign it to the score
     */
    public Account(String userName, Integer score){
        this.userName=userName;
        this.score=score;
    }

    /**
     * This function is a getter function to get the score
     * @return the value of the score
     */
    public long getScore() {
        return score;
    }
    /**
     * This function is a getter function to get the score
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This function is used to compare the score.
     * @param o the object to be compared.
     * @return the score
     */
    @Override
    public int compareTo(Account o) {
        return Long.compare(o.getScore(), score);
    }

    /**
     *This function is to check there is the same username in the arraylist
     * This function will take the highest score as the score between the existed user and the new user which then store into the arraylist
     * @param userName is the username that inserted by the user
     * @param score is the score at end of the game
     * @return the account when there is same username
     * return null when there is no same name exist.
     */
    static Account accountHaveBeenExist(String userName,int score){
        for(Account account : accounts){
          if (account.getUserName().equals(userName)&& (score>=account.getScore())) {
                accounts.remove(account);
                makeNewAccount(userName,score);
                return account;
            }else if(account.getUserName().equals(userName)&& (score<account.getScore())){
                accounts.remove(account);
                makeNewAccount(userName, (int) account.getScore());
                return account;
            }
        }
        return null;

    }

    /**
     * This function is used to store the previous and current user's username and score into the arraylist account
     * @param userName is the name of the user
     * @param score is the score of the user
     * @return the account
     */
    static Account makeNewAccount(String userName,Integer score){
        Account account = new Account(userName,score);
        accounts.add(account);
        return account;
    }

    /**
     * This function is used to read the file and store the username and score in the arraylist accounts
     * @throws Exception when unable to open the score.txt
     */

    public static void ReadFile() throws Exception {
        FileReader FileRead= new FileReader("src/main/java/com/example/demo/Database/Score.txt");
        BufferedReader br = new BufferedReader(FileRead);
        String line;
        boolean skip = false;
        try {
            while((line = br.readLine()) !=null){
                if(!skip){
                    skip = true;
                }else {
                    String[] Content =line.split(",");
                    String username = Content[0];  //testing
                    String score = Content[1];
                    makeNewAccount(username, Integer.valueOf(score));
                }
            }
            Collections.sort(accounts, Comparator.comparing(Account::getScore).reversed());
            FileRead.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     *This is a getter function to the username in the arraylist
     * @param number is the position in the arraylist
     * @return the score in the arraylist account
     */
   public static long GetLabelScore(int number){
        Account account = accounts.get(number);
        return account.getScore();
    }

    /**
     * his is a getter function to the score in the arraylist
     * @param number is the position in the arraylist
     * @return the username in the arraylist account
     */
    public static String GetLabelName(int number){
        Account account = accounts.get(number);
        return account.getUserName();
    }

    /**
     * This is the function of to overwrite the score.txt in the descending order based on the score
     * @throws IOException when the score.txt unable to open
     */

    static void Rewrite() throws IOException {
        new FileWriter("src/main/java/com/example/demo/Database/Score.txt", false).close();
        accounts.sort(Comparator.comparing(Account::getScore).reversed());
        FileWriter fileWrite = new FileWriter("src/main/java/com/example/demo/Database/Score.txt", true);
        fileWrite.append("Username,").append("Score");
        for(Account account : accounts) {
            fileWrite.append("\n").append(account.getUserName()).append(",").append(String.valueOf(account.getScore()));
        }
        fileWrite.close();
    }

    /**
     * This is a getter function to get the score
     * @return the size of the arraylist account
     */
   public static int GetSize(){
        return accounts.size();
   }

}
