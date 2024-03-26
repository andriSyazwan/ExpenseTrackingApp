import '../Styles/DetailedExpenseCard.css'

const DetailedExpenseCardForCompanyPage = (props) => {
    console.log(props);
    console.log("The above is props");



const renderFrom = () => {
    return (
        <span>
            <span className='label'>Label1</span><br/>
        </span>
    )
}

const renderTo = () => {
    return (
        <span>
            <span className="label">EnterVariableHere</span><br/>
        </span>
    )
}

const renderType = () => {

}

return (
    <div>
        <div className="heading">
            {renderFrom()}
        </div>
        <div className="heading">
            {renderTo()}
        </div>
        <div className="heading">
            {renderType()}
        </div>

    </div>
)

}

export default DetailedExpenseCardForCompanyPage;