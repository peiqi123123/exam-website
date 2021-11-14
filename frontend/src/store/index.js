import { createStore } from "vuex";

const store = createStore({
  state() {
    return {
      questionAnswers: [],
      questionStatus: [],
      currentIndex: 1,
      hasAnswer: 0,
      endTime: 0,
      // 卷子回顾
      // 当前题目正确与否
      currentBoolean: null,
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
    getCurrentBoolean(state) {
      return state.currentBoolean;
    },
  },
  mutations: {
    setEndTime(state, endTime) {
      state.endTime = endTime;
    },
    setHasAnswer(state, hasAnswer) {
      state.hasAnswer = hasAnswer;
    },
    setQuestionAnswers(state, questionAnswers) {
      state.questionAnswers = questionAnswers;
      // console.log(state.questionAnswers);
    },
    setQuestionStatus(state, questionStatus) {
      state.questionStatus = questionStatus;
    },
    setOneAnswer(state, payload) {
      if (
        state.questionAnswers[payload.index].answer === null &&
        state.hasAnswer < state.questionAnswers.length
      )
        state.hasAnswer++;
      state.questionAnswers[payload.index].answer = payload.value;
      state.questionAnswers[payload.index].questionId = payload.questionId;
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
    setCurrentBoolean(state, currentBoolean) {
      state.currentBoolean = currentBoolean;
      console.log("currentBoolean", state.currentBoolean);
    },
    clear(state) {
      state.currentIndex = 1;
      state.hasAnswer = 0;
      state.questionStatus = [];
    },
  },
});

export default store;
