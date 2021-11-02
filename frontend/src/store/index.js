import { createStore } from "vuex";

const store = createStore({
  state() {
    return {
      questionAnswers: [],
      questionStatus: [],
      currentIndex: 1,
    };
  },
  getters: {
    getQuestionAnswers(state) {
      return state.questionAnswer;
    },
    getQuestionStatus(state) {
      return state.questionStatus;
    },
    getCurrentIndex(state) {
      return state.currentIndex;
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
    setCurrentIndex(state, payload) {
      state.currentIndex = payload;
    },
    setCurrentIndexBefore(state) {
      if (state.currentIndex <= 1) return;
      state.currentIndex -= 1;
    },
    setCurrentIndexAfter(state) {
      if (state.currentIndex >= this.state.questionAnswers.length) return;
      state.currentIndex += 1;
    },
  },
});

export default store;
