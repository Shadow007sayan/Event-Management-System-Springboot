function addSponsor() {
    const eventId = document.getElementById('eventId').value;
    const sponsorName = document.getElementById('sponsorName').value;
    const sponsoredAmount = document.getElementById('sponsoredAmount').value;

    const sponsor = {
        sponsorName: sponsorName,
        sponsoredAmount: sponsoredAmount
    };

    fetch(`http://localhost:8080/sponsors/add/${eventId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(sponsor)
    })
    .then(response => {
        if (response.ok) {
            alert('Sponsor added successfully!');
            // Optionally, redirect to another page after adding the sponsor
            window.location.href = 'http://127.0.0.1:5500/sponsors.html';
        } else {
            throw new Error('Failed to add sponsor');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Failed to add sponsor');
    });
}
