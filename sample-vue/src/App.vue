<template>
    <div>
      <img class="logo" src="@/assets/logo.png" />
      <Home />
    </div>
</template>

<script>
import Home from './components/Home.vue'

export default {
  components: {
    Home,
  }
}
</script>

<style>
html, body, #fullheight {
    min-height: 100% !important;
    height: 100%;
    width: 100%;
    background-color: #18222D;
    font-family: Arial, Helvetica, sans-serif;
    color: #ffffff;
    display: flex;
    justify-content: center;
}

::placeholder, input, textarea {
  color: #ffffff;
}

input, textarea {
  border: 1px solid #cfcfcf;
  background-color: #18222D;
}

::-webkit-calendar-picker-indicator {
    filter: invert(1);
}

button {
  border-radius: 20px;
  background-color: #3D6A97;
  border: 1px solid #3D6A97;
  color: #ffffff;
}

.logo {
  width: 70px;
  position: absolute;
  margin-left: -15%;
}

</style>
