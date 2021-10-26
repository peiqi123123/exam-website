# 错误

身份认证相关错误

```tsx
interface ErrorInfo {
    status: Number; // 401 未登录 403权限不够
    message: string;
}
```





# 登录验证

登录

###   post `api/login`

Request

```ts
interface login {
    username: String;
    password: String;
    loginMode: String, // student teacher manager
}
```

Response `201`

```ts
interface login {
	status: Number;
    user: User,
    token: String; // 用于后序操作验证身份（JWT）
}
```

Response `400`

```ts
interface login {
	status: Number;
    msg: String; // 错误信息（账号不存在，密码错误等）
}
```

Response `401`

```ts
interface login {
	status: Number;
    msg: String; // 登录过期，重新登陆
}
```



# 随机组卷

### get `api/exercise/random`

Request

```jsx
interface exerciseRandom {
    size: Number  //题目数量（默认···道）
}  
```

Response `200`

```jsx
interface exerciseRandom {
    status: Number;
    size: NUmber; // 题目数量
    examTime: String|Number // 考试时长
    totalPoints: String|Number // 总分
    passingScore: String|Number // 及格分数
    questions: {
        TFQuestions: Array // 判断题题目
        ChoiceQuestions: Array // 选择题题目
    }
    answers: {
        TFAnswers: Array //判断题答案
        ChoiceAnswers: Array // 选择题答案（单选）
    }
} 
```



# 智能组卷

暂时 不做

# 获取学生列表

### get `api/students/info`

Response `200`

```jsx
interface studentInfo {
    status: Number;
	user: User  // 学生的基本信息
    // 包括最近提交记录（练习时长，分数，练习类别），正确率分析（自主练习，赛事模拟）
}
```

# 获取教师列表

### get `api/teachers/info`

同上



# 获取学生个人信息

### get `api/student/info/{id}`

Request

```jsx
interface studentInfo {
	id: String; // 学生ID
}
```

Response `200`

```jsx
interface studentInfo {
    status: Number;
	user: User // 学生的基本信息
    // 包括最近提交记录（练习时长，分数，练习类别），正确率分析（自主练习，赛事模拟）
}
```

# 教师发布任务

暂时不做

# 重置学生密码

### post `api/student/reset`

Request

```jsx
interface studentInfo {
	id: String; // 学生ID
}
```

Response `200`

```jsx
interface studentInfo {
	status: Number;
}
```

# 重置老师密码

### post `api/teacher/reset`

同上

# 增加教师账号

### post `api/teacher/add`

Response `201`

```jsx
interface studentInfo {
	status: Number;
    user: User;
}
```

# 增加学生账号

### post `api/student/add`

同上

