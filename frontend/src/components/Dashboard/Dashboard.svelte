<script>
    import './Dashboard.css'
    import MeetupCard from './MeetupCard/MeetupCard.svelte'
    import BikeRentCard from './BikeRentCard/BikeRentCard.svelte'

    const dashboardOptions = ["My Meetups 🔥", "Rented Bicycles 🚴"]
    const dashboardAddText = ["Schedule a Meetup ⭐", "Rent your Bicycle 💖"]
    let currentDashboardOption = 0;

	let meetups = []
	let bicycles = []
	
	async function getAllMeetups() {
		const res = await fetch('http://localhost:8080/meetup', {
			"method": 'GET',
            "headers": {
                "Authorization": "Basic " + btoa("user:1800c92a-e30f-4d8f-9326-7b252407803f")
            }
		})
		meetups = await res.json()
		console.log(meetups)
	}

    async function getAllBicycles() {
		const res = await fetch('http://localhost:8080/bicycle', {
			"method": 'GET',
            "headers": {
                "Authorization": "Basic " + btoa("user:1800c92a-e30f-4d8f-9326-7b252407803f")
            }
		})
		bicycles = await res.json()
		console.log(bicycles)
	}
</script>

<main class="dashboard-main">
    <div class="dashboard-options-container">
        <h1 class="header-h1 dashboard-h1">Dashboard</h1>
        <hr class="dashboard-hr">
        <ul class="dashboard-options">
            <li on:click={() => {
                    currentDashboardOption = 0
                    getAllMeetups()
                }
            } class="dashboard-li-active">{dashboardOptions[0]}</li>
            <li on:click={() => {
                    currentDashboardOption = 1
                    getAllBicycles()
                }
                }>{dashboardOptions[1]}</li>
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
                {#each meetups as meetup}
                    <MeetupCard meetup={meetup} />
                {/each}
            {:else if currentDashboardOption == 1}
                {#each bicycles as bicycle}
                    <BikeRentCard bicycle={bicycle}/>
                {/each}
            {/if}
        </ul>
    </section>
</main>