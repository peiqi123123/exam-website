<template>
  <div class="slide_item" @click="toDetail">
    <div class="question_info">
      <div class="number">题 {{ props.number }}</div>
      <div class="score">({{ props.score }} 分)</div>
    </div>
    <div
      class="status iconfont icon-xinxi"
      :style="{ color: config.statusColor.info }"
      v-if="store.getters.getQuestionStatus[props.number] === 0"
    ></div>
    <div
      class="status iconfont icon-zhengque"
      :style="{ color: config.statusColor.finish }"
      v-if="store.getters.getQuestionStatus[props.number] === 1"
    ></div>
    <div
      class="status iconfont icon-jinggao"
      :style="{ color: config.statusColor.warning }"
      v-if="store.getters.getQuestionStatus[props.number] === 2"
    ></div>
  </div>
</template>
<script setup>
import { useStore } from "vuex";
import config from "@/config";
const props = defineProps({
  number: Number || String,
  // 0代表未选 1代表选择 2代表存疑
  status: {
    type: Number || String,
    default: 0,
  },
  score: Number || String,
  questionId: Number,
});
const store = useStore();
function toDetail() {
  store.commit("setCurrentIndex", props.number);
}
</script>
<style lang="less" scoped>
.slide_item {
  padding: 5px;
  margin-bottom: 5px;
  display: flex;
  justify-content: space-between;
  cursor: pointer;
  &:hover {
    background-color: #e9e9e9;
  }
  .question_info {
    display: flex;
    & > div {
      margin-right: 5px;
    }
  }
  .status {
    margin-right: 10px;
  }
}
</style>
