<template>
  <div class="exam_tab_bar">
    <div class="total-score">满分：1000分</div>
    <div class="pass-score">及格：600分</div>
    <div class="has_answer">已答：{{ hasAnswerContext }}</div>
    <div class="remain_time">剩余时间：{{ `${hr}: ${min}: ${sec}` }}</div>
    <div class="submit">
      <el-button type="primary" @click="submit">交卷</el-button>
    </div>
    <div class="submit-dialog">
      <el-dialog v-model="submitDialogVisible" title="交卷" width="40%" center>
        <SubmitConfirm
          :questionStatus="questionStatus"
          @toDetail="toDetail"
        ></SubmitConfirm>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="submitDialogVisible = false">取消</el-button>
            <el-button
              type="primary"
              @click="confirmSubmit"
              :loading="isLoading"
              >确定</el-button
            >
          </span>
        </template>
      </el-dialog>
    </div>
  </div>
</template>
<script setup>
import { ref, watch, inject } from "vue";
import { useStore } from "vuex";
import { useRouter } from "vue-router";
import SubmitConfirm from "./SubmitConfirm.vue";
import { submitExercise } from "@/network/api/user";
const message = inject("message");
const store = useStore();
const Router = useRouter();
const props = defineProps({
  size: Number,
  endTime: {
    type: Number,
    default: Date.parse(new Date()) + 2 * 60 * 60 * 1000,
  },
  hasAnswer: {
    type: Number,
    default: 0,
  },
  examId: String,
});
const size = props.size;
let hasAnswerContext = ref(`${props.hasAnswer}/${size}`);
// 初始化已做题目个数
store.commit("setHasAnswer", props.hasAnswer);
watch(
  () => store.getters.getHasAnswer,
  (hasAnser) => {
    hasAnswerContext.value = `${hasAnser}/${size}`;
  }
);
// 设置倒计时
const end = props.endTime;
store.commit("setEndTime", end);
let hr = ref(0);
let min = ref(0);
let sec = ref(0);
function start() {
  const now = Date.parse(new Date());
  const msec = end - now;
  hr.value = parseInt((msec / 1000 / 60 / 60) % 24);
  min.value = parseInt((msec / 1000 / 60) % 60);
  sec.value = parseInt((msec / 1000) % 60);
  hr.value = hr.value > 9 ? hr.value : "0" + hr.value;
  min.value = min.value > 9 ? min.value : "0" + min.value;
  sec.value = sec.value > 9 ? sec.value : "0" + sec.value;
}
start();
setInterval(() => {
  start();
}, 1000);
// 交卷
const questionStatus = ref([]);
const questionAnswers = ref([]);
const submitDialogVisible = ref(false);
// 跳转到对应题目
function toDetail(i) {
  store.commit("setCurrentIndex", i);
  submitDialogVisible.value = false;
}
function submit() {
  questionAnswers.value = store.getters.getQuestionAnswers;
  questionStatus.value = store.getters.getQuestionStatus;
  submitDialogVisible.value = true;
}
// 确定提交
const isLoading = ref(false);
async function confirmSubmit() {
  isLoading.value = true;
  // 计算考试总用时
  const totalTime =
    parseInt(hr.value) * 60 * 60 +
    parseInt(min.value) * 60 +
    parseInt(sec.value);
  const res = await submitExercise(
    questionAnswers.value,
    totalTime,
    props.examId
  );
  // console.log(questionAnswers.value);
  // console.log(totalTime);
  // console.log(props.examId);
  // console.log(res);
  if (res.code === 201) {
    message.success("提交成功");
    submitDialogVisible.value = false;
    Router.push("/review");
    store.commit("clear");
    isLoading.value = false;
  } else {
    message.error("网络超时");
  }
}
</script>
<style lang="less" scoped>
.exam_tab_bar {
  font-size: 13px;
  color: #696969;
  display: flex;
  justify-content: flex-end;
  line-height: 60px;
  > div {
    margin-right: 10px;
    margin-left: 5px;
  }
  .remain_time {
    color: red;
    font-size: 15px;
    font-weight: bolder;
  }
}
</style>
