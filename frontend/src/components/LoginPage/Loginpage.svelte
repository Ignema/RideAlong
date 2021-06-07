<script>
    import './Loginpage.css'

    import { writable } from 'svelte/store';

    const user = writable({
        email: "",
        password: ""
    })
</script>

<div class="login-body">
    <form class="login-form" action="">
        <label>Email: </label>
        <input type="email" name="email" bind:value={$user.email}>
        
        <label>Password: </label>
        <input type="password" name="password" bind:value={$user.password}>
    
        <input type="submit">
    </form>
    
    <p>{JSON.stringify($user, 0, 2)}</p>
</div>