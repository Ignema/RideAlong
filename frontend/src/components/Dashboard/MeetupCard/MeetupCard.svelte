<script>
    import './MeetupCard.css'

    export let meetup = {
        "id": "N/A",
        "date": "N/A",
        "location": "N/A",
        "completed": "N/A",
        "gallery": "N/A",
        "owner": "N/A",
        "participants": [],
        "messages": []
    }

    function calculateAge(birthday) { 
        const ageDifMs = Date.now() - new Date(birthday).getTime();
        const ageDate = new Date(ageDifMs);
        return Math.abs(ageDate.getUTCFullYear() - 1970);
    }
</script>

<li class="dashboard-card">
    <h1 style="font-family: 'Dancing Script'; font-size: 2rem;">Meetup code: {meetup.id}</h1>
    <div class="dashboard-card-info">
        <p class="dashboard-card-gallery">🔗</p>
        <p class="dashboard-card-chat">💭</p>
        <p class="dashboard-card-completed">❓</p>
        <p class="dashboard-card-location">🪧</p>
        <p class="dashboard-card-date">📅</p>
    </div>
    <ul class="dashboard-card-participants">
        <li class="dashboard-card-participant-heading">
            <p>Name</p>
            <p>Phone</p>
            <p>Age</p>
        </li> 
        {#each meetup.participants as particpant}
            <li class="dashboard-card-participant">
                <p>{particpant.name}</p>
                <p>{particpant.phone}</p>
                <p>{calculateAge(particpant.birthday)}</p>
            </li>
        {/each}
    </ul>
</li>