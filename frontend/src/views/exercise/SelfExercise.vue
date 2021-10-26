<template>
  <div class="self_exercise">
    <el-container>
      <el-header><ExamTabBar></ExamTabBar></el-header>
      <el-container>
        <el-aside width="30%"> <ExamSideBar></ExamSideBar> </el-aside>
        <el-main><ExamQues></ExamQues></el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script setup>
import ExamTabBar from "../../components/exam/ExamTabBar.vue";
import ExamQues from "../../components/exam/ExamQues.vue";
import ExamSideBar from "../../components/exam/ExamSideBar.vue";
</script>
<style lang="less" scoped>
.self_exercise {
  min-width: 1200px;
  position: relative;
}
</style>
