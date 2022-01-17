package dtu.group2.Repositories;

import dtu.group2.Interfaces.IAccountRepository;
import dtu.ws.fastmoney.Account;
import dtu.ws.fastmoney.BankService;
import dtu.ws.fastmoney.BankServiceService;

import java.util.HashMap;

public class CustomerRepository implements IAccountRepository {

    private static final HashMap<String, Account> customersAccounts = new HashMap<>();
    private static final HashMap<String, String> customersIds = new HashMap<>();
    BankService bank = new BankServiceService().getBankServicePort();

    @Override
    public Account getAccount(String id) {
        return customersAccounts.get(id);
    }

    @Override
    public String getAccountId(String id) {
        return customersIds.get(id);
    }

    @Override
    public void delete(String id) {
        customersAccounts.remove(id);
    }

    @Override
    public void create(String accountId, String customerId, Account account) {
        customersAccounts.put(accountId, account);
        customersIds.put(customerId, accountId);
    }

    @Override
    public Boolean verify(String id) {
        return customersAccounts.get(id) != null;
    }
}
