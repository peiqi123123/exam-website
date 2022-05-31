<template>
  <div class="list">
    <ExamListItem
      v-for="item in examList"
      :item="item"
      @click="toReview(item)"
    ></ExamListItem>
    <!--     分页 -->
    <div>
      <el-pagination
          v-model:page-count="pages"
          v-model:current-page="currentPage"
          layout="prev, pager, next"
          @current-change="handleCurrentChange"
      >
      </el-pagination>
    </div>
  </div>
</template>
<script setup>
import { ref, reactive ,watch } from "vue";
import { useRouter } from "vue-router";
import ExamListItem from "@/components/exam/ExamListItem.vue";
import { getExamList } from "@/network/api/user";

let pageSize = 10
let currentPage = 1
let pages = 10
let counts = 0

const examList = ref([]);
//随机生成该考生的若干考试信息
async function init() {
  const res = await getExamList(pageSize,currentPage);
  // console.log("ExamList res: ", res);
  examList.value = res.data.allExamRecording.records
  pages = res.data.allExamRecording.pages
  counts = res.data.allExamRecording.total
  console.log(pages+"!!!!!!!!!!!!!!!")
  return res.data
}
const result = init();
/*
const dataList = result.then(resolve=>{
  console.log("这个是pro的返回结果",resolve);
  const data = reactive({
    pageTotal: resolve.length,//数据总条数
    currentPage: 1,//当前开始页
  })
  //页面变化时的处理函数
  const handleCurrentChange = (cpage)=>{
    const start = (cpage-1)*8
    const end =  cpage*8
    examList.value = resolve.slice(start,end)
    console.log(examList.value)
    // this.$emit('handleCurrentChange',cpage,examList.value,dataArr)
  }
  return {data,handleCurrentChange}
})
*/
async function handleCurrentChange(val){
  console.log("当前页："+val)
  currentPage = val
  const res = await getExamList(pageSize,currentPage);
  // console.log("ExamList res: ", res);
  examList.value = res.data.allExamRecording.records
}

const Router = useRouter();
async function toReview(exam) {
  const examRecordingId = exam.examRecordingId;
  Router.push(`/score/${examRecordingId}`);
}
components: {
  ExamListItem
}
</script>
<style lang="less" scoped>



</style>
