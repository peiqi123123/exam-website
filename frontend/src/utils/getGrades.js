export function getGrades(questions) {
  const size = questions.length;
  let correctSize = 0;
  let score = 0;
  let totalScore = 0;
  questions.forEach((item) => {
    if (item.studentAnswer === item.answer) {
      item.status = 1;
      correctSize++;
      score += item.score;
    } else item.status = 3;
    totalScore += item.score;
  });
  score = `${score} / ${totalScore} 分`;
  return {
    correctSize,
    errorSize: size - correctSize,
    score,
  };
}
