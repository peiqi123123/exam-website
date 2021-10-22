const config = {
  //登录方式，身份
  loginMode: [
    {
      label: "学生",
      value: "student",
    },
    {
      label: "教师",
      value: "teacher",
    },
    {
      label: "管理员",
      value: "manager",
    },
  ],
  dev: {
    baseURL: "http://api",
  },
};

export default config;
