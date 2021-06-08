<script>
    import './BikeRentCard.css'
    

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
        <p class="dashboard-card-image">🖼️</p>
        <p class="dashboard-card-price">💳</p>
        <p class="dashboard-card-duration">⏲️</p>
        <p class="dashboard-card-available">🔓</p>
        <p class="dashboard-card-owner">⚡</p>
    </div>
    <div class="dashboard-bike-rent">
        RENT
    </div>
</li>