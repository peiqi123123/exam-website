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
  {
    path: "/score/:id",
    component: () => import("@/views/exercise/Score.vue"),
  },
  {
    path: "/review",
    component: () => import("@/views/exercise/Review.vue"),
  },
  { path: "/teacher", component: () => import("@/views/teacher/Teacher.vue") },
  { path: "/manager", component: () => import("@/views/manager/Manager.vue") },
  { path: "/test", component: () => import("@/views/Test.vue") },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

router.beforeEach((to, from, next) => {
  if (from.path === "/student/exercise") {
    if (to.path === "/exercise") {
      return next();
    }
  } else {
    if (to.path === "/exercise") {
      next("/login");
    }
  }
  next();
});

export default router;
