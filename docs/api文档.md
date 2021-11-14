# 错误

身份认证相关错误

```tsx
interface ErrorInfo {
    code: Number; // 401 未登录 403权限不够
    message: String;
}
```

# 登录验证

登录

### post `api/login`      

Request

```tsx
interface login {
    account: String;
    password: String;
    identity: String, // student teacher manager
}
```

Response `201`

```tsx
interface login {
	code: 201;
    user: User,
    token: String; // 用于后序操作验证身份（JWT）
}
```

Response `400`

```tsx
interface login {
	code: 400;
    msg: String; // 错误信息（账号不存在，密码错误等）
}
```

Response `401`

```tsx
interface login {
	code: 401;
    msg: String; // 登录过期，重新登陆
}
```

# 随机组卷

### get `api/exercise/random`

Request

```tsx
interface exerciseRandom {
    size: Number  //题目数量（默认···道）
}  
```

Response `200`

```tsx
interface exerciseRandom {
	code: 200,
    data: {
        size: Nubmer // 题目数量
        examTime: String, // 考试用时
        totalPoints: Number // 总分
        // 判断题
        TFQuestions: Array<TFQuestion>
        // 选择题 单选题
        choiceQuestions: Array<choiceQuestion>
        // 考试ID
        examId: String,
    }
} 
interface TFQuestion {
    questionId: String, // 题目ID
    questionContent: String // 题目内容
    answer: Number // 题目答案
    score: Number // 题目分值
}
interface choiceQuestion {
    questionId: String, // 题目ID
    questionContent: String // 题目内容
    answer: Number // 题目答案
    // 选择题选项
    optionA: String,  
    optionB: String, 
    optionC: String, 
    optionD: String, 
    score: Number // 题目分值
}
```

# 智能组卷

暂时 不做



## 提交卷子

### post api/exercise/submit

Request

```tsx
 interface exerciseSubmit{
 		totleTime: String // 学生用时，单位：分钟
 		examId: String // 考试的id
        questionAnswers: Array<answer> // 学生答案数组
 }
interface answer {
    questionId: String // 题目ID
    answer: Number || String // 学生答案
}

```

Response

~~~tsx
interface {
   code: 201
   msg: String
}

~~~



# 获取学生列表

### get `api/students/info`

Response `200`

```tsx
interface studentInfo {
    code: Number;
	user: User  // 学生的基本信息
    // 包括最近提交记录（练习时长，分数，练习类别），正确率分析（自主练习，赛事模拟）
}
interface User {
    
}
```

# 获取教师列表

### get `api/teachers/info`

同上

# 获取学生个人信息

### get `api/student/info/{id}`

Request

```tsx
interface studentInfo {
	id: String; // 学生ID
}
```

Response `200`

```tsx
interface studentInfo {
    code: Number;
	user: User // 学生的基本信息
    // 包括最近提交记录（练习时长，分数，练习类别），正确率分析（自主练习，赛事模拟）
}
```

# 教师发布任务

暂时不做

# 重置学生密码

### post `api/student/reset`

Request

```tsx
interface studentInfo {
	id: String; // 学生ID
}
```

Response `200`

```tsx
interface studentInfo {
	code: 200;
}
```

# 重置老师密码

### post `api/teacher/reset`

同上

# 增加教师账号

### post `api/teacher/add`

Response `201`

```tsx
interface studentInfo {
	status: Number;
    user: User;
}
```

# 增加学生账号

###  post `api/student/add`

同上

# 考试提交

### post ```api/exercise/submit```

Request 

```tsx
interface exercise {
    examId: String, // 考试ID
	totleTime: int, // 考试总用时（单位：秒）
    questionAnswers: Array<answer> // 学生答案数组
}
interface answer {
	questionId: String,
    answer: String,
}
```

Response

```tsx
interface exercise {
    code: 201,
    msg: String, // 
}
```

# 获取考试后卷子信息

### GET ```api/info/exercise{id}```

Request

```tsx
id: String // 卷子ID
```

Response

```tsx
interface examInfo {
    code: 200,
    data: {
        size: Nubmer // 题目数量
        examTime: String, // 考试用时
        totalPoints: Number // 总分
        // 判断题
        TFQuestions: Array<TFQuestion>
        // 选择题 单选题
        choiceQuestions: Array<choiceQuestion>
        // 考试ID
        examId: String,
        questionAnswers: Array<answer>
    }
}
interface answer {
    questionId: String // 题目ID
    answer: Number || String // 学生答案
}
interface TFQuestion {
    questionId: String, // 题目ID
    questionContent: String // 题目内容
    answer: Number // 题目答案 0 1
    score: Number // 题目分值
}
interface choiceQuestion {
    questionId: String, // 题目ID
    questionContent: String // 题目内容
    answer: Number // 题目答案 A B C D
    // 选择题选项
    optionA: String,  
    optionB: String, 
    optionC: String, 
    optionD: String, 
    score: Number // 题目分值
}
```



# 考试中途退出 

Request

```tsx
interface exercise {
    
}
```



