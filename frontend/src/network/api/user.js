import axios from "../index";

export function studentLogin(account, password, identity) {
  return axios.post("/login", {
    account,
    password,
    identity,
  });
}

export function getExerciseQuestions(questionNum = 100) {
  return axios.post("/exercise/random", {
    questionNum,
  });
}

export function submitExercise(questionAnswers) {
  return axios.post("submit/exercise");
}

export function beforeunload() {
  return axios.post("submit/exit");
}
