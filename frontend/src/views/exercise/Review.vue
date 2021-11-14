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
// import ExamQues from "@/components/exam/ExamQues.vue";
import { getExerciseReview } from "@/network/api/user";
// 导入更改卷子函数
import { getGrades } from "../../utils/getGrades";
let questions = ref({});
// const store = useStore();
// const Route = useRoute();
const store = useStore();
async function init() {
  const res = await getExerciseReview();
  console.log("res", res);
  const grade = getGrades(res.data);
  console.log(grade);
  store.commit("setQuestionAnswers", grade.answers);
  questions.value = res.data;
  store.commit("setQuestionStatus", grade.status);
}
// 获取练习题目等相关信息
init();
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
