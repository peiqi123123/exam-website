import axios from "axios";
import config from "@/config";
//导入全局消息提醒
import { ElMessage } from "element-plus";
//导入路由相关组件
import Router from "@/router";
const message = ElMessage;

const instance = axios.create({
  baseURL: config.dev.baseURL,
  timeout: 3000,
});

instance.interceptors.request.use(
  (config) => {
    return config;
  },
  (err) => {
    Promise.reject(err);
  }
);

instance.interceptors.response.use(
  (res) => {
    const status = res.data.status;
    if (status === 401) {
      message.info("登录失效，请重新登录");
      // Router.push("/login");
      console.log(Router);
      // window.location.href = "/login";
      Router.push("/login");
    }
    return res.data;
  },
  (err) => {
    Promise.reject(err);
  }
);

export default instance;
