const axios = require('axios').default

const instance = axios.create({
    baseURL: 'http://localhost:8070/',
    timeout: 10000
  });

const getTweets = async () => {
    return instance.get('/tweet')
}

const getTweet = async (id) => {
    return instance.get(`/tweet/${id}`)
}

const sendTweet = async (tweet) => {
    return instance.post('/tweet', tweet)
}

const updateTweet = async (tweet) => {
    return instance.put('/tweet', tweet)
}

const deleteTweet = async (id) => {
    return instance.delete(`/tweet/${id}`)
}

export default {
    getTweets,
    getTweet,
    sendTweet,
    updateTweet,
    deleteTweet
}