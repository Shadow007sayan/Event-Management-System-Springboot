function addBudget() {
    const totalAmount = document.getElementById('totalAmount').value;
    const allocatedAmount = document.getElementById('allocatedAmount').value;
    const eventId = document.getElementById('eventId').value;

    const budget = {
        totalAmount: totalAmount,
        allocatedAmount: allocatedAmount
    };

    fetch(`http://localhost:8080/budget/add/${eventId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(budget)
    })
    .then(response => {
        if (response.ok) {
            alert('Budget added successfully!');
            // Redirect to any other page if needed
            window.location.href = 'http://127.0.0.1:5500/index.html';
        } else {
            throw new Error('Failed to add budget');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Failed to add budget');
    });
}

document.getElementById('budgetForm').addEventListener('submit', function(event) {
    event.preventDefault();
    addBudget();
});
