package dtu.application;
import dtu.infrastructure.interfaces.IAccountRepository;
import dtu.ws.fastmoney.*;

public class AccountService {
	
	BankService bank = new BankServiceService().getBankServicePort();

	private IAccountRepository customers;
	private IAccountRepository merchants;

	public AccountService(IAccountRepository customers, IAccountRepository merchants) {
		this.customers = customers;
		this.merchants = merchants;
	}

	public String createCustomer(String id) throws BankServiceException_Exception {
		return customers.create(bank.getAccount(id));
	}

	public String createMerchant(String id) throws BankServiceException_Exception {
		return merchants.create(bank.getAccount(id));
	}

	public Account getCustomer(String customerId) {
		return customers.getAccount(customerId);
	}

	public Account getMerchant(String merchantId) {
		return merchants.getAccount(merchantId);
	}

	public String getCustomerBankAccountId(String customerId) {
		Account customerAccount = customers.getAccount(customerId);
		if(customerAccount != null) return customerAccount.getId();
		else return null;
	}

	public String getMerchantBankAccountId(String merchantId) {
		Account merchantAccount = merchants.getAccount(merchantId);
		if(merchantAccount != null) return merchantAccount.getId();
		else return null;
	}

	public void deleteCustomer(String id) {
		customers.delete(id);
	}

	public void deleteMerchant(String id) {
		merchants.delete(id);
	}

	public boolean verifyCustomer(String id){
		return customers.verify(id);
	}

	public boolean verifyMerchant(String id){
		return merchants.verify(id);
	}

	public String getStatus() {
		return "Sanitity check for account service";
	}
}
