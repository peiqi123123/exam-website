import moment from "moment";
function getString(t) {
  t = parseInt(t);
  let m = "";
  if (t > 0) {
    if (t < 10) {
      m = "0" + t;
    } else {
      m = t + "";
    }
  } else {
    m = "00";
  }
  return m;
}

// 转化时间格式
export function format(t) {
  console.log(t);
  if (t < 60000) {
    return (t % 60000) / 1000 + "秒";
  } else if (t >= 60000 && t < 3600000) {
    return (
      getString((t % 3600000) / 60000) + ":" + getString((t % 60000) / 1000)
    );
  } else {
    return (
      getString(t / 3600000) +
      ":" +
      getString((t % 3600000) / 60000) +
      ":" +
      getString((t % 60000) / 1000)
    );
  }
}

export function timestamp(t) {
  return moment(t).format("MMMM Do YYYY, hh:mm:ss a");
}
