<template>
  <div class="list">
    <ExamListItem
      v-for="item in examList"
      :item="item"
      @click="toReview(item)"
    ></ExamListItem>
  </div>
</template>
<script setup>
import { ref, nextTick } from "vue";
import { useRouter } from "vue-router";
import ExamListItem from "@/components/exam/ExamListItem.vue";
import { getExamList } from "@/network/api/user";

const examList = ref([]);
function init() {
  nextTick(async () => {
    const res = await getExamList();
    console.log("ExamList res: ", res);
    examList.value = res.data;
  });
}
init();
const Router = useRouter();
async function toReview(exam) {
  const examRecordingId = exam.examRecordingId;
  Router.push(`/score/${examRecordingId}`);
}
// console.log("res: ", res);
</script>
<style lang="less" scoped></style>
