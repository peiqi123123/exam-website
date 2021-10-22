import Mock from "mockjs";

Mock.mock(/api\/login\/student/, "post", {
  status: 201,
  name: "@first @last",
});
