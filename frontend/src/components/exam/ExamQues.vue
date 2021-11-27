<template>
  <div class="exam_ques">
    <div class="title">
      <div class="question_type">{{ questionType }}</div>
      <div class="question_number">{{ questionNumber }}</div>
    </div>
    <div class="question_detail">
      <div class="choice_question">
        <div class="choice_question_describe question_describe">
          {{ index }}. {{ questionContent }}
        </div>
        <!-- 選擇題 答题 选项 -->
        <div class="choice_question_option" v-if="type === 'exercise'">
          <el-radio-group v-model="studentAnswer" @change="selectOption">
            <el-radio
              label="A"
              v-if="currentQuestion && currentQuestion.optionA"
              >A. {{ currentQuestion.optionA }}</el-radio
            >
            <el-radio
              label="B"
              v-if="currentQuestion && currentQuestion.optionB"
              >B. {{ currentQuestion.optionB }}</el-radio
            >
            <el-radio
              label="C"
              v-if="currentQuestion && currentQuestion.optionC"
              >C. {{ currentQuestion.optionC }}</el-radio
            >
            <el-radio
              label="D"
              v-if="currentQuestion && currentQuestion.optionD"
              >D. {{ currentQuestion.optionD }}</el-radio
            >
          </el-radio-group>
        </div>
        <!-- 選擇題 查看卷子 选项 -->
        <div class="choice_question_option" v-else>
          <el-radio-group>
            <Radio
              :success="answer === 'A'"
              :error="studentAnswer === 'A' && answer != 'A'"
              v-if="currentQuestion.optionA"
              >A. {{ currentQuestion.optionA }}</Radio
            >
            <Radio
              :success="answer === 'B'"
              :error="studentAnswer === 'B' && answer != 'B'"
              v-if="currentQuestion.optionB"
              >B. {{ currentQuestion.optionB }}</Radio
            >
            <Radio
              :success="answer === 'C'"
              :error="studentAnswer === 'C' && answer != 'C'"
              v-if="currentQuestion.optionC"
              >C. {{ currentQuestion.optionC }}</Radio
            >
            <Radio
              :success="answer === 'D'"
              :error="studentAnswer === 'D' && answer != 'D'"
              v-if="currentQuestion.optionD"
              >D. {{ currentQuestion.optionD }}</Radio
            >
          </el-radio-group>
        </div>
      </div>
    </div>
    <div class="exam_analy" v-if="type === 'review'">
      <div
        :class="[
          'radio',
          { success: answer === studentAnswer, error: answer != studentAnswer },
        ]"
      >
        你的选择：{{ studentAnswer }}
      </div>
      <div class="answer">正确答案：{{ answer }}</div>
      <div class="analy">
        解析：{{
          "如果DHCP服务器全局地址池中的IP地址与中继设备上连接的客户端的VLANIF接口的IP地址不在同一网段， 则会引起DHCP故障。"
        }}
      </div>
    </div>
    <div class="feedback">
      <el-button type="info" round @click="before" :disabled="!isBefore"
        >上一题</el-button
      >
      <el-button type="primary" round @click="after" :disabled="!isAfter"
        >下一题</el-button
      >
      <el-button
        type="warning"
        round
        @click="impeach"
        v-if="type === 'exercise'"
        >存疑</el-button
      >
    </div>
  </div>
</template>
<script setup>
import { watch, ref } from "vue";
import { useStore } from "vuex";
// import Radio from "../Radio.vue";
const props = defineProps({
  questions: {
    type: Object,
    default: {},
  },
  type: {
    type: String,
    default: "exercise",
  },
});
// 选择答案
const store = useStore();
// 所有题目数量
const size = props.questions.length;
// 当前题目信息
const currentQuestion = ref({});
// 题目描述
let questionContent = ref("");
let questionId = ref("0");
// 题目类型
let questionType = ref("判断题");
let questionNumber = ref(`第1 / ${size}题`);
// 当前题目答案
const answer = ref("");
// 学生答案
const studentAnswer = ref("");
// 当前题目索引
let index = ref(1);
// 根据当前题目索引判断题目类型
function changeInfo() {
  studentAnswer.value =
    currentQuestion.value && currentQuestion.value.studentAnswer;
  answer.value = currentQuestion.value && currentQuestion.value.answer;
  questionContent.value =
    currentQuestion.value && currentQuestion.value.questionContent;
  questionId.value = currentQuestion.value && currentQuestion.value.questionId;
}

// 判断是否有上一题或者下一题
const isBefore = ref(false);
const isAfter = ref(true);
watch(
  () => store.getters.getCurrentIndex,
  (currentIndex) => {
    if (currentIndex <= 1) {
      isBefore.value = false;
      isAfter.value = true;
    } else if (currentIndex >= size) {
      isAfter.value = false;
      isBefore.value = true;
    } else {
      isBefore.value = true;
      isAfter.value = true;
    }
    index.value = currentIndex;
    currentQuestion.value = store.getters.getQuestions[currentIndex - 1];
    changeInfo();
    // console.log(studentAnswer.value);
    questionNumber.value = `第${currentIndex} / ${size}题`;
  },
  {
    immediate: true,
  }
);
// 选中选项的回调
function selectOption(value) {
  // console.log(value);
  store.commit("setOneAnswer", {
    index: index.value,
    value: value,
    questionId: questionId.value,
    status: 1,
  });
}

// 存疑按钮的回调
function impeach() {
  store.commit("setOneStatus", {
    index: index.value,
    status: 2,
  });
}
// 上一题
function before() {
  store.commit("setCurrentIndexBefore");
}
// 下一题
function after() {
  store.commit("setCurrentIndexAfter");
}
</script>
<style lang="less" scoped>
.exam_ques {
  .title {
    display: flex;
    color: darkgray;
    margin-bottom: 20px;
    .question_type {
      margin-right: 10px;
    }
    .question_number {
      margin-left: 10px;
    }
  }
  .question_detail {
    .question_describe {
      margin-bottom: 10px;
    }
    .el-radio-group {
      display: flex;
      flex-flow: column;
    }
  }
  .exam_analy {
    margin-top: 20px;
    font-weight: 500;
    font-size: 18px;
    & > div {
      margin: 10px 0;
    }
    .answer {
      color: #faad14;
    }
    .radio.success {
      color: #409eff;
    }
    .radio.error {
      color: #f56c6c;
    }
  }
  .feedback {
    margin-top: 50px;
  }
}
</style>
