<script>
    import './Signuppage.css'
    import { writable } from 'svelte/store';

    const user = writable({
        name: "",
        phone: "",
        email: "",
        birthday: "",
        password: ""
    })
</script>

<div class="signup-body">
    <form class="signup-form" action="">
        <label>Name: </label>
        <input type="text" name="name" bind:value={$user.name}>
        <label>Phone: </label>
        <input type="number" name="phone" bind:value={$user.phone}>
        <label>Email: </label>
        <input type="email" name="email" bind:value={$user.email}>
        <label>Birthday: </label>
        <input type="date" name="birthday" bind:value={$user.birthday}>
        
        <label>Password: </label>
        <input type="password" name="password" bind:value={$user.password}>
    
        <input type="submit">
    </form>

    <p>{JSON.stringify($user, 0, 2)}</p>
</div>