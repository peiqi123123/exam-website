<template>
  <div class="contest">
    <TabBar></TabBar>
    <router-view></router-view>
  </div>
</template>
<script setup>
import TabBar from "../../components/TabBar.vue";
</script>
<style lang="less" scoped>
.contest {
  width: 70%;
  margin: 0 auto;
  position: relative;
  padding: 5%;
  min-width: 800px;
}
</style>
