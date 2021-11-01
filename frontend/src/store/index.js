import { createStore } from "vuex";

const store = createStore({
  state() {
    return {
      questionAnswers: [],
      questionStatus: [],
    };
  },
  getters: {
    getQuestionAnswers(state) {
      return state.questionAnswer;
    },
    getQuestionStatus(state) {
      return state.questionStatus;
    },
  },
  mutations: {
    setQuestionAnswers(state, payload) {
      state.questionAnswer = payload;
    },
    setQuestionStatus(state, payload) {
      state.questionStatus = payload;
    },
    setOneAnswer(state, payload) {
      state.questionAnswer[payload.index] = payload.value;
    },
    setOneStatus(state, payload) {
      state.questionStatus[payload.index] = payload.value;
    },
  },
});

export default store;
