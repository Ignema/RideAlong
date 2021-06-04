<script>
	import Header from "./components/Homepage/Header/Header.svelte"
	import Screens from "./components/Homepage/Screens/Screens.svelte"
	import About from "./components/Homepage/About/About.svelte"
	import Pictures from "./components/Homepage/Pictures/Pictures.svelte"
	import Footer from "./components/Homepage/Footer/Footer.svelte"
</script>

<style>
	main{
		background-color: azure;
		margin-bottom: 350px;
	}
</style>

<main>
	<Header />
	<Screens />
	<About />
	<Pictures />
</main>

<Footer />

