<template>
  <div class="self_exercise" v-if="Object.keys(questions).length !== 0">
    <el-container>
      <el-header
        ><ExamTabBar :size="size" v-if="size > 0"></ExamTabBar
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
import { ref, onMounted } from "vue";
import { useStore } from "vuex";
import ExamTabBar from "@/components/exam/ExamTabBar.vue";
import ExamQues from "@/components/exam/ExamQues.vue";
import ExamSideBar from "@/components/exam/ExamSideBar.vue";
import { getExerciseQuestions } from "@/network/api/user";
import { beforeunload } from "@/network/api/user";
let questions = ref({});
const store = useStore();
let size = ref(0);
async function init() {
  const res = await getExerciseQuestions();
  console.log(res);
  size.value = 100;
  const questionAnswers = [];
  for (let i = 0; i < size.value + 1; i++) {
    questionAnswers[i] = {
      questionId: 0,
      answer: -1,
    };
  }
  const questionStatus = new Array(size.value + 1).fill(0);
  questions.value = res.data;
  store.commit("setQuestionAnswers", questionAnswers);
  store.commit("setQuestionStatus", questionStatus);
  console.log("questions", res);
}
// 获取练习题目等相关信息
init();
// 监听浏览器关闭与刷新
onMounted(() => {
  // window.addEventListener("beforeunload", (e) => {
  //   e = e || window.event;
  //   if (e) e.returnValue = "";
  //   return "";
  // });
  window.addEventListener("unload", async (e) => {
    fetch("http://localhost:8888/submit/exit", {
      method: "POST",
      body: JSON.stringify(questions.value),
      headers: { "Content-Type": "application/json" },
      keepalive: true,
    });
    // const formData = new FormData();
    // formData.append("name", JSON.stringify(questions.value));
    // window.navigator.sendBeacon("http://localhost:8888/submit/test", formData);
  });
});
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
