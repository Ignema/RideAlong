<script>
    import './Signuppage.css'
    import { writable } from 'svelte/store';

    const user = writable({
        "name": "",
        "phone": "",
        "email": "",
        "birthday": "",
        "password": ""
    })

    async function signup() {
        console.log($user)
        fetch('http://localhost:8080/signup', {
            "method": 'POST',
            "headers": {
                "Content-Type": "application/json"
            },
            body: JSON.stringify($user)
        }).then(()=>window.location.href = '/')
    }
    
</script>

<div class="signup-body">
    <form class="signup-form" onsubmit="return false">
        <div class="signup-overlay"></div>
        <label for="name">Name: </label>
        <input type="text" name="name" id="name" bind:value={$user.name}>
        <label for="phone">Phone: </label>
        <input type="number" name="phone" id="phone" bind:value={$user.phone}>
        <label for="email">Email: </label>
        <input type="email" name="email" id="email" bind:value={$user.email}>
        <label for="birthday">Birthday: </label>
        <input type="date" name="birthday" id="birthday" bind:value={$user.birthday}>
        
        <label for="password">Password: </label>
        <input type="password" name="password" id="password" bind:value={$user.password}>
    
        <input type="submit" value="Sign Up" on:click={signup}>
        <p>Already have an account? <a href="/#/login">Login</a></p>
    </form>
</div>