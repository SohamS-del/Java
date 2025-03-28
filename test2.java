import java.util.*;
import java.lang.*;

public class test2{
    public static void main(String[] args){
        BankAccount acc1 = new BankAccount(1010,6000);

        acc1.withdraw(7000);

    } 
}

class BankAccount{
    int accountNumber;
    long balance;

    BankAccount(int accountNumber,long balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(long amount){
        this.balance += amount;
        System.out.println("Balance - " + " " + this.balance);
    }
    public void withdraw(long amount){
        if(this.balance < amount){
            System.out.println("Insufficient Funds");
            System.out.println("Balance - " + " " + this.balance);
        }else{
            this.balance -= amount;
            System.out.println("Balance - " + " " + this.balance);
        }
    }
}