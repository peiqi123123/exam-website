<template>
  <div class="category">
    <div class="contest_category">
      <Card
        v-for="(item, i) in contestCategory"
        :key="i + 'contest-category'"
        class="category-item"
        @click="handleClick(i)"
      >
        <template #text>{{ item }}</template>
      </Card>
    </div>
    <!-- 选择框 -->
    <div class="network_dialog">
      <el-dialog v-model="dialogVisible" title="请选择练习方式" width="30%">
        <Card
          shadow="hover"
          v-for="(item, i) in contestType"
          :key="i + 'contest-type'"
          @click="selectNetworkType(i)"
          width="200px"
          backgroundColor="#517c63"
          color="#fff"
        >
          <template #text>{{ item }}</template>
        </Card>
      </el-dialog>
    </div>
  </div>
</template>
<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
// 导入练习类别数据
import config from "@/config";
import Card from "@/components/Card.vue";
// 练习类别
const contestCategory = config.contestCategory;
// 试卷类型
const contestType = config.contestType;
const dialogVisible = ref(false);
function handleClick(index) {
  if (index === 0) dialogVisible.value = true;
}
// 处理网络系统管理的两种练习方式 -- 自主练习 -- 赛事模拟
const Router = useRouter();
function selectNetworkType(type) {
  console.log(type);
  if (type === 0) {
    // 进入自主练习模块
    Router.push("/student/exercise");
  }
}
</script>
<style lang="less" scoped>
.category {
  .network_dialog {
    :deep(.el-dialog__body) {
      display: flex;
      justify-content: center;
      .is-hover-shadow {
        margin: 10px 20px 10px;
        cursor: pointer;
      }
    }
  }
  .contest_category {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    .category-item {
      margin-right: 20px;
      cursor: pointer;
    }
  }
}
</style>
