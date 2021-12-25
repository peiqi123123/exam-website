<template>
  <div class="test_records">
    <div class="exam-list">
      <ExamList></ExamList>
    </div>
    <div class="aside">
      <Category></Category>
    </div>
  </div>
</template>
<script setup>
import Category from "./Category.vue";
import ExamList from "./ExamList.vue";
</script>
<style lang="less" scoped>
.test_records {
  width: 100%;
  max-width: 960px;
  margin: 4.5rem auto 0;
  border-radius: 2px;
  position: relative;
  .exam-list {
    background-color: #fff;
    width: 600px;
    margin-right: 22rem;
    //
    min-height: 300px;
  }
  .aside {
    // background-color: #fff;
    position: absolute;
    top: 0;
    right: 0;
    width: 21rem;
    height: 500px;
  }
}
</style>
