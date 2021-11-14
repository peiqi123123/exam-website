<template>
  <div class="submit_confirm">
    <el-scrollbar height="300px">
      <div class="questions">
        <div v-for="(item, i) in status">
          <div
            class="question-number"
            v-if="i > 0"
            :class="{ finish: status[i] == 1, warning: status[i] == 2 }"
            @click="toDetail(i)"
          >
            {{ i }}
          </div>
        </div>
      </div>
    </el-scrollbar>
  </div>
</template>
<script setup>
const props = defineProps({
  questionStatus: {
    type: Array,
    default: [],
  },
});
const emit = defineEmits(["toDetail"]);
const status = props.questionStatus;
// console.log(status);
function toDetail(i) {
  emit("toDetail", i);
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
