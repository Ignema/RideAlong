<script>
    import { getContext } from 'svelte';
    import { token, userId } from '../../../../store.js';

    export let message;
    export let hasForm = false;
    export let onCancel = () => {};
  
    const { close } = getContext('simple-modal');

     async function schedule(date, location) {
        const res = await fetch('http://localhost:8080/participant/'+$userId, {
			"method": 'GET',
            "headers": {
                "Authorization": "Bearer " + $token
            }
		})

		const organizer = await res.json()
        let meetup = {
            "date": date,
            "location": location,
            "completed": false,
            "organizer": organizer
        }

		fetch('http://localhost:8080/meetup', {
			"method": 'POST',
            "headers": {
                "Authorization": "Bearer " + $token,
                "Content-Type": "application/json"
            },
            body: JSON.stringify(meetup)
		}).then(()=>location.reload).catch(err => console.log(err))
	}
      
      let date;
      let location;
      let onChange = () => {};
      
      function _onCancel() {
          onCancel();
          close();
      }
      
      function _onOkay() {
          schedule(date, location)
          close();
      }
      
      $: onChange(date)
      $: onChange(location)
  </script>
  
  <style>
    h2 {
          font-size: 2rem;
          text-align: center;
      }
      
      input {
          width: 100%;
      }
      
      .buttons {
          display: flex;
          justify-content: space-between;
      }
  </style>
  
  <h2>{message}</h2>
  
  {#if hasForm}
    <p>Date</p>
    <input type="datetime-local" bind:value={date} on:keydown={e => e.which === 13 && _onOkay()} />

    <p>Location</p>
    <input type="text" bind:value={location} on:keydown={e => e.which === 13 && _onOkay()} />
  {/if}
  
  <div class="buttons">
      <button on:click={_onCancel}>
          Cancel
      </button>
      <button on:click={_onOkay}>
          Okay
      </button>
  </div>