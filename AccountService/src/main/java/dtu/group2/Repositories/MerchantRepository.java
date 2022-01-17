package dtu.group2.Repositories;

import dtu.group2.Interfaces.IAccountRepository;
import dtu.ws.fastmoney.Account;
import dtu.ws.fastmoney.BankServiceException_Exception;

import java.util.HashMap;

public class MerchantRepository implements IAccountRepository {
    private static final HashMap<String, Account> merchants = new HashMap<>();

    @Override
    public Account get(String id) {
        return merchants.get(id);
    }

    @Override
    public void delete(String id) {
        merchants.remove(id);
    }

    @Override
    public void create(String id, Account account) throws BankServiceException_Exception {
        assert false;
        merchants.put(id, bank.getAccount(id));
    }

    @Override
    public Boolean verify(String id) {
        return merchants.get(id) != null;
    }
}