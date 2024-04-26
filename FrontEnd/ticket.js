function saveTicket() {
    const eventId = document.getElementById('eventId').value;
    const userId = document.getElementById('userId').value;

    fetch(`http://localhost:8080/ticket/event/${eventId}/user/${userId}`, {
        method: 'POST'
    })
    .then(response => {
        if (response.ok) {
            alert('Ticket saved successfully!');
            // Optionally, redirect to another page after saving the ticket
            window.location.href = 'http://127.0.0.1:5500/ticket.html';
        } else {
            throw new Error('Failed to save ticket');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Failed to save ticket');
    });
}
