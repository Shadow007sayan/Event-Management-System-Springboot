function registerUser() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const firstName = document.getElementById('firstName').value;
    const lastName = document.getElementById('lastName').value;
    const age = document.getElementById('age').value;

    const user = {
        username: username,
        password: password,
        firstName: firstName,
        lastName: lastName,
        age: age
    };

    fetch('http://localhost:8080/user/user', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
    .then(response => {
        if (response.ok) {
            alert('User registered successfully!');
            // Redirect to login page or any other page
            window.location.href = 'login.html';
        } else {
            throw new Error('Registration failed');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Registration failed');
    });
}
