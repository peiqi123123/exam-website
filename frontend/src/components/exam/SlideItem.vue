<template>
  <div class="slide_item">
    <div class="question_info">
      <div class="number">题 {{ props.number }}</div>
      <div class="score">({{ props.score }} 分)</div>
    </div>
    <div
      class="status iconfont icon-xinxi"
      style="color: #909399"
      v-if="props.status === 0"
    ></div>
    <div
      class="status iconfont icon-zhengque"
      style="color: #1afa29"
      v-if="props.status === 1"
    ></div>
    <div
      class="status iconfont icon-jinggao"
      style="color: #faad14"
      v-if="props.status === 2"
    ></div>
  </div>
</template>
<script setup>
const props = defineProps({
  number: Number || String,
  // 0代表未选 1代表选择 2代表存疑
  status: {
    type: Number || String,
    default: 0,
  },
  score: Number || String,
});
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
