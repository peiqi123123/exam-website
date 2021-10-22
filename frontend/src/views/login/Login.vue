<template>
  <div class="login">
    <div class="box">
      <div class="login_mode">
        <el-select v-model="loginMode" size="small">
          <el-option
            v-for="item in config.loginMode"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          >
          </el-option>
        </el-select>
      </div>
      <el-form
        label-width="100px"
        :model="loginForm"
        ref="formRef"
        :rules="rules"
      >
        <el-form-item label="账号" prop="username">
          <el-input v-model="loginForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="loginForm.password"></el-input>
        </el-form-item>
        <el-form-item class="btns">
          <el-button type="primary" @click="submitForm" :loading="isLoading"
            >提交</el-button
          >
          <el-button @click="resetForm">重置</el-button>
        </el-form-item>
      </el-form>
      <el-button type="text" class="forget">忘记密码</el-button>
    </div>
  </div>
</template>

<script setup>
import { ref, inject } from "vue";
import { useRouter } from "vue-router";
//导入登录方式相关配置
import config from "@/config";
//导入登录相关请求
import { studentLogin } from "@/network/api/user";
//表单数据
const loginForm = ref({
  username: "",
  password: "",
});
//选择登录方式
const loginMode = ref("student");
//表单规则
const rules = ref({
  username: [
    {
      required: true,
      message: "请输入账号",
      trigger: "blur",
    },
  ],
  password: [
    {
      required: true,
      message: "请输入密码",
      trigger: "blur",
    },
  ],
});
//获取表单实例
const formRef = ref();
//获取全局消息组件
const message = inject("message");
const isLoading = ref(false);
//提交表单
const Router = useRouter();
function submitForm() {
  formRef.value.validate(async (valid) => {
    if (valid) {
      isLoading.value = true;
      const res = await studentLogin(
        loginForm.value.username,
        loginForm.value.username
      );
      console.log(res);
      if (res.status === 201) {
        isLoading.value = false;
        message.success("登录成功");
        Router.push("/" + loginMode.value);
      }
    } else {
      message.error("登陆失败");
    }
  });
}
//重置表单
function resetForm() {
  formRef.value.resetFields();
}
</script>
<style lang="less" scoped>
.login {
  width: 60%;
  height: 35%;
  margin: 0 auto;
  min-width: 500px;
  .box {
    width: 480px;
    height: 300px;
    margin: 15% auto;
    position: relative;
    border-radius: 20px;
    background-color: #fff;
    box-shadow: 5px 0px 10px rgb(66 75 174 / 10%);
    .login_mode {
      position: absolute;
      width: 93px;
      right: 10px;
      top: 10px;
    }
    .el-form {
      position: absolute;
      padding: 0;
      margin: 60px;
      .btns {
        margin-top: 60px;
      }
    }
    .forget {
      position: absolute;
      right: 15px;
      bottom: 10px;
      color: #909399;
      // #909399; #e6e6e6
      &:active {
        color: #e6e6e6;
      }
    }
  }
}
</style>
