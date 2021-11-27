<template>
  <div class="score">
    <el-card class="box-card">
      <div class="diagram" ref="diagram"></div>
      <div class="info">
        <div class="name">姓名：黄京旺</div>
        <div class="number">学号: 1905110129</div>
        <div class="total_score">得分：{{ totalScore }}</div>
        <div class="start_time">开始时间：{{ startTime }}</div>
        <div class="end_time">总用时：{{ totalTime }}</div>
        <el-button class="btn" type="primary" round @click="toReview"
          >查看卷子</el-button
        >
      </div>
    </el-card>
  </div>
</template>
<script setup>
import { ref, onMounted, inject } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useStore } from "vuex";
import { getExerciseReview } from "@/network/api/user";
// 导入更改卷子函数
import { getGrades } from "@/utils/getGrades";
// 导入时间转化函数
import { format, timestamp } from "@/utils/transformTime";
const route = useRoute();
const store = useStore();
// 考试ID
const examId = parseInt(route.params.id);
// 引入echarts
const echarts = inject("echarts");
// 考试信息
const questions = ref([]);
const startTime = ref();
const totalTime = ref();
const endTime = ref();
const diagram = ref();
const totalScore = ref(0);
async function init() {
  if (examId === 0) {
    // 获取本地考试记录
    questions.value = store.getters.getQuestions;
    startTime.value = store.getters.getStartTime;
    totalTime.value = store.getters.getTotalTime;
    endTime.value = store.getters.getEndTime;
  } else {
    // 获取指定examId的考试信息
    const res = await getExerciseReview();
    if (res.code === 200) {
      const data = res.data;
      questions.value = data.questions;
      totalTime.value = data.totalTime;
      startTime.value = data.startTime;
    }
  }
  totalTime.value = format(totalTime.value);
  startTime.value = timestamp(startTime.value);
  store.commit("setQuestions", questions.value);
  const { correctSize, errorSize, score } = getGrades(questions.value);
  totalScore.value = score;
  var myChart = echarts.init(diagram.value);
  const option = {
    legend: {
      orient: "vertical",
      x: "left",
      data: [`正确:${correctSize}`, `错误:${errorSize}`],
    },
    color: ["green", "red"],
    series: [
      {
        type: "pie",
        radius: ["50%", "70%"],
        avoidLabelOverlap: false,
        label: {
          show: false,
          position: "center",
          emphasis: {
            show: true,
          },
        },
        labelLine: {
          show: false,
        },
        emphasis: {
          label: {
            show: true,
            fontSize: "30",
            fontWeight: "bold",
          },
        },
        data: [
          { value: correctSize, name: `正确:${correctSize}` },
          { value: errorSize, name: `错误:${errorSize}` },
        ],
      },
    ],
  };
  // 绘制图表
  myChart.setOption(option);
}
onMounted(async () => {
  await init();
});
// 查看卷子详情
const router = useRouter();
function toReview() {
  router.push("/review");
}
</script>
<style lang="less" scoped>
.score {
  width: 70%;
  min-width: 1000px;
  margin: 100px auto;

  .box-card {
    min-height: 500px;
    display: flex;
    align-items: center;
    :deep(.el-card__body) {
      display: flex;
    }
    .diagram {
      width: 300px;
      height: 300px;
    }
    .info {
      margin-left: 150px;
      & > div {
        padding: 20px 0;
        font-weight: bolder;
      }
      .btn {
        display: block;
        margin: 20px auto 0;
      }
    }
  }
}
</style>
