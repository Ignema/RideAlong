<script>
    import './Loginpage.css'
    import { writable } from 'svelte/store';
    import { token, userId } from '../../store.js';

    const user = writable({
        "email": "",
        "password": ""
    })

    async function login() {
        fetch('http://localhost:8080/login', {
            "method": 'POST',
            "headers": {
                "Content-Type": "application/json"
            },
            body: JSON.stringify($user)
        })
        .then(res => res.text())
        .then(payload => JSON.parse(payload))
        .then(payload => {
            localStorage.setItem("token", payload.jwt)
            localStorage.setItem("userId", payload.userId)
            token.set(payload.jwt)
            userId.set(payload.userId)
            console.log(payload)
            window.location.href = '/#/app';
        })
        .catch(err => console.log(err))
        
    }
</script>

<div class="login-body">
    <form class="login-form" onsubmit="return false">
        <div class="login-overlay"></div>
        <label for="email">Email: </label>
        <input type="email" name="email" id="email" bind:value={$user.email}>
        
        <label for="password">Password: </label>
        <input type="password" name="password" id="password" bind:value={$user.password}>
    
        <input type="submit" value="Login" on:click={login}>
        <p>Don't have an account? <a href="/#/signup">Sign Up</a></p>
    </form>    
</div>