<script>
    import './Dashboard.css'
    import MeetupCard from './MeetupCard/MeetupCard.svelte'
    import BikeRentCard from './BikeRentCard/BikeRentCard.svelte'
    import Modal from './Modal/Util/Modal.svelte'
    import Schedule from './Modal/Schedule.svelte'
    import Rent from './Modal/Rent.svelte'
    import { writable } from 'svelte/store';
    import { token, userId } from '../../store.js';

    const modal = writable(null);

    const dashboardOptions = ["Discover Meetups ✨", "Organized Meetups ⚒️", "My Meetups 🔥", "Bicycle Shop 🛒", "Owned Bicycles 🏡", "Rented Bicycles 🚴"]
    const dashboardAddText = ["Schedule a Meetup ⭐", "Schedule a Meetup ⭐", "Schedule a Meetup ⭐", "Rent your Bicycle 💖", "Rent your Bicycle 💖", "Rent your Bicycle 💖"]
    let currentDashboardOption = 0;

	let all_meetups = []
	let organized_meetups = []
	let user_meetups = []
	let all_bicycles = []
    let owned_bicycles = []
	let rented_bicycles = []

	
	async function getAllMeetups() {
		const res = await fetch('http://localhost:8080/meetup', {
			"method": 'GET',
            "headers": {
                "Authorization": "Bearer " + $token
            }
		})
		all_meetups = await res.json()
		console.log("All meetups: ", all_meetups)
	}

    async function getOrganizedMeetups(id) {
		const res = await fetch('http://localhost:8080/meetup/organizer/'+id, {
			"method": 'GET',
            "headers": {
                "Authorization": "Bearer " + $token
            }
		})
		organized_meetups = await res.json()
		console.log("Organized meetups: ", organized_meetups)
	}

    async function getUserMeetups(id) {
		const res = await fetch('http://localhost:8080/meetup/user/'+id, {
			"method": 'GET',
            "headers": {
                "Authorization": "Bearer " + $token
            }
		})
		user_meetups = await res.json()
		console.log("User meetups: ", user_meetups)
	}

    async function getAllBicycles() {
		const res = await fetch('http://localhost:8080/bicycle', {
			"method": 'GET',
            "headers": {
                "Authorization": "Bearer " + $token
            }
		})
		all_bicycles = await res.json()
		console.log("All bicycles: ", all_bicycles)
	}

    async function getOwnedBicycles(id) {
		fetch('http://localhost:8080/bicycle/owner/'+id, {
			"method": 'GET',
            "headers": {
                "Authorization": "Bearer " + $token
            }
		}).then(async (res)=>{
    		owned_bicycles = await res.json()
            console.log("Owned bicycles: ", owned_bicycles)
        }).catch(err => {
            owned_bicycles = []
            console.log("JSON: ", err)
        })
	}

    async function getRentedBicycles(id) {
		fetch('http://localhost:8080/bicycle/user/'+id, {
			"method": 'GET',
            "headers": {
                "Authorization": "Bearer " + $token
            }
		}).then(async (res)=>{
    		rented_bicycles = await res.json()
		    console.log("Rented bicycles: ", rented_bicycles)
        }).catch(err => {
            rented_bicycles = []
            console.log("JSON: ", err)
        })
		
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
            }>{dashboardOptions[0]}</li>
            <li on:click={() => {
                    currentDashboardOption = 1
                    getOrganizedMeetups($userId)
                }
            }>{dashboardOptions[1]}</li>
            <li on:click={() => {
                    currentDashboardOption = 2
                    getUserMeetups($userId)
                }
            }>{dashboardOptions[2]}</li>
            <li on:click={() => {
                    currentDashboardOption = 3
                    getAllBicycles()
                }
            }>{dashboardOptions[3]}</li>
             <li on:click={() => {
                    currentDashboardOption = 4
                    getOwnedBicycles($userId)
                }
            }>{dashboardOptions[4]}</li>
            <li on:click={() => {
                    currentDashboardOption = 5
                    getRentedBicycles($userId)
                }
            }>{dashboardOptions[5]}</li>
        </ul>
        <h3 class="dashboard-h3">RideAlong &copy; 2021</h3>
    </div>
    <section class="dashboard-view">
        <div class="dashboard-view-header">
            <div class="dashboard-view-header-title">{dashboardOptions[currentDashboardOption]}</div>
            <div class="dashboard-view-header-add">
                <Modal show={$modal}>
                    {#if currentDashboardOption >= 0 && currentDashboardOption < 3}
                        <Schedule info="Give me more information 🤔" icon={dashboardAddText[currentDashboardOption]}/>
                    {:else if currentDashboardOption >= 3 && currentDashboardOption < 6}
                        <Rent info="Give me more information 🤔" icon={dashboardAddText[currentDashboardOption]}/>
                    {/if}
                </Modal>
            </div>
        </div>
        <ul class="dashboard-cards">
            {#if currentDashboardOption == 0}
                {#each all_meetups as meetup}
                    <MeetupCard meetup={meetup} />
                {/each}
            {:else if currentDashboardOption == 1}
                {#each organized_meetups as meetup}
                    <MeetupCard meetup={meetup} />
                {/each}
            {:else if currentDashboardOption == 2}
                {#each user_meetups as meetup}
                    <MeetupCard meetup={meetup} />
                {/each}
            {:else if currentDashboardOption == 3}
                {#each all_bicycles as bicycle}
                    <BikeRentCard bicycle={bicycle} />
                {/each}
            {:else if currentDashboardOption == 4}
                {#each owned_bicycles as bicycle}
                    <BikeRentCard bicycle={bicycle} />
                {/each}
            {:else if currentDashboardOption == 5}
                {#each rented_bicycles as bicycle}
                    <BikeRentCard bicycle={bicycle} />
                {/each}
            {/if}
        </ul>
    </section>
</main>