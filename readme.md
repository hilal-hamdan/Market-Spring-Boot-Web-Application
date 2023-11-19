Market

--- Market is a Spring Boot web application that facilitates various functionalities: ---

Contact Us: Users can use the "Contact Us" feature to send messages or inquiries.

User Registration: New users can register on the website by providing necessary information.

User Login: Registered users can log in to their accounts securely.

Bidding System: Users can participate in item auctions by placing bids.

Bid History: Displays the history of bids made by the user.

Profile Management: Users can update their profiles, including personal information.

Admin Features:
Read Messages:
Admins have access to messages or inquiries submitted through the "Contact Us" feature.
Sell Items:
Admins can list items for auction.


--- Download the Project: ---

Clone or download the project from the repository.
Configure Database:

Open application.properties and update the following properties:
spring.datasource.username: Your MySQL username.
spring.datasource.password: Your MySQL password.
Create Database Tables:

Open tables.txt and execute the provided queries in your MySQL database to create the necessary tables.
Insert Data into Tables:

Execute the data insertion queries (found in tables.txt) to populate the tables with initial data.
Run the Application:

Start the application, and it will be accessible at http://localhost:8085.
Login as Admin:

Use the following credentials to log in as an admin:
Username: admin@market.com
Password: 1234

--- Before you begin, ensure you have met the following requirements: ---

MySQL installed and running.
Java installed on your machine.
Spring Boot framework.
Basic knowledge of HTML and CSS.

--- Usage: ---

Contact Us

Navigate to the "Contact Us" section to send inquiries or messages.
Registration

If you are a new user, click on "Register" to create an account.
Login

Log in using your credentials to access personalized features.
Bid for an Item

Explore the available iPhone collection on the "Shop" page.
Place your bid on the desired iPhone model.
Display Bid History

View your bidding history by clicking on "Bids List."
Update Profile

Keep your profile information up-to-date. Click on "Profile" to make changes.
Admin Features

Admins can read messages and manage items for sale.
Selling Items

Admins can list items for sale. (Specify the steps for admins to perform this action)
How It Works

Explore our extensive iPhone collection.
Place your bid on the model you desire.
Compete with fellow shoppers to secure your iPhone.
Win the auction and own the iPhone generation you love.

--- Password Strength Enforcement ---

Passwords are required to meet specific criteria to enhance security.
Users must create passwords that are between 8 to 30 characters long.
Passwords must include at least one uppercase letter, one lowercase letter, one digit, and one special character.
Whitespace is not allowed.
Fields Matching

Certain forms and data entries are validated to ensure that specified fields match.
This feature is particularly useful for confirming password entries, email confirmation, etc.
For example, when creating or updating an account, the password and its confirmation must match.
User Existence Validation

During user registration, the system checks if a user with the provided email already exists.
This prevents the creation of duplicate accounts and enhances the overall user registration process.
Implementation Details

The password validation is powered by the Passay library, which provides a robust set of rules for validating password strength.
Fields matching is achieved through a custom validator that ensures specified fields in a form or data entry match.
Admin Access Control

Admin features are restricted to authorized users, preventing unauthorized access to sensitive functionalities.
Admins have the capability to read messages and manage the sale of items





