# 错误

身份认证相关错误

```
interface ErrorInfo {
    code: Number; // 401 未登录 403权限不够
    message: string;
}
```

# 登录验证

登录

### post `api/login`      

Request

username -->account

loginMode-->identity

```
interface login {
    username: String;
    password: String;
    loginMode: String, // student teacher manager
}
```

Response `201`

```
interface login {
	code: Number;
    user: User,
    token: String; // 用于后序操作验证身份（JWT）
}
```

Response `400`

```
interface login {
	code: Number;
    msg: String; // 错误信息（账号不存在，密码错误等）
}
```

Response `401`

```
interface login {
	code: Number;
    msg: String; // 登录过期，重新登陆
}
```

# 随机组卷

### get `api/exercise/random`

Request

```
interface exerciseRandom {
    size: Number  //题目数量（默认···道）
}  
```

Response `200`

```
interface exerciseRandom {
    status: Number;
    size: NUmber; // 题目数量
    questions: {
        TFQuestions: Array // 判断题题目（暂时没有）
        ChoiceQuestions: Array<Question> {
        		int：questionId 题号
        		string：questionContent 题目内容
        		String:optionA  选项A的内容
        		String：optionB 选项B的内容
        		String: optionC 选项C的内容
        		String: optionC 选项D的内容
        		String: optionC 选项E的内容
        		String: optionC 选项F的内容
        		String: optionC 选项G的内容
        		int 单选和多选  单选是0 多选是1
        		String:Answer 题目答案
        		String:Analyse 题目解析
        }// 选择题题目
        examRecordingId:String 这次考试的主键 
    }
  
} 
```

# 智能组卷

暂时 不做



## 提交卷子

### post api/exercise/submit

Request

```
 interface exerciseSubmit{
 		totleTime:int 学生用时，单位：分钟
 		examRecording:String 考试的id
         List<AnsParam> ans;
         其中 AnsParam中包含两个属性：
         {
             questionId:String 题目主键
             stuAns:String  学生的答案
         }
  
 }

```

Response

~~~
interface {
   code:201;
    msg:success;

    
}

~~~



# 获取学生列表

### get `api/students/info`

Response `200`

```
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

```
interface studentInfo {
	id: String; // 学生ID
}
```

Response `200`

```
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

```
interface studentInfo {
	id: String; // 学生ID
}
```

Response `200`

```
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

```
interface studentInfo {
	status: Number;
    user: User;
}
```

# 增加学生账号

### post `api/student/add`

同上