function loginUser() {
    const userId = document.getElementById('userId').value;
    const password = document.getElementById('password').value;

    const user = {
        userId: userId,
        password: password
    };

    fetch(`http://localhost:8080/user/user/${user.userId}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (response.ok) {
            return response.json(); // Parse response JSON
        } else {
            throw new Error('Login failed');
        }
    })
    .then(userData => {
        // Check if the entered password matches the password returned from the API
        if (userData.password === password) {
            alert('Login successful!');
            // Redirect to index.html or any other page
            window.location.href = 'http://127.0.0.1:5500/index.html';
        } else {
            throw new Error('Login failed');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Login failed');
    });
}
