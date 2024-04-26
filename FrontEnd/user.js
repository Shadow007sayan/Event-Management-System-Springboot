document.addEventListener('DOMContentLoaded', function () {
    const userTable = document.getElementById('userTable');

    // Function to get all users and display in the table
    function getAllUsers() {
        fetch('http://localhost:8080/student/students')
            .then(response => response.json())
            .then(data => {
                displayUsers(data);
            })
            .catch(error => console.error('Error:', error));
    }

    // Function to display users in the table
    function displayUsers(users) {
        userTable.innerHTML = `
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
            </tr>
        `;
        users.forEach(user => {
            const row = userTable.insertRow();
            row.innerHTML = `
                <td>${user.userId}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.age}</td>
            `;
        });
    }

    // Initial call to fetch and display users
    getAllUsers();
});
