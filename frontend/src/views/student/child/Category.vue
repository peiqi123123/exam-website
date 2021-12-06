<template>
  <div class="category">
    <el-card class="box-card" shadow="hover">
      <template #header>
        <div class="card-header">
          <span>网络系统管理</span>
        </div>
      </template>
      <div class="network">
        <div class="net_item exercise">
          <div class="slide">
            <div class="title">自主练习</div>
            <div class="extend">
              <div
                v-for="(item, i) in extend"
                @click="selectModule(i, item)"
                :key="item"
                class="extend_item"
              >
                {{ item }}
              </div>
            </div>
          </div>
        </div>
        <div class="net_item test">
          <div class="slide">赛事模拟</div>
        </div>
      </div>
    </el-card>
    <el-card class="box-card" shadow="hover">
      <template #header>
        <div class="card-header">
          <span>大数据</span>
        </div>
      </template>
    </el-card>
    <el-card class="box-card" shadow="hover">
      <template #header>
        <div class="card-header">
          <span>云计算</span>
        </div>
      </template>
    </el-card>

    <el-dialog v-model="dialogVisible" title="自主练习" width="30%">
      <span>{{ `是否进行${module}？` }}</span>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="toExercise">确定</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>
<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
const extend = ["随机组卷", "智能组卷", "针对训练", "错题专项"];
const dialogVisible = ref(false);
// 自主练习类别
const module = ref("");
let currentIndex = 0;
function selectModule(i, item) {
  // console.log(i);
  // 随机组卷
  dialogVisible.value = true;
  module.value = item;
  currentIndex = i;
}
const router = useRouter();
function toExercise() {
  if (currentIndex === 0) {
    console.log("currentIndex: ", currentIndex);
    router.push("/exercise");
  }
  dialogVisible.value = false;
}
</script>
<style lang="less" scoped>
.category {
  .box-card {
    margin: 0 0 3rem;
    cursor: pointer;
  }
  .network {
    font-size: 20px;
    .net_item {
      height: 6rem;
      color: #fff;
      margin-bottom: 20px;
      position: relative;
    }
    .exercise {
      overflow: hidden;
      background: linear-gradient(to right, #25d49e, #29c89c);
      .slide {
        text-align: center;
        // transform: translateY(-6rem);
        &:hover {
          animation: marquee 0.3s linear;
          animation-fill-mode: forwards;
        }
        .title {
          height: 6rem;
          line-height: 6rem;
        }
        .extend {
          height: 6rem;
          line-height: 3rem;
          display: flex;
          flex-wrap: wrap;
          justify-content: center;
          align-items: center;
          & > div {
            width: 140px;
            height: 48px;
          }
          .extend_item:hover {
            color: rgb(145, 145, 145);
          }
        }
      }
    }
    .test {
      background: linear-gradient(to right, #88df24, #52aa1f);
      .slide {
        line-height: 6rem;
        text-align: center;
      }
    }
  }
}
@keyframes marquee {
  0% {
    transform: translateY(0);
  }
  100% {
    transform: translateY(-6rem);
  }
}
</style>
