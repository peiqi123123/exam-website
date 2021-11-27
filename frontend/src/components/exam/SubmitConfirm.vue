<template>
  <div class="submit_confirm">
    <el-scrollbar height="300px">
      <div class="questions">
        <div v-for="(item, i) in questions">
          <div
            class="question-number"
            :class="{
              finish: questions[i].status === 1,
              warning: questions[i].status === 2,
            }"
            @click="toDetail(i)"
          >
            {{ i + 1 }}
          </div>
        </div>
      </div>
    </el-scrollbar>
  </div>
</template>
<script setup>
const props = defineProps({
  questions: {
    type: Array,
    default: [],
  },
});
const questions = props.questions;
console.log("questions: ", questions);
const emit = defineEmits(["toDetail"]);
// console.log(status);
function toDetail(i) {
  emit("toDetail", i + 1);
}
</script>
<style lang="less" scoped>
.submit_confirm {
  .el-scrollbar {
    .questions {
      display: flex;
      flex-wrap: wrap;
      .question-number {
        cursor: pointer;
        width: 50px;
        height: 50px;
        line-height: 50px;
        font-weight: bolder;
        background-color: cornsilk;
        text-align: center;
        margin: 5px;
      }
      .finish {
        background-color: #1afa29;
      }
      .warning {
        background-color: #faad14;
      }
    }
  }
}
</style>
