import "../Styles/CompanyPage.css";
import { useState, useEffect, useRef } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';
import * as d3 from 'd3';

// Page that mainly displays the lsit of expenses
const CompanyPage = () => {
    // Initializing of all necessary variables
    const navigate = useNavigate();
    const { user_id } = useParams();
    const [company, setCompany] = useState({});
    const [user, setUser] = useState(null);
    const [expenses, setExpenses] = useState([]);
    const [isDataLoaded, setIsDataLoaded] = useState(false);
    const [companyId, setCompanyId] = useState();
    const [errorMessage, setErrorMessage] = useState();
    const api = 'http://localhost:9002/api/';
    const svgRef = useRef();

    // Fetching of API in sequence
    useEffect(() => {
        const fetchData = async () => {
            try {
                if (user_id) {
                    const userDataResponse = await axios.get(api + 'users/' + user_id);
                    setUser(userDataResponse.data);
                    setCompanyId(userDataResponse.data.company.company_id);
    
                    if (userDataResponse.data.company.company_id) {
                        const companyDataResponse = await axios.get(api + 'companies/' + userDataResponse.data.company.company_id);
                        setCompany(companyDataResponse.data);
    
                        const expenseDataResponse = await axios.get(api + 'expense/company/' + companyDataResponse.data.name);
                        setExpenses(formatExpenses(expenseDataResponse.data));
                        setIsDataLoaded(true);
                    }
                }
            } catch (error) {
                setErrorMessage("Failed to fetch data");
            }
        };
    
        fetchData();
    }, [user_id]);

    // To parse the expense into correct objects
    function formatExpenses(expenses) {
        return expenses.map(expense => ({
            expense_id: expense.expense_id,
            amount: expense.amount,
            status: expense.status,
            date: expense.date,
            description: expense.description,
            category: expense.category.name, // Assuming category is an object with a 'name' property
        }));
    };

    // Function to display expenses
    function displayExpenses(expenses) {
        return (
            <div>
                {expenses.map(expense => (
                    <div key={expense.expense_id} className="expense-card">
                        <p>Amount: ${expense.amount}</p>
                        <p>Status: {expense.status ? 'Approved' : 'Pending'}</p>
                        <p>Date: {expense.date}</p>
                        <p>Description: {expense.description || 'N/A'}</p>
                        <p>Category: {expense.category || 'N/A'}</p>
                    </div>
                ))}
            </div>
        );
    }


// Function for the chart
useEffect(() => {
    // The bar chart script

    // Parse dates and extract month
    expenses.forEach(expense => {
        expense.date = new Date(expense.date);
        expense.month = expense.date.getMonth(); // Use 0-indexed month
    });

    // Month names array
    const monthNames = [
        "Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    ];

    // Calculate sum of expenses for each month
    const expensesByMonth = d3.rollup(
        expenses,
        v => d3.sum(v, d => d.amount),
        d => d.month
    );

    // Convert rollup result to array of objects
    const data = Array.from(expensesByMonth, ([month, total]) => ({ month: monthNames[month], total }));

    // Set up SVG dimensions
    const margin = { top: 20, right: 30, bottom: 30, left: 40 };
    const width = 600 - margin.left - margin.right;
    const height = 400 - margin.top - margin.bottom;

    // Create SVG container
    const svg = d3.select(svgRef.current)
        .attr("width", width + margin.left + margin.right)
        .attr("height", height + margin.top + margin.bottom)
        .append("g")
        .attr("transform", `translate(${margin.left},${margin.top})`);

    // Create scales
    const x = d3.scaleBand()
        .domain(data.map(d => d.month))
        .range([0, width])
        .padding(0.1);

    const y = d3.scaleLinear()
        .domain([0, d3.max(data, d => d.total)])
        .nice()
        .range([height, 0]);

    // Define bar color
    const color = d3.scaleOrdinal(d3.schemeCategory10);

    // Add bars to the chart
    svg.selectAll(".bar")
        .data(data)
        .join("rect")
        .attr("class", "bar")
        .attr("x", d => x(d.month))
        .attr("y", d => y(d.total))
        .attr("width", x.bandwidth())
        .attr("height", d => height - y(d.total));
        

    // Add x-axis
    svg.append("g")
        .attr("class", "x-axis")
        .attr("transform", `translate(0,${height})`)
        .call(d3.axisBottom(x));

    // Add y-axis
    svg.append("g")
        .attr("class", "y-axis")
        .call(d3.axisLeft(y).ticks(null, "s"));

    // Add chart title
    svg.append("text")
        .attr("x", width / 2)
        .attr("y", -margin.top / 2)
        .attr("text-anchor", "middle")
        .text("Total Expenses by Month");

    // Add labels to bars
    svg.selectAll(".bar-label")
        .data(data)
        .join("text")
        .attr("class", "bar-label")
        .attr("x", d => x(d.month) + x.bandwidth() / 2)
        .attr("y", d => y(d.total) - 5)
        .attr("text-anchor", "middle")
        .text(d => (d.month));

}, [expenses]);

    // Returns loading screen up until all data is fetched 
    if(!isDataLoaded) {
        return(
            <div class="loadScreen">
                Loading...
            </div>
        );
    }
    
    // Once all data us fetched, then all the required variables become available to show the main screen
    return(
        <div>
            <div className="company-info">
                <h2>{company.name}</h2>
                <p>Budget: ${company.budget}</p>
            </div>

            <div id="chart-container">
                <svg ref={svgRef}></svg>
            </div>

            <div className="expense-list">
                <div className="fixed-container">
                    <div className="CompanyTitle">
                        <h3>Expense List</h3>
                    </div>
                    <div className="ExpenseComponent">
                        {displayExpenses(expenses)}
                    </div>
                </div>
                <div className="BottomButton">
                    <button onClick={() => navigate('/userpage/'+user_id)}>User Page</button>
                </div>
            </div>
                
        </div>
    );
}

export default CompanyPage;