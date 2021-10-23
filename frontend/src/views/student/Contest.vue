<template>
  <div class="contest">
    <div class="info">个人信息</div>
    <div class="contest_category">
      <el-card
        shadow="hover"
        v-for="(item, i) in contestCategory"
        :key="i + 'contest-category'"
        class="category-item"
        @click="handleClick(i)"
      >
        {{ item }}
      </el-card>
    </div>
    <!-- 选择框 -->
    <div class="network_dialog">
      <el-dialog v-model="dialogVisible" title="请选择练习方式" width="30%">
        <el-card
          shadow="hover"
          v-for="(item, i) in contestType"
          :key="i + 'contest-type'"
          >{{ item }}</el-card
        >
      </el-dialog>
    </div>
  </div>
</template>
<script setup>
import { ref } from "vue";
// 导入练习类别数据
import config from "@/config";
// 练习类别
const contestCategory = config.contestCategory;
// 试卷类型
const contestType = config.contestType;
const dialogVisible = ref(false);
function handleClick(index) {
  if (index === 0) dialogVisible.value = true;
}
</script>
<style lang="less" scoped>
.contest {
  width: 70%;
  margin: 0 auto;
  position: relative;
  padding: 5%;
  min-width: 800px;
  .info {
    position: absolute;
    right: 10px;
    top: 10px;
  }
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
    .category-item {
      margin-right: 20px;
      cursor: pointer;
    }
  }
}
</style>
