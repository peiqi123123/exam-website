<template>
  <div class="self_exercise">
    <Card v-for="(item, i) in config.selfExercise" :key="'self_exercise' + i" @click="startExercise(i)">
      <template #text>{{ item }} </template>
    </Card>
  </div>
</template>
<script setup>
import {useRouter} from 'vue-router'
import Card from "@/components/Card.vue";
import config from "@/config";
const Router = useRouter()
function startExercise(index) {
  Router.push("/exercise")
}
</script>
<style lang="less" scoped>
.self_exercise {
  margin: 0 auto;
  width: 80%;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
</style>
