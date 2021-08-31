<template>
  <div class="create-tweet" ref="createTweet">
    <h1>Novo Tweet</h1>
    <input
      class="default-input"
      type="text"
      v-model="sender"
      placeholder="Nome do usuário"
    />
    <textarea class="default-input" v-model="text" placeholder="Mensagem..." />
    <input class="default-input" type="datetime-local" v-model="date" />
    <button v-on:click="sendTweet">Enviar</button>
  </div>
</template>

<script>
import api from "@/api";

export default {
  name: "CreateTweet",
  data() {
    return {
      text: "",
      sender: "",
      date: new Date(),
    };
  },
  methods: {
    sendTweet() {
      console.log("send", this.date);
      const loader = this.$loading.show({
        container: this.$refs.createTweet,
      });

      const tweet = {
        text: this.text,
        sender: this.sender,
        date: new Date(this.date).toISOString(),
      };

      api
        .sendTweet(tweet)
        .then(() => {
          this.text = "";
          this.sender = "";
          this.date = new Date();
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          loader.hide();
        });
    },
  },
};
</script>

<style scoped>
.create-tweet {
  width: 500px;
  border: 1px solid #ffffff;
  border-radius: 20px;
  padding: 20px;
}

input[type="text"] {
  height: 40px;
}

textarea {
  padding-top: 10px;
  height: 100px;
}

input[type="datetime-local"] {
  height: 40px;
  padding-right: 20px;
}

button {
  width: 100px;
  height: 40px;
  margin-left: 400px;
  margin-top: 10px;
}

.default-input {
  width: inherit;
  border-radius: 20px;
  padding-left: 20px;
  margin-top: 10px;
  box-sizing: border-box;
}
</style>
