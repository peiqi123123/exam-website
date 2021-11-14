export function getGrades(data) {
  const questionAnswers = data.questionAnswers;
  const TFQuestions = data.TFQuestions || [];
  const choiceQuestions = data.choiceQuestions || [];
  // console.log("questionAnswers===>", questionAnswers);
  // console.log("TFQuestions===>", TFQuestions);
  // console.log("choiceQuestions===>", choiceQuestions);
  const status = [];
  const answers = [];
  const trues = [];
  TFQuestions.forEach((TF, i) => {
    const id = TF.questionId;
    const answer = TF.answer;
    searchAnswer(id, answer, i + 1);
    trues[i + 1] = answer;
  });
  choiceQuestions.forEach((choice, i) => {
    const id = choice.questionId;
    const answer = choice.answer;
    searchAnswer(id, answer, TFQuestions.length + i + 1);
    trues[TFQuestions.length + i + 1] = answer;
  });
  // console.log("status====>", status);
  // console.log("answers====>", answers);
  // console.log("trues====>", trues);
  function searchAnswer(id, answer, i) {
    for (const student of questionAnswers) {
      if (student.questionId === id) {
        answers[i] = {
          questionId: id,
          answer: student.answer,
        };
        if (answer === student.answer) status[i] = 1;
        else status[i] = 3;
      }
    }
  }
  return {
    status,
    answers,
  };
}
