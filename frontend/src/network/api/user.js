import axios from "../index";

export function studentLogin(username, password, loginMode) {
  return axios.post("/login/student", {
    username,
    password,
    loginMode,
  });
}

export function getExerciseQuestions() {
  return axios.get("/exercise");
}
