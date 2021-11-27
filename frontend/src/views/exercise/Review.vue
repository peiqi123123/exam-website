<template>
  <div class="self_exercise" v-if="Object.keys(questions).length !== 0">
    <el-container>
      <el-container>
        <el-aside width="25%">
          <ExamSideBar :questions="questions" type="review"></ExamSideBar>
        </el-aside>
        <el-main
          ><ExamQues :questions="questions" type="review"></ExamQues
        ></el-main>
      </el-container>
    </el-container>
  </div>
  <div v-else v-loading.fullscreen.lock="true"></div>
</template>
<script setup>
import { ref } from "vue";
import { useStore } from "vuex";
let questions = ref({});
const store = useStore();
questions.value = store.getters.getQuestions;
// 获取练习题目等相关信息
</script>
<style lang="less" scoped>
.self_exercise {
  margin-top: 50px;
  min-width: 1200px;
  position: relative;
  .el-main {
    background-color: #fff;
    border-radius: 10px;
  }
}
</style>
