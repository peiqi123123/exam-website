import { createApp } from "vue";
import App from "./App.vue";
import "element-plus/dist/index.css";
import router from "./router";

//dev环境下模拟后台数据
import "./assets/mock/user";

const app = createApp(App);
app.use(router);
app.mount("#app");
