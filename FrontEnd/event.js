document.addEventListener('DOMContentLoaded', function () {
    const eventForm = document.getElementById('eventForm');
    const eventTable = document.getElementById('eventTable');
    const updateEventForm = document.getElementById('updateEventForm');
    const deleteEventForm = document.getElementById('deleteEventForm');
    const findEventForm = document.getElementById('findEventForm');
    const foundEventInfo = document.getElementById('foundEventInfo');

    // Event listener for form submission to add event
    eventForm.addEventListener('submit', function (e) {
        e.preventDefault();
        const formData = new FormData(eventForm);
        const event = {
            eventName: formData.get('eventName'),
            locationOfEvent: formData.get('locationOfEvent'),
            eventDate: formData.get('eventDate'),
            startTime: formData.get('startTime'),
            endTime: formData.get('endTime')
        };

        // Post event data to the API to add a new event
        fetch('http://localhost:8080/event/event', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(event)
        })
        .then(response => response.json())
        .then(data => {
            console.log('Event added:', data);
            // Clear the form after successful submission
            eventForm.reset();
            // Refresh event table
            getAllEvents();
        })
        .catch(error => console.error('Error:', error));
    });

    // Function to get all events and display in the table
    function getAllEvents() {
        fetch('http://localhost:8080/event/events')
            .then(response => response.json())
            .then(data => {
                displayEvents(data);
            })
            .catch(error => console.error('Error:', error));
    }

    // Function to display events in the table
    function displayEvents(events) {
        eventTable.innerHTML = `
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Location</th>
                <th>Date</th>
                <th>Start Time</th>
                <th>End Time</th>
            </tr>
        `;
        events.forEach(event => {
            const row = eventTable.insertRow();
            row.innerHTML = `
                <td>${event.eventId}</td>
                <td>${event.eventName}</td>
                <td>${event.locationOfEvent}</td>
                <td>${event.eventDate}</td>
                <td>${event.startTime}</td>
                <td>${event.endTime}</td>
            `;
        });
    }

    // Function to update an event
    function updateEvent() {
        const formData = new FormData(updateEventForm);
        const eventId = formData.get('eventId');
        const newLocation = formData.get('locationOfEvent');

        // Call API to update event by ID
        fetch(`http://localhost:8080/event/event/id/${eventId}/location/${newLocation}`, {
            method: 'PUT'
        })
        .then(response => response.text())
        .then(data => {
            console.log('Event updated:', data);
            // Clear the form after successful update
            updateEventForm.reset();
            // Refresh event table
            getAllEvents();
        })
        .catch(error => console.error('Error:', error));
    }

    // Function to delete an event
    function deleteEvent() {
        const formData = new FormData(deleteEventForm);
        const eventId = formData.get('eventId');

        // Confirm deletion with user
        if (confirm("Are you sure you want to delete this event?")) {
            // Call API to delete event by ID
            fetch(`http://localhost:8080/event/event/${eventId}`, {
                method: 'DELETE'
            })
            .then(response => response.text())
            .then(data => {
                console.log('Event deleted:', data);
                // Refresh event table after deletion
                getAllEvents();
            })
            .catch(error => console.error('Error:', error));
        }
    }

    document.getElementById('updateEventBtn').addEventListener('click', updateEvent);
    document.getElementById('deleteEventBtn').addEventListener('click', deleteEvent);

    // Initial call to fetch and display events
    getAllEvents();
});
