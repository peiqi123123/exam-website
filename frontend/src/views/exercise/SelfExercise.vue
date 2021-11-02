<template>
  <div class="self_exercise">
    <el-container>
      <el-header><ExamTabBar></ExamTabBar></el-header>
      <el-container>
        <el-aside width="25%">
          <ExamSideBar
            :questions="questions"
            v-if="Object.keys(questions).length !== 0"
          ></ExamSideBar>
        </el-aside>
        <el-main
          ><ExamQues
            :questions="questions"
            v-if="Object.keys(questions).length !== 0"
          ></ExamQues
        ></el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script setup>
import { ref } from "vue";
import { useStore } from "vuex";
import ExamTabBar from "@/components/exam/ExamTabBar.vue";
import ExamQues from "@/components/exam/ExamQues.vue";
import ExamSideBar from "@/components/exam/ExamSideBar.vue";
import { getExerciseQuestions } from "@/network/api/user";
let questions = ref({});
const store = useStore();
async function init() {
  const res = await getExerciseQuestions();
  const size = res.size;
  const questionAnswers = new Array(size + 1);
  const questionStatus = new Array(size + 1).fill(0);
  questions.value = res.questions;
  store.commit("setQuestionAnswers", questionAnswers);
  store.commit("setQuestionStatus", questionStatus);
  console.log("questions", res);
}
// 获取练习题目等相关信息
init();
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
