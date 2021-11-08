import Mock, { Random } from "mockjs";

Mock.setup({
  timeout: "400-1000",
});

Mock.mock(/api\/login\/student/, "post", {
  code: 201,
  name: "@first @last",
});

// 随机生成考试题目
const TFQuestions = [];
const choiceQuestions = [];
for (let i = 0; i < 10; i++) {
  const question = {
    questionId: Random.integer(),
    questionContext: Random.string("lower", 30, 100),
  };
  TFQuestions.push(question);
}
for (let i = 0; i < 40; i++) {
  const question = {
    questionId: Random.integer(),
    questionContext: Random.string("lower", 50, 100),
    optionA: Random.string("lower", 5, 10),
    optionB: Random.string("lower", 5, 10),
    optionC: Random.string("lower", 5, 10),
    optionD: Random.string("lower", 5, 10),
    answer: Random.string("ABCD", 1),
  };
  choiceQuestions.push(question);
}

Mock.mock(/api\/exercise/, {
  code: 200,
  size: 50,
  examTime: 120,
  totalPoints: 1000,
  passingScore: 600,
  questions: {
    // 判断题
    TFQuestions,
    // 选择题 单选题
    choiceQuestions,
    //
  },
});

Mock.mock(/api\/submit\/exercise/, {
  code: 201,
  msg: "提交成功",
});

Mock.mock(/api\/submit\/exit/, {
  code: 201,
  msg: "收到请求",
});
