<template>
  <div class="info tag" @mouseover="mouseover" @mouseout="mouseout">
    <div class="avator">个人信息</div>
    <div class="float" v-show="flag === 1">
      <el-descriptions class="margin-top" :column="1">
        <el-descriptions-item label="姓名">黄京旺</el-descriptions-item>
        <el-descriptions-item label="ID">18100000000</el-descriptions-item>
        <el-descriptions-item label="--">最近一次练习 --</el-descriptions-item>
        <el-descriptions-item label="练习类别">自主练习</el-descriptions-item>
        <el-descriptions-item label="分数">
          <el-tag size="medium">90</el-tag>
        </el-descriptions-item>
        <el-descriptions-item label="练习时长">136分钟</el-descriptions-item>
      </el-descriptions>
    </div>
  </div>
  <div class="logout tag" @click="logout">退出</div>
</template>
<script setup>
import { ref } from "vue";
import { ElMessageBox } from "element-plus";
import { useRouter } from "vue-router";
const Router = useRouter();
function logout() {
  ElMessageBox.confirm("你确定要退出么?", {
    confirmButtonText: "确定",
    cancelButtonText: "取消",
    type: "warning",
  })
    .then(() => {
      Router.push("/login");
    })
    .catch(() => {});
}
// 标志位 判断是否显示信息表
const flag = ref(0);
function mouseover() {
  flag.value = 1;
}
function mouseout() {
  flag.value = 0;
}
</script>
<style lang="less" scoped>
.tag {
  position: absolute;
  top: 10px;
  cursor: pointer;
  .float {
    position: absolute;
    left: -40px;
    top: 30px;
    width: 200px;
  }
}
.info {
  right: 50px;
  height: 40px;
}
.logout {
  right: 0px;
  &:hover {
    color: #e7dfcf;
  }
}
</style>
