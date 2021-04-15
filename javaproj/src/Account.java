import java.util.ArrayList;
public class Account {

    public static void main(String[] args) {
        Transactions transactions=Transactions.getInstance();
        new Thread(new Father(new AddTransaction("Deposit",800))).start();
        new Thread(new Mother(new AddTransaction("Withdraw", 550))).start();
        new Thread(new Father(new AddTransaction("Deposit",1200))).start();
        new Thread(new Son()).start();
    }
}
class AddTransaction{
    public String type;
    public double amount;
    public AddTransaction(String type, double amount){
        this.amount=amount;
        this.type=type;
    }
    public String getType(){
        return type;
    }
    public double getAmount(){
        return amount;
    }
}
class Transactions{
    private AddTransaction entry;
    private static ArrayList<AddTransaction> entries=null;
    static Transactions transactions;
    private Transactions(){
        entries=new ArrayList<>();
    }
    public static Transactions getInstance(){
        if(entries==null){
            transactions = new Transactions();
        }
        return transactions;
    }
    public synchronized double add(AddTransaction entry){
        System.out.println(entry.getAmount()+" is "+entry.getType()+"ing...");
        entries.add(entry);
        return entry.getAmount();
    }
    public synchronized double displayBalance(){
        double bal=0;
        for(int i=0;i<entries.size();i++){
        	AddTransaction entry=entries.get(i);
            if(entry.getType().equals("Withdraw")){
                bal-=entry.getAmount();
            }else{
                bal+=entry.getAmount();
            }
        }
        return bal;
    }
}
class Father implements Runnable{// adds
	AddTransaction entry;
    Transactions transactions=Transactions.getInstance();
    Father(AddTransaction initialEntry){
        this.entry=initialEntry;
    }
    public void run(){
        transactions.add(entry);
    }
}
class Son implements Runnable{ // display
    Transactions transactions=Transactions.getInstance();
    Son(){
        //
    }
    public void run(){
        System.out.println("Current balance is : "+transactions.displayBalance());
    }
}
class Mother implements Runnable{
	AddTransaction entry;
    Transactions transactions=Transactions.getInstance();
    Mother(AddTransaction initialEntry){
        this.entry=initialEntry;
    }
    public void run(){
        transactions.add(entry);
    }
}


