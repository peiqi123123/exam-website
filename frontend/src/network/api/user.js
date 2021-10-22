import axios from "../index";

export function studentLogin(username, password) {
  return axios.post("/login/student", {
    username,
    password,
  });
}
