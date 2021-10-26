import Mock, { Random } from "mockjs";

Mock.mock(/api\/login\/student/, "post", {
  status: 201,
  name: "@first @last",
});

// 随机生成考试题目
const TFQuestions = [];
const ChoiceQuestions = [];
for (let i = 0; i < 10; i++) {
  TFQuestions.push(Random.string("lower", 30, 100));
}
for (let i = 0; i < 40; i++) {
  ChoiceQuestions.push(Random.string("lower", 30, 100));
}

const TFAnswers = [];
const ChoiceAnswers = [];
for (let i = 0; i < 10; i++) {
  TFAnswers.push(Random.boolean());
}
for (let i = 0; i < 40; i++) {
  ChoiceAnswers.push(Random.string("ABCD", 1));
}

Mock.mock(/api\/exercise/, {
  status: 200,
  size: 50,
  examTime: 120,
  totalPoints: 1000,
  passingScore: 600,
  questions: {
    // 判断题
    TFQuestions,
    // 选择题 单选题
    ChoiceQuestions,
    //
  },
  answers: {
    TFAnswers,
    ChoiceAnswers,
  },
});
