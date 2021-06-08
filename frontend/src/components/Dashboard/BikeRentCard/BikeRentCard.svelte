<script>
    import './BikeRentCard.css'
    import Modal from '../Modal/Util/Modal.svelte';
    import Info from '../Modal/Info.svelte';
	import { writable } from 'svelte/store';

    const modal = writable(null);

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
    <div class="dashboard-bike-rent">
        RENT
    </div>
</li>