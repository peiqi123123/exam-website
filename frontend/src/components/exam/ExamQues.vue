<template>
  <div class="exam_ques">
    <div class="title">
      <div class="question_type">{{ questionType }}</div>
      <div class="question_number">{{ questionNumber }}</div>
    </div>
    <div class="question_detail">
      <div class="tf_question" v-if="questionType === '判断题'">
        <div class="tf_question_describe question_describe">
          {{ index }}. {{ TFQuestionContent }}
        </div>
        <div class="tf_question_option">
          <el-radio-group v-model="radio" @change="selectOption">
            <el-radio :label="1">对</el-radio>
            <el-radio :label="0">错</el-radio>
          </el-radio-group>
        </div>
      </div>
      <div class="choice_question" v-if="questionType === '单选题'">
        <div class="choice_question_describe question_describe">
          {{ index }}. {{ ChoiceQuestionContent }}
        </div>
        <div class="choice_question_option">
          <el-radio-group v-model="radio" @change="selectOption">
            <el-radio label="A">A. {{ currentQuestion.optionA }}</el-radio>
            <el-radio label="B">B. {{ currentQuestion.optionB }}</el-radio>
            <el-radio label="C">C. {{ currentQuestion.optionC }}</el-radio>
            <el-radio label="D">D. {{ currentQuestion.optionD }}</el-radio>
          </el-radio-group>
        </div>
      </div>
    </div>
    <div class="feedback">
      <el-button type="info" round @click="before" :disabled="!isBefore"
        >上一题</el-button
      >
      <el-button type="primary" round @click="after" :disabled="!isAfter"
        >下一题</el-button
      >
      <el-button type="warning" round @click="impeach">存疑</el-button>
    </div>
  </div>
</template>
<script setup>
import { watch, ref } from "vue";
import { useStore } from "vuex";
const props = defineProps({
  questions: {
    type: Object,
    default: {},
  },
});
// 选择答案
const radio = ref(-1);
const store = useStore();
// 题目信息
const TFQuestions = props.questions.TFQuestions || [];
const choiceQuestions = props.questions.choiceQuestions || [];
// 题目长度
const TFSize = TFQuestions.length;
const choiceSize = choiceQuestions.length;
// 所有题目数量
const size = TFSize + choiceSize;
// 当前题目信息
const currentQuestion = ref({});
// 题目描述
let TFQuestionContent = ref("");
let ChoiceQuestionContent = ref("");
let questionId = ref(0);
// 题目类型
let questionType = ref("判断题");
let questionNumber = ref(`第1 / ${size}题`);
// 当前题目索引
let index = ref(1);
// 判断是否有判断题
function isTF() {
  return TFSize > 0 && index.value <= TFSize;
}
// 判断是否有单选题
function isChoice() {
  if (
    choiceSize > 0 &&
    index.value > TFSize &&
    index.value <= TFSize + choiceSize
  ) {
    return true;
  } else return false;
}
// 判断是否有多选题
function isMoreChoice() {}
function changeInfo(currentIndex) {
  if (isTF()) {
    questionType.value = "判断题";
    TFQuestionContent.value = TFQuestions[currentIndex - 1].questionContent;
    questionId.value = TFQuestions[currentIndex - 1].questionId;
  } else if (isChoice()) {
    currentQuestion.value = choiceQuestions[currentIndex - 1 - TFSize];
    questionType.value = "单选题";
    ChoiceQuestionContent.value = currentQuestion.value.questionContent;
    questionId.value = currentQuestion.value.questionId;
  } else if (isMoreChoice()) {
    questionType.value = "多选题";
  }
}
changeInfo(index.value);
// 判断是否有上一题或者下一题
const isBefore = ref(false);
const isAfter = ref(true);
watch(
  () => store.getters.getCurrentIndex,
  (currentIndex) => {
    if (currentIndex <= 1) isBefore.value = false;
    else if (currentIndex >= size) isAfter.value = false;
    else {
      isBefore.value = true;
      isAfter.value = true;
    }
    index.value = currentIndex;
    radio.value = store.getters.getQuestionAnswers[currentIndex].answer;
    changeInfo(currentIndex);
    questionNumber.value = `第${currentIndex} / ${size}题`;
  }
);
// 选中选项的回调
function selectOption(value) {
  console.log(value);
  store.commit("setOneAnswer", {
    index: index.value,
    value: value,
    questionId: questionId.value,
  });
  store.commit("setOneStatus", {
    index: index.value,
    value: 1,
  });
}
// 存疑按钮的回调
function impeach() {
  store.commit("setOneStatus", {
    index: index.value,
    value: 2,
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
  .feedback {
    margin-top: 50px;
  }
}
</style>
