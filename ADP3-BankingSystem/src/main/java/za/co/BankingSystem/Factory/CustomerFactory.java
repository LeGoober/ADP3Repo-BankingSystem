
package za.co.BankingSystem.Factory;

public class CustomerFactory {
    

// Naqeebah Khan 219099073

package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Account;
import za.co.BankingSystem.Domain.Customer;
import za.co.BankingSystem.Util.Helper;

import java.util.ArrayList;
import java.util.List;

public class CustomerFactory {

    public static Customer createCustomer(String customerName, String customerSurname,
                                          String customerAddress, String customerEmail, String phoneNumber,
                                          List<Account> accounts) {
        if (Helper.isNullOrEmpty(customerName) || Helper.isNullOrEmpty(customerSurname) || Helper.isNullOrEmpty(customerAddress)) {
            throw new IllegalArgumentException("Customer name, surname, or address cannot be empty");
        }

        if (!Helper.isValidEmail(customerEmail)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (!Helper.isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        String customerID = Helper.generateID();

        return new Customer.Builder()
                .setCustomerID(customerID)
                .setCustomerName(customerName)
                .setCustomerSurname(customerSurname)
                .setCustomerAddress(customerAddress)
                .setCustomerEmail(customerEmail)
                .setPhoneNumber(phoneNumber)
                .setAccounts(accounts != null ? accounts : new ArrayList<>())
                .build();
    }

}
