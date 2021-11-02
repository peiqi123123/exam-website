<template>
  <div class="exam_slide_bar">
    <div class="title">
      <div class="name">姓名：黄京旺</div>
      <el-divider direction="vertical"></el-divider>
      <div class="account">账号：1905110129</div>
    </div>
    <el-scrollbar ref="scrollbar" height="550px" always>
      <div class="tf" v-if="TFQuestions.length !== 0">
        <div class="tf_title solid">判断题</div>
        <SlideItem
          v-for="(item, i) in TFQuestions"
          :number="i + 1"
          :score="16"
        ></SlideItem>
      </div>
      <div class="select" v-if="choiceQuestions.length !== 0">
        <div class="select_title solid">选择题</div>
        <SlideItem
          v-for="(item, i) in choiceQuestions"
          :number="TFSize + i + 1"
          :score="16"
        ></SlideItem>
      </div>
    </el-scrollbar>
  </div>
</template>
<script setup>
import SlideItem from "./SlideItem.vue";
const props = defineProps({
  questions: {
    type: Object,
    default: {},
  },
});
const TFQuestions = props.questions.TFQuestions;
const choiceQuestions = props.questions.choiceQuestions;
const TFSize = props.questions.TFQuestions.length;
const choiceSize = props.questions.choiceQuestions.length;
</script>
<style lang="less" scoped>
.exam_slide_bar {
  width: 90%;
  min-height: 550px;
  padding: 10px;
  background-color: #fff;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  border-radius: 4px;
  display: inline-block;
  margin-left: 10px;
  vertical-align: top;
  .title {
    display: flex;
    justify-content: space-between;
    margin-bottom: 10px;
  }
  .solid {
    border-bottom: 1px solid #d3d3d3;
    padding-bottom: 10px;
    margin-bottom: 10px;
  }
}
</style>
