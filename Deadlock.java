public class Deadlock {
    public static void main(String[] args) throws InterruptedException {

        Account a1 = new Account("A12", 1_00_000);
        Account a2 = new Account("A13", 2_00_000);

        Thread t1 = new Thread(()->{
            for(int i=0; i<100;i++){
                transfer(a1, a2, 100);
            }
        });
        Thread t2 = new Thread(()->{
            for(int i=0; i<100;i++){
                transfer(a2, a1, 100);
            }
        });

        t1.start();t2.start();
        t1.join();t2.join();
    }

    private static void transfer(Account from, Account to, Integer amt){
        synchronized (from.getLock()){
            synchronized ((to.getLock())){
                System.out.println("From: "+ from.getAmount() + "\nTo: " + to.getAmount());
                to.setAmount(to.getAmount()+amt);
                from.setAmount(from.getAmount()-amt);
                System.out.println("From: "+ from.getAmount() + "\nTo: " + to.getAmount());
            }
        }
    }
}

class Account {
    private String acNumber;
    private Integer amount;
    private Object lock;

    public Account(String acNumber, Integer amount) {
        this.acNumber = acNumber;
        this.amount = amount;
        this.lock = new Object();
    }

    public Integer getAmount() {
        return amount;
    }

    public String getAcNumber() {
        return acNumber;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Object getLock() {
        return lock;
    }

    public void setLock(Object lock) {
        this.lock = lock;
    }

    public void setAcNumber(String acNumber) {
        this.acNumber = acNumber;
    }
}