<template>
  <div class="exam_ques">
    <div class="title">
      <div class="question_type">{{ questionType }}</div>
      <div class="question_number">{{ questionNumber }}</div>
    </div>
    <div class="question_detail">
      <div class="tf_question" v-if="questionType === '判断题'">
        <div class="tf_question_describe question_describe">
          {{ index }}. {{ TFQuestionContext }}
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
          {{ index }}. {{ ChoiceQuestionContext }}
        </div>
        <div class="choice_question_option">
          <el-radio-group v-model="radio" @change="selectOption">
            <el-radio label="A">Option A</el-radio>
            <el-radio label="B">Option B</el-radio>
            <el-radio label="C">Option C</el-radio>
            <el-radio label="D">Option D</el-radio>
          </el-radio-group>
        </div>
      </div>
    </div>
    <div class="feedback">
      <el-button type="info" round @click="before">上一题</el-button>
      <el-button type="primary" round @click="after">下一题</el-button>
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
const TFQuestions = props.questions.TFQuestions;
const choiceQuestions = props.questions.choiceQuestions;
const TFSize = TFQuestions.length;
const choiceSize = choiceQuestions.length;
const size = TFSize + choiceSize;
let TFQuestionContext = ref("");
let ChoiceQuestionContext = ref("");
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
    TFQuestionContext.value = TFQuestions[currentIndex - 1].questionContext;
  } else if (isChoice()) {
    questionType.value = "单选题";
    ChoiceQuestionContext.value =
      choiceQuestions[currentIndex - 1 - TFSize].questionContext;
  } else if (isMoreChoice()) {
    questionType.value = "多选题";
  }
}
changeInfo(index.value);
watch(
  () => store.getters.getCurrentIndex,
  (currentIndex) => {
    index.value = currentIndex;
    radio.value = store.getters.getQuestionAnswers[currentIndex];
    changeInfo(currentIndex);
    questionNumber.value = `第${currentIndex} / ${size}题`;
  }
);
// 选中选项的回调
function selectOption(value) {
  store.commit("setOneAnswer", {
    index: index.value,
    value: value,
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
  }
  .feedback {
    margin-top: 50px;
  }
}
</style>
