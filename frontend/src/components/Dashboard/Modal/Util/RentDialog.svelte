<script>
    import { getContext } from 'svelte';
    export let message;
    export let hasForm = false;
    export let onCancel = () => {};
  
    const { close } = getContext('simple-modal');

     async function rent(model, image, price, duration) {
        const res = await fetch('http://localhost:8080/participant/1', {
			"method": 'GET',
            "headers": {
                "Authorization": "Basic " + btoa("user:e1d7f81a-ac7a-4fa2-9f2d-9ff0bbb3ee87")
            }
		})

		const owner = await res.json()
        let bicycle = {
            "model": model,
            "image": image,
            "price": price,
            "duration": duration,
            "available": true,
            "owner": owner
        }

		fetch('http://localhost:8080/bicycle', {
			"method": 'POST',
            "headers": {
                "Authorization": "Basic " + btoa("user:1800c92a-e30f-4d8f-9326-7b252407803f"),
                "Content-Type": "application/json"
            },
            body: JSON.stringify(bicycle)
		}).then(()=>location.reload()).catch(err => console.log(err))
	}
      
      let model;
      let image;
      let price;
      let duration;
      let onChange = () => {};
      
      function _onCancel() {
          onCancel();
          close();
      }
      
      function _onOkay() {
          rent(model, image, price, duration)
          close();
      }
      
      $: onChange(model)
      $: onChange(image)
      $: onChange(price)
      $: onChange(duration)
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
    <p>Model</p>
    <input type="text" bind:value={model} on:keydown={e => e.which === 13 && _onOkay()} />

    <p>Image Link</p>
    <input type="text" bind:value={image} on:keydown={e => e.which === 13 && _onOkay()} />

    <p>Rent Price</p>
    <input type="text" bind:value={price} on:keydown={e => e.which === 13 && _onOkay()} />

    <p>Rent Duration</p>
    <input type="text" bind:value={duration} on:keydown={e => e.which === 13 && _onOkay()} />
  {/if}
  
  <div class="buttons">
      <button on:click={_onCancel}>
          Cancel
      </button>
      <button on:click={_onOkay}>
          Okay
      </button>
  </div>