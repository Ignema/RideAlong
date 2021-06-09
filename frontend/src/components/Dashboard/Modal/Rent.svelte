<script>
	import { getContext } from 'svelte';
	import Dialog from './Util/RentDialog.svelte';
  
	const { open } = getContext('simple-modal');

    export let info = "Close me and retry..."
    export let icon = "⛔"
	  
	  const onCancel = (text) => {
		  console.log("CANCEL")
	  }
	  
	  const onOkay = (text) => {
		  console.log("OKEY: ", text)
	  }
  
	const showDialog = () => {
		  open(
			  Dialog,
			  {
				  message: info,
				  hasForm: true,
				  onCancel,
				  onOkay
			  },
			  {
				  closeButton: false,
			  closeOnEsc: false,
			  closeOnOuterClick: false,
			  }
		);
	  };
  </script>
  
<div on:click={showDialog}>{icon}</div>
