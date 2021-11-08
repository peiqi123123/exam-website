import { createStore } from "vuex";

const store = createStore({
  state() {
    return {
      questionAnswers: [],
      questionStatus: [],
      currentIndex: 1,
      hasAnswer: 0,
    };
  },
  getters: {
    getQuestionAnswers(state) {
      return state.questionAnswers;
    },
    getQuestionStatus(state) {
      return state.questionStatus;
    },
    getCurrentIndex(state) {
      return state.currentIndex;
    },
    getHasAnswer(state) {
      return state.hasAnswer;
    },
  },
  mutations: {
    setQuestionAnswers(state, payload) {
      state.questionAnswers = payload;
    },
    setQuestionStatus(state, payload) {
      state.questionStatus = payload;
    },
    setOneAnswer(state, payload) {
      if (state.questionAnswers[payload.index].answer === -1) state.hasAnswer++;
      state.questionAnswers[payload.index].answer = payload.value;
      state.questionAnswers[payload.index].questionId = payload.questionId;
      console.log(state.questionAnswers);
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
      if (state.currentIndex >= state.questionAnswers.length - 1) return;
      state.currentIndex += 1;
    },
    clear(state) {
      state.currentIndex = 1;
      state.hasAnswer = 0;
    },
  },
});

export default store;