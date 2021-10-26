<template>
  <div
    class="card"
    :style="{
      width: props.width,
      backgroundColor: props.backgroundColor,
      color: props.color,
    }"
  >
    <slot name="text"></slot>
  </div>
</template>
<script setup>
const props = defineProps({
  width: {
    type: String,
    default: "250px",
  },
  color: {
    type: String,
    default: "#000",
  },
  backgroundColor: {
    type: String,
    default: "#e7dfcf",
  },
});
</script>
<style lang="less" scoped>
.card {
  font-size: 20px;
  height: 150px;
  margin: 30px;
  line-height: 150px;
  border-radius: 40px;
  text-align: center;
  cursor: pointer;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);

  &:hover {
    box-shadow: 3px 3px 3px rgba(0, 0, 0, 0.19);
    transition: all 0.5s;
  }
}
</style>
