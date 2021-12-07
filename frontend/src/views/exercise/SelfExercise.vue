<template>
  <div class="self_exercise" v-if="Object.keys(questions).length !== 0">
    <el-container>
      <el-header
        ><ExamTabBar :size="size" :examId="examId" v-if="size > 0"></ExamTabBar
      ></el-header>
      <el-container>
        <el-aside width="25%">
          <ExamSideBar :questions="questions"></ExamSideBar>
        </el-aside>
        <el-main><ExamQues :questions="questions"></ExamQues></el-main>
      </el-container>
    </el-container>
  </div>
  <div v-else v-loading.fullscreen.lock="true"></div>
</template>
<script setup>
import { ref } from "vue";
import { useStore } from "vuex";
import { getExerciseQuestions, exerciseExit } from "@/network/api/user";
// import { beforeunload } from "@/network/api/user";
import config from "@/config";
let questions = ref({});
const store = useStore();
let size = ref(0);
const examId = ref("");
async function init() {
  const res = await getExerciseQuestions();
  console.log("res: ", res);
  size.value = res.data.questions.length;
  examId.value = res.data.examId;
  questions.value = res.data.questions;
  store.commit("setQuestions", questions.value);
}
// 获取练习题目等相关信息
init();
// 监听浏览器关闭与刷新
// onMounted(() => {
//   // window.addEventListener("beforeunload", (e) => {
//   //   e = e || window.event;
//   //   if (e) e.returnValue = "";
//   //   return "";
//   // });
//   window.addEventListener("unload", (e) => {
//     exerciseExit(questions.value);
//   });
// });
</script>
<style lang="less" scoped>
.self_exercise {
  min-width: 1200px;
  position: relative;
  .el-main {
    background-color: #fff;
    border-radius: 10px;
  }
}
</style>
