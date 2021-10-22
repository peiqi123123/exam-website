<template>
  <router-view />
</template>
<script setup>
// This starter template is using Vue 3 <script setup> SFCs
// Check out https://v3.vuejs.org/api/sfc-script-setup.html#sfc-script-setup
import { provide } from "vue";
import Login from "@/views/login/Login.vue";
import { ElMessage } from "element-plus";
//全局注入消息提示功能
provide("message", ElMessage);
</script>
<style lang="less">
@import "@/assets/css/style.less";
body {
  background-color: @primaty-color;
  margin: 0;
  padding: 0;
}
</style>
