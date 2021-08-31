import { createApp } from 'vue'
import App from './App.vue'
import VueLoading from 'vue-loading-overlay';
import 'vue-loading-overlay/dist/vue-loading.css';

const app = createApp(App)
app.use(VueLoading);
app.mount('#app');
