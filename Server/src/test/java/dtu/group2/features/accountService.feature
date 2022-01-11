Feature: Account

# Create
	Scenario: Successfully create a bank account
		Given a user with first name "Johnson", last name "McJohnson" and cpr number "666999-6969"
		And the user have a balance of "420"
		When the bank creates an account with an accountID
		Then an account exists with that accountID
		
	Scenario: Create an account for an empty user
		Given a user with no first name, last name or cpr number
		And the user have a balance of "0"
		When the bank creates an account with an accountID
		Then A "Missing CPR number" exception is raised

	Scenario: Create an account with invalid balance
		Given a user with first name "Johnson", last name "McJohnson" and cpr number "666999-6969"
		And the user have a balance of "HejMedDig"
		When the bank creates an account with an accountID
		Then A "Character H is neither a decimal digit number, decimal point, nor \"e\" notation exponential mark." exception is raised
		
# Delete
	Scenario: Successfully delete an account
		Given a user with first name "Johnson", last name "McJohnson" and cpr number "666999-6969"
		And the user have a balance of "420"
		When the bank creates an account with an accountID
		And the account is deleted
		And the account is fetched
		Then A "Account does not exist" exception is raised

	Scenario: Delete account that does not exist
		Given account ID "abc"
		When the account is deleted
		Then A "Account does not exist" exception is raised
		

# Update
#	Scenario: Successfully update an account id
#		Given an account with accountID "abc" exists in the database
#		When the account is updated with id "cba"
#		Then an account exists with that accountID
#		And the account with accountID "abc" does not exist
#		
#	Scenario: Successfully update an account id of non existing account
#		Given an account with accountID "abc" does not exist
#		When the account is updated with id "cba"
## Unknown result
#		Then the exception "Account with accountID abc does not exist" is received
#

