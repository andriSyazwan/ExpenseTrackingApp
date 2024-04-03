# Expense Tracker

Expense Tracker is a full-stack web application built with Spring Boot for the backend, React.js for the frontend, and MySQL database for data storage. It allows users to manage expenses, accounts, and budgets for company objects. The main feature of this application is the integration of D3.js library to visualize expenses over time and track budget adherence.

## Features

- **Expense Management**: Add, edit, delete expenses with detailed information such as amount, category, date, and description.
- **Account Management**: Create and manage user accounts with authentication and authorization functionality.
- **Budget Tracking**: Set monthly budgets for different categories and track expenses against these budgets.
- **Visualization**: Utilizes D3.js library to generate interactive charts displaying expenses over time, with the ability to identify when expenses exceed the monthly budget.

## Technologies Used

- **Backend**: Spring Boot, Java
- **Frontend**: React.js, JavaScript, HTML, CSS
- **Database**: MySQL
- **Visualization**: D3.js

## Getting Started

### Prerequisites

- Java JDK
- Node.js
- MySQL
- IDE (Eclipse, IntelliJ IDEA, Visual Studio Code, etc.)

### Installation

1. Clone the repository:

```
git clone https://github.com/yourusername/expense-tracker.git
```

2. Navigate to the backend directory and run the Spring Boot application:

```
cd expense-tracker-backend
./mvnw spring-boot:run
```

3. Navigate to the frontend directory and install dependencies:

```
cd expense-tracker-frontend
npm install
```

4. Start the React development server:

```
npm start
```

5. Access the application at `http://localhost:3000` in your web browser.

## Usage

1. Sign up or log in to your account.
2. Add expenses by providing necessary details.
3. Monitor expenses and budget adherence through the visualization feature.
4. Edit or delete expenses as needed.
5. Log out when finished.

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1. Fork the repository
2. Create a new branch (`git checkout -b feature`)
3. Make your changes
4. Commit your changes (`git commit -m 'Add feature'`)
5. Push to the branch (`git push origin feature`)
6. Create a pull request

## Acknowledgments

- Thanks to [D3.js](https://d3js.org/) for providing powerful visualization capabilities.
- Special thanks to our contributors for their valuable contributions.
