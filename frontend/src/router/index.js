import { createRouter, createWebHistory } from "vue-router";

const routes = [
  { path: "/", redirect: "/login" },
  { path: "/login", component: () => import("@/views/login/Login.vue") },
  {
    path: "/student",
    component: () => import("@/views/student/Contest.vue"),
    children: [
      {
        path: "category",
        component: () => import("@/views/student/child/Category.vue"),
      },
      {
        path: "exercise",
        component: () => import("@/views/student/child/Exercise.vue"),
      },
    ],
  },
  {
    path: "/exercise",
    component: () => import("@/views/exercise/SelfExercise.vue"),
  },
  { path: "/teacher", component: () => import("@/views/teacher/Teacher.vue") },
  { path: "/manager", component: () => import("@/views/manager/Manager.vue") },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
