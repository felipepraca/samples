<template>
  <div class="home">
    <CreateTweet />
    <br />
    <Timeline />
  </div>
</template>

<script>
import api from '@/api'
import CreateTweet from '@/components/Tweet/CreateTweet.vue'
import Timeline from '@/components/Tweet/Timeline.vue'

export default {
  name: 'Home',
  components: {
    CreateTweet,
    Timeline
  },
  props: {
    msg: String
  },
  created() {
    api.getTweets().then(response => {
      console.log(response.data)
    })
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.home {
  width: inherit;
  height: inherit;
  
}
</style>
