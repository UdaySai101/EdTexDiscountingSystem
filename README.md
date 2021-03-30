# EdTexDiscountingSystem
A discounting system for EdTex customers.


# How it Works
- Start with src/Test.java as the main Class to check the input and final output. It asks for a customer name, price of products x and y and then calls src/EdTexCustomer to check the type of Membership of that customer.
- src/EdTexCustomer then checks if a customer has membership and asks to register (calls src/CustomerVisit) if not. And ultimately, it returns a string containing type of Membership.
- src/CustomerVisit is where the registration of new users happen. It also passes new customer registration costs (Platinum - Rs. 500 or Diamond - Rs. 350) to scr/Test.java.
- src/Discount calcultes the total discount a customer can get based on his/her's existing/non-existing membership. Return values varies depending on plan (Platinum - 14%, Diamond - 7%) added to the overall flat discount of 14%.
- src/Test.java after going through all those classes will then calculates the total price and prints out to the console.
