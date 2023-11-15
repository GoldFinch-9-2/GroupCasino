package com.github.zipcodewilmington.casino;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {
    Set<CasinoAccount> accounts;

    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount getAccount(String accountName, String accountPassword) {
        /*
        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String currentClassName = getClass().getName();
        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
        */

        for(CasinoAccount a : this.accounts){
            if(a.getUsername().equals(accountName) && a.getPassword().equals(accountPassword)){
                return a;
            }
        }

        System.out.println("This account doesn't exist!");
        return null;

    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount createAccount(String accountName, String accountPassword) {
        /*String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String currentClassName = getClass().getName();
        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));

         */
        return new CasinoAccount(accountName, accountPassword);

    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(CasinoAccount casinoAccount) {
        /*
        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String currentClassName = getClass().getName();
        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));

         */
        accounts.add(casinoAccount);
    }

    public void readFile(){
        try {
            String input;
            String[] elements;
            String username;
            String password;
            double balance;
            accounts = new HashSet<>();

            // reading file
            Scanner scanner = new Scanner(new File("accounts.txt"));

            while(scanner.hasNext()){
                // parsing file
                input = scanner.nextLine();
                elements = input.split(",");
                username = elements[0];
                password = elements[1];
                balance = Double.parseDouble(elements[2]);

                // creating account from file info
                CasinoAccount account = new CasinoAccount(username, password, balance);

                // saving account into account manager's accounts.
                accounts.add(account);

            }

        }
        catch(FileNotFoundException e){
            System.out.println("File not found!");
        }
    }

    public void saveToFile(){
        try {
            PrintWriter fileOut = new PrintWriter("accounts.txt");
            for(CasinoAccount a : accounts){
                fileOut.println(a.getUsername() + "," + a.getPassword() + "," + a.getBalance());
            }

            fileOut.close();

        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }

    }

    public boolean accountsIsEmpty(){
        return this.accounts.isEmpty();
    }

    public int accountsSize(){
        return this.accounts.size();
    }
}
