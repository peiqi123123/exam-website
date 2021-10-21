import { createRouter, createWebHistory } from "vue-router";

const routes = [
  { path: "/", redirect: "/login" },
  { path: "/login", component: () => import("../views/login/Login.vue") },
  { path: "/student", component: () => import("../views/student/Info.vue") },
  { path: "/teacher", component: () => import("../views/teacher/Teacher.vue") },
  { path: "/manager", component: () => import("../views/manager/Manager.vue") },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
