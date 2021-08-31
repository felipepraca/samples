<template>
    <div class="timeline">
        <h1>Timeline</h1>
        <img v-on:click="getTweets" class="refresh" src="@/assets/refresh.png"/>
        <Tweet class="tweet" v-for="item in tweets" :key="item.id" :tweet="item" />
    </div>
</template>

<script>
import api from '@/api'
import Tweet from '@/components/Tweet/Tweet.vue'

export default {
  name: 'Timeline',
  components: {
    Tweet
  },
  data() {
      return {
          tweets: []
      }
  },
  methods: {
    getTweets() {
      const loader = this.$loading.show({
        container: this.$refs.createTweet,
      });

      api.getTweets()
      .then(response => {
        this.tweets = response.data
        console.log(this.tweets)
      })
      .catch(error => {
        console.log(error)
      })
      .finally(() => {
        loader.hide()
      })
    }
  },
  created() {
    this.getTweets()
  },
}
</script>

<style scoped>
.timeline {
  height: fit-content;
}

.tweet {
  margin-top: 10px;
}

.refresh {
  width: 40px;
  position: absolute;
  margin-top: -60px;
  margin-left: 500px;
}

.refresh:hover {
  -moz-transform:rotate(180deg);
  -webkit-transform:rotate(180deg);
  transform:rotate(180deg);
  -moz-transition-duration: 1s;
  -webkit-transition-duration: 1s;
  transition-duration: 1s;

}
</style>