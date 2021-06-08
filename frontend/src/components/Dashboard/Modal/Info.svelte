<script>
    import { getContext } from 'svelte';
      
    import Popup from './Util/Popup.svelte';
  
    const { open } = getContext('simple-modal');

    export let info = "Close me and retry..."
    export let icon = "⛔"

    const showPopup = () => {
          open(Popup, { message: info });
      };
</script>
  
<div on:click={showPopup}>{icon}</div>