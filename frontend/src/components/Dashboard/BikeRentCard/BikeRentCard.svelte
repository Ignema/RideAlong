<script>
    import './BikeRentCard.css'
    import Modal from '../Modal/Util/Modal.svelte';
    import Info from '../Modal/Info.svelte';
    import { onMount } from 'svelte';
	import { writable } from 'svelte/store';
    import { token, userId } from '../../../store.js';

    const modal = writable(null);

    let isUserOwnerOrRenter = false;

    async function testifUserIsOwnerOrRenter(bicycle_id, user_id) {
		const res = await fetch('http://localhost:8080/bicycle/'+bicycle_id+'/user/'+user_id, {
			"method": 'GET',
            "headers": {
                "Authorization": "Bearer " + $token
            }
		})
		isUserOwnerOrRenter = await res.json()
        console.log("user ", user_id, " + bicycle ", bicycle_id, ":", isUserOwnerOrRenter)
	}

    export let bicycle = {
        "id": "N/A",
        "model": "N/A",
        "image": "N/A",
        "price": "N/A",
        "duration": "N/A",
        "available": "N/A",
        "participant": "N/A",
        "owner": "N/A"
    }

    let styles = {
		'bg-img': `url(${bicycle.image})`,
	};

    $: cssVarStyles = Object.entries(styles)
		.map(([key, value]) => `--${key}:${value}`)
		.join(';');

    onMount(() => {
		testifUserIsOwnerOrRenter(bicycle.id, $userId)
	})
</script>

<li class="dashboard-card dashboard-bike-card" style="{cssVarStyles}">
    <div class="dashboard-bike-overlay">
    </div>
    <h1 style="font-family: 'Dancing Script'; font-size: 2rem;">Bike Model: {bicycle.model}</h1>
    <div class="dashboard-card-info">
        <p class="dashboard-card-image">
            <a href={bicycle.image} target="_blank">🖼️</a>
        </p>
        <p class="dashboard-card-price">
            <Modal show={$modal}>
                <Info info={bicycle.price} icon="💳" />
            </Modal>
        </p>
        <p class="dashboard-card-duration">
            <Modal show={$modal}>
                <Info info={bicycle.duration} icon="⏲️" />
            </Modal>
        </p>
        <p class="dashboard-card-available">
            <Modal show={$modal}>
                <Info info={bicycle.available} icon="🔓" />
            </Modal>
        </p>
        <p class="dashboard-card-owner">
            <Modal show={$modal}>
                <Info info={bicycle.owner.name} icon="⚡" />
            </Modal>
        </p>
    </div>
    {#if !isUserOwnerOrRenter}
        <div class="dashboard-bike-rent" on:click={()=>{
            fetch('http://localhost:8080/bicycle/'+bicycle.id+'/user/'+$userId, {
                "method": 'POST',
                "headers": {
                    "Authorization": "Bearer " + $token,
                    "Content-Type": "application/json"
                }
            })
        }}>
        <Modal show={$modal}>
            <Info info={`Call the owner at ${bicycle.owner.phone} to proceed with the rent.`} icon="RENT" />
        </Modal>
            
        </div>
    {/if}
</li>