<script>
    import './Dashboard.css'
    import MeetupCard from './MeetupCard/MeetupCard.svelte'
    import BikeRentCard from './BikeRentCard/BikeRentCard.svelte'

    const dashboardOptions = ["My Meetups 🔥", "Rented Bicycles 🚴"]
    const dashboardAddText = ["Schedule a Meetup ⭐", "Rent a Bicycle 💸"]
    let currentDashboardOption = 1;
</script>

<main class="dashboard-main">
    <div class="dashboard-options-container">
        <h1 class="header-h1 dashboard-h1">Dashboard</h1>
        <hr class="dashboard-hr">
        <ul class="dashboard-options">
            <li on:click={() => currentDashboardOption = 0} class="dashboard-li-active">{dashboardOptions[0]}</li>
            <li on:click={() => currentDashboardOption = 1}>{dashboardOptions[1]}</li>
        </ul>
        <h3 class="dashboard-h3">RideAlong &copy; 2021</h3>
    </div>
    <section class="dashboard-view">
        <div class="dashboard-view-header">
            <div class="dashboard-view-header-title">{dashboardOptions[currentDashboardOption]}</div>
            <div class="dashboard-view-header-add">
                {dashboardAddText[currentDashboardOption]}
            </div>
        </div>
        <ul class="dashboard-cards">
            {#if currentDashboardOption == 0}
            <MeetupCard />
            {:else if currentDashboardOption == 1}
            <BikeRentCard />
            {/if}
        </ul>
    </section>
</main>