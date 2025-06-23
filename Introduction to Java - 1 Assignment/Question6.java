class Bank {
    protected String _name;
    protected String _headOfficeAddress;
    protected String _chairmanName;
    protected int _branchCount;
    protected double _fdInterestRate;
    protected double _personalLoanInterestRate;
    protected double _homeLoanInterestRate;

    public String getName() {
        return _name;
    }

    public String getHeadOfficeAddress() {
        return _headOfficeAddress;
    }

    public String getChairmanName() {
        return _chairmanName;
    }

    public int getBranchCount() {
        return _branchCount;
    }

    public double getFdInterestRate() {
        return _fdInterestRate;
    }

    public double getPersonalLoanInterestRate() {
        return _personalLoanInterestRate;
    }

    public double getHomeLoanInterestRate() {
        return _homeLoanInterestRate;
    }

    public Bank setName(String name) {
        _name = name;
        return this;
    }

    public Bank setHeadOfficeAddress(String headOfficeAddress) {
        _headOfficeAddress = headOfficeAddress;
        return this;
    }

    public Bank setChairmanName(String chairmanName) {
        _chairmanName = chairmanName;
        return this;
    }

    public Bank setBranchCount(int branchCount) {
        _branchCount = branchCount;
        return this;
    }

    public Bank setFdInterestRate(double fdInterestRate) {
        _fdInterestRate = fdInterestRate;
        return this;
    }

    public Bank setPersonalLoanInterestRate(double personalLoanInterestRate) {
        _personalLoanInterestRate = personalLoanInterestRate;
        return this;
    }

    public Bank setHomeLoanInterestRate(double homeLoanInterestRate) {
        _homeLoanInterestRate = homeLoanInterestRate;
        return this;
    }

    @Override
    public String toString() {
        return "Bank Details:\n" +
                "Name: " + getName() + "\n" +
                "Head Office Address: " + getHeadOfficeAddress() + "\n" +
                "Chairman: " + getChairmanName() + "\n" +
                "Branch Count: " + getBranchCount() + "\n" +
                "FD Interest Rate: " + getFdInterestRate() + "%\n" +
                "Personal Loan Interest Rate: " + getPersonalLoanInterestRate() + "%\n" +
                "Home Loan Interest Rate: " + getHomeLoanInterestRate() + "%";
    }
}

class SBI extends Bank {
    public SBI() {
        setName("SBI");
    }

    @Override
    public String toString() {
        return "=== SBI Bank ===\n" + super.toString();
    }
}

class BOI extends Bank {
    public BOI() {
        setName("BOI");
    }

    @Override
    public String toString() {
        return "=== BOI Bank ===\n" + super.toString();
    }
}

class ICICI extends Bank {
    public ICICI() {
        setName("ICICI");
    }

    @Override
    public String toString() {
        return "=== ICICI Bank ===\n" + super.toString();
    }
}

public class Question6 {
    public static void main(String[] args) {
        SBI sbi = (SBI) new SBI()
                .setHeadOfficeAddress("Mumbai, Maharashtra")
                .setChairmanName("Dinesh Kumar ")
                .setBranchCount(22000)
                .setFdInterestRate(5.5)
                .setPersonalLoanInterestRate(10.5)
                .setHomeLoanInterestRate(8.4);

        BOI boi = (BOI) new BOI()
                .setHeadOfficeAddress("Mumbai, Maharashtra")
                .setChairmanName("Atanu Kumar")
                .setBranchCount(5100)
                .setFdInterestRate(6.0)
                .setPersonalLoanInterestRate(11.2)
                .setHomeLoanInterestRate(8.75);

        ICICI icici = (ICICI) new ICICI()
                .setHeadOfficeAddress("Mumbai, Maharashtra")
                .setChairmanName("Sandeep Mishra")
                .setBranchCount(5400)
                .setFdInterestRate(6.5)
                .setPersonalLoanInterestRate(12.0)
                .setHomeLoanInterestRate(9.0);

        System.out.println(sbi);
        System.out.println();
        System.out.println(boi);
        System.out.println();
        System.out.println(icici);
    }
}
