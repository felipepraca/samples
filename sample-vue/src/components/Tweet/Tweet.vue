<template>
  <div class="tweet">
    <h3>{{ tweet.sender }}</h3>
    <div class="text">{{ tweet.text }}</div>
    <br />
    <div class="date">Em: {{ tweet.date }}</div>

  </div>
</template>

<script>
export default {
  name: 'Tweet',
  props: {
    tweet: Object
  },
  created() {
    console.log('Tweet', this.tweet)
  },
}
</script>

<style scoped>
.tweet {
  border: 1px solid #ffffff;
  border-radius: 20px;
  padding: 20px;
  min-height: 100px;
}

.text {
  padding: 10px;
  border: 1px solid #263549;
  border-radius: 10px;
}

.date {
  font-size: 12px;
}
</style>