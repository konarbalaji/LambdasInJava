package chp04;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionAndThenTest {
    public static void main(String[] args) {

        List<Customer> customer = new ArrayList<>();

        //Read Data
        List<String> customerDataCsv = getCustomerDataCSV();

        Function<String, Customer> nameEmailSeparator = (cd) -> getCustomer(cd);


        for(String custmoreDataFromCsv : customerDataCsv){
            customer.add(nameEmailSeparator.apply(custmoreDataFromCsv));
        }

        //Overrides toSTring()
        System.out.println("\n Create Customer Instance from CSV");
        System.out.println(customer);

        // Only First name in upper case & email sepearted by hyphen
        // [RAHUL - rahul@rahul.com, BOB - bob@bob.com, ALICE - alice@alice.com]

        Function<Customer, String> hyphenSep = (Customer c) -> c.getFirstName().toUpperCase() + "-" + c.getEmail();

        List<String> fnameEmailHyphenSep = new ArrayList<>();

        // Use andThen since nameEmailSeparator is already there.
        for(String custmoreDataFromCsv : customerDataCsv){
            fnameEmailHyphenSep.add(nameEmailSeparator.andThen(hyphenSep).apply(custmoreDataFromCsv));
        }

        System.out.println(" ========> Example of andThen");
        System.out.println(fnameEmailHyphenSep);
    }

    private static Customer getCustomer(String cd) {
        String[] custArr = cd.split(",");
        return new Customer(custArr[0], custArr[2], custArr[1], Integer.valueOf(custArr[3]));
    }


    public static List<String> getCustomerDataCSV() {
        List<String> customerData = new ArrayList<>();

        customerData.add("Rahul,rahul@rahul.com,Delta,30");
        customerData.add("Bob,bob@bob.com,Alpha,35");
        customerData.add("Alice,alice@alice.com,Gamma,35");
        return customerData;
    }
}