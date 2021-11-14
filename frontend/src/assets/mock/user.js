import Mock, { Random } from "mockjs";

Mock.setup({
  timeout: "400-1000",
});

Mock.mock(/api\/login/, "post", {
  code: 201,
  name: "@first @last",
});

// 随机生成考试题目
const TFQuestions = [
  {
    questionId: "-46505886112954320",
    questionContent:
      "dzehbkteirmjbshxqliqdzkmlodesydcngjidmeikuqqrohmxfxfclmnxngmtthxgatldexurndvumgyrusyqtvzi",
    answer: 1,
  },
  {
    questionId: "-32377424962168800",
    questionContent:
      "kuchuchjoocqigbnrivdswmsxokrcqojmvohwrwbfiwdgudkqeadecycgvbxucrkmklcdwuvujucqir",
    answer: 1,
  },
  {
    questionId: "-20082709465895080",
    questionContent:
      "hrnmxfrjyxiewiyooeydmqflsqrbkiyelvgjuhsmglnrftsqpgiwqqpcfcbpaohsycl",
    answer: 0,
  },
  {
    questionId: "-3903035295930480",
    questionContent:
      "cudvumiugxwjsnkqqfjmsdwownmaqbhzudjbcjqnvpwbkgcjrpgepatgygwdihfqofgjjwzbwxhxgbjwpsurloygw",
    answer: 0,
  },
  {
    questionId: "-2398135318463840",
    questionContent:
      "dctijiugmmymjvnykbswgcsdbylspyhjfhkwujtgqsfwwzqugureyyutmhgpygvrkeozcnhtftlpnbbwluuehufyzpp",
    answer: 0,
  },
  {
    questionId: "-39987613343154240",
    questionContent: "rsmcedyjbqipnrheebrjtemreedqbthgjol",
    answer: 0,
  },
  {
    questionId: "-10267735969812320",
    questionContent:
      "pyqeojyvysiuwjqhwxgmhjscicthpbbetilboifjccocqclptcrzgzjhzxrqeadrinfqqcopkwbmiopjslwmbjkn",
    answer: 0,
  },
  {
    questionId: "28568493078299840",
    questionContent: "higmlpqyghsgueendxhvpuhppffqijikoeazfqrgouti",
    answer: 0,
  },
  {
    questionId: "-59731919238752320",
    questionContent:
      "edyjfywihuwbyeudcfrdrbesbglqkvdnkkwksweasphsrmdtjmgiucptxwnysk",
    answer: 0,
  },
  {
    questionId: "63135593522702440",
    questionContent: "sfdnikfcipvigrcsldwvjfdphmjhghymfqyumecxuyixymkqjvs",
    answer: 1,
  },
];
const choiceQuestions = [
  {
    questionId: "20337265820639560",
    questionContent:
      "joyvapbyjbvxzemfspcxnlvgmjrbdmeozbpnajlloltuwmgbmgemmijncxwmhldpwjdaeqgsgfayiouyv",
    optionA: "vvtoghuke",
    optionB: "lmmvan",
    optionC: "ecbqubm",
    optionD: "biqkkr",
    answer: "A",
  },
  {
    questionId: "-5490498138654040",
    questionContent:
      "ckunurxcpxknqebtfxgdhddfvcouufyhggpglvnpduychkjzrymoppakuxjnxornlgwyt",
    optionA: "qxvynph",
    optionB: "rdvojxpc",
    optionC: "tqmhbocq",
    optionD: "nlipxbppu",
    answer: "A",
  },
  {
    questionId: "-82913043165410240",
    questionContent:
      "yhwdajnwtcyjqwjvhuvfmxtdqctrlozuvsrbqcguvblnmtjbrxjdmisgycnhmkfgljhcvosnyryttkkkpp",
    optionA: "dwgbl",
    optionB: "lynbduyxl",
    optionC: "rzevhyyrp",
    optionD: "detmgj",
    answer: "A",
  },
  {
    questionId: "64824594325433240",
    questionContent:
      "mhvjzhiugoocnoohszdnlkbnscifqpvlyuqnfjtsskclqcicpitalacauql",
    optionA: "dlacyh",
    optionB: "jpcjbvjxm",
    optionC: "stmieuzlt",
    optionD: "ekvlkjwy",
    answer: "B",
  },
  {
    questionId: "78178223311573080",
    questionContent:
      "lxybyawtfbzibxuqnxumujqofxkanqhakjcdvemxxvtwourmgmltcubldzsrwjbfvjgfvdfoxluibqoivte",
    optionA: "doqyqe",
    optionB: "pyqfau",
    optionC: "yatbxh",
    optionD: "pqtegcans",
    answer: "A",
  },
  {
    questionId: "55800584023087480",
    questionContent:
      "elxwjgohbgqyvozckwpcbcpjiiyrovydjepbphzwgwxrvqwxrublebhurqulu",
    optionA: "iktmxtey",
    optionB: "bawrkvd",
    optionC: "dmujkgq",
    optionD: "pmgxemsp",
    answer: "C",
  },
  {
    questionId: "53099335697851720",
    questionContent:
      "yslefdnljkmzhvezyujzenddqtpvjhmmbwiccpzvorthauakhflmtydvrwzqvwnvoefotinwtkpdjkakpcdfbvvdbujjedduwqd",
    optionA: "dzgnxmfo",
    optionB: "bmrtpehqg",
    optionC: "uqywk",
    optionD: "mronerejeq",
    answer: "C",
  },
  {
    questionId: "-53387040487037840",
    questionContent: "krnlobleocaqhmopvmgrpthtthdepxcnblhtuloycpijiwglkxqnp",
    optionA: "ezvpdqduga",
    optionB: "nrzvx",
    optionC: "huedvdm",
    optionD: "esvxtl",
    answer: "B",
  },
  {
    questionId: "70681208838626280",
    questionContent:
      "sgkntrmobdkmvtwmdnqknyhbgdqbeeepxdcthrqlmsdqchudyuccnqnnuhfyqhalpvsqllsafdaxtynrxkprwsart",
    optionA: "bbcmle",
    optionB: "tteelxsn",
    optionC: "lyuuqq",
    optionD: "fzygt",
    answer: "B",
  },
  {
    questionId: "33377078757250720",
    questionContent:
      "hlftpbivwwmllibgweeemsjsnpbsibvdimpsdcovmkgztieqfssbimeogxbyocnsmssngem",
    optionA: "gljvpezo",
    optionB: "tfvqhbt",
    optionC: "uyigs",
    optionD: "vfclvk",
    answer: "A",
  },
  {
    questionId: "3743871891810400",
    questionContent:
      "ihlrmxwxfgjjtvxgxqfnozcvsqzogoqweecawyjnaptivnnklfumuzvoevdwgvexkcpjnmhlfcmkdyfzygbgqtndwsxqxdiufw",
    optionA: "cppgjyf",
    optionB: "ypzcakpki",
    optionC: "thnidwe",
    optionD: "cbygqyuz",
    answer: "B",
  },
  {
    questionId: "58263724823762880",
    questionContent:
      "pewicwirpalcklfrddwditperrcxydkxjtqkphmzcuwxyowfnlntxrnmmvtfcmqsf",
    optionA: "cicxqte",
    optionB: "ntfxvcp",
    optionC: "qbreergics",
    optionD: "wtantbj",
    answer: "B",
  },
  {
    questionId: "54446858995846400",
    questionContent:
      "cpsichuwwyoetpndirggiieujetfhxmmudbuyxxbksycyulwdmsngikikfyfitfpd",
    optionA: "ecocyegi",
    optionB: "hxffmwmg",
    optionC: "dtgcnd",
    optionD: "mwzusk",
    answer: "B",
  },
  {
    questionId: "80475482172267840",
    questionContent:
      "vmdffypbwsfytbfegrjcwncwkbetjonlphyrzyxkenhoctvskmxexiwyehtjfoupppczepmcmmmntyjglymjwofoqigjccennv",
    optionA: "ghpkauqid",
    optionB: "motwugbxj",
    optionC: "jftnpwmt",
    optionD: "mdgkrijv",
    answer: "C",
  },
  {
    questionId: "63342109317318760",
    questionContent: "ipwtqdvupcxxhqqdzrnnjinopzablhyzvjlsqbxgzefppzyhhboupr",
    optionA: "lcqnjjov",
    optionB: "evftrybgx",
    optionC: "mipcwcsmz",
    optionD: "jpjplidk",
    answer: "C",
  },
  {
    questionId: "34800198876482840",
    questionContent:
      "ravvffwvpunpdwostbfowkywkoemhlinkuuwzojejnmeekomhnxqtyvwxnw",
    optionA: "ugrmcowdd",
    optionB: "hwhtppnsuy",
    optionC: "qsrycqy",
    optionD: "lwqyrdib",
    answer: "A",
  },
  {
    questionId: "-27379117581953800",
    questionContent:
      "ywlazkfmhrnmfnsswnzsvruaevnzndlpbwhjezhsvfjfztpwmmhlcwkmmg",
    optionA: "lhszcqv",
    optionB: "jszggvbg",
    optionC: "zqxkqm",
    optionD: "ikoqfwizj",
    answer: "D",
  },
  {
    questionId: "26891178729235840",
    questionContent: "cjlyrjetlvyxbrzbqmxwkajbyrrjimetvvbpetsanzyxtrpcevgbq",
    optionA: "kvndpljlh",
    optionB: "hdnun",
    optionC: "raytdfnaqg",
    optionD: "zhfwwur",
    answer: "C",
  },
  {
    questionId: "68089056993488360",
    questionContent:
      "xanqcnkvxfervjdchvcvmlhveukkjyfwffmwmjrjeusyirmverjqrywtqhtnkekniouymuxmlbxyfnoekqiedghbfetovrhctlc",
    optionA: "mqcyp",
    optionB: "rfrfbk",
    optionC: "gcuows",
    optionD: "sevyzt",
    answer: "B",
  },
  {
    questionId: "33433971854586760",
    questionContent:
      "utqdwcxayjouunyicktsldufyuzfaqbluutqukvlhkcygdcyvqmhdmxffcvipmwhirkcmdogtbobjjeacjfkatzbz",
    optionA: "necmgp",
    optionB: "msplydtow",
    optionC: "csvmvq",
    optionD: "qyscgqc",
    answer: "A",
  },
  {
    questionId: "19547671492468240",
    questionContent: "axidixuupnqyabxcxqcffggqjtltpjhlmeyvlsdmbxgsfcfkoxc",
    optionA: "zqrxysxm",
    optionB: "xcjbwdmlx",
    optionC: "uyllhi",
    optionD: "kabgqeqbj",
    answer: "D",
  },
  {
    questionId: "64528688993214960",
    questionContent:
      "cxtatcplecjqwhdylgdjgdyzrpqkxrqpycpseyksnhomphxvitjutycvlcqenvxjxvtpsui",
    optionA: "dyixnp",
    optionB: "cqpboxbij",
    optionC: "zhtknui",
    optionD: "bhbpjcd",
    answer: "C",
  },
  {
    questionId: "85367758941440400",
    questionContent:
      "vbocvmlaaddqtxlnbwkbwxgxgrsnmwhmhtofugrrtimitcwjvgweehpqlvurrdwqgmmnw",
    optionA: "wluwskkwyd",
    optionB: "swqeouxvf",
    optionC: "fweim",
    optionD: "rujntu",
    answer: "B",
  },
  {
    questionId: "-24119026757834520",
    questionContent:
      "yivuhsxujlhbsqofdkqhicicbbpbcotjfzdpkrciyqqxbinvseujdwytopugngxqlvnqvcicktbttoshidoo",
    optionA: "ymwzbyggdu",
    optionB: "dnrjlepbb",
    optionC: "qsjvjahvh",
    optionD: "tzgtvhhhtm",
    answer: "B",
  },
  {
    questionId: "-20440327678946160",
    questionContent:
      "rwgoooiimcpcemtwgpykjvgfnmsdfzgfbxemlfmfevxmgdeleurnozufgsugwlkiepzrtokuk",
    optionA: "virjboyo",
    optionB: "qxgbkvrj",
    optionC: "quberhmgp",
    optionD: "pvvmmodmyp",
    answer: "A",
  },
  {
    questionId: "16890467179574280",
    questionContent:
      "gvmrumvsmxitgmnlsaftmgczplpmzbyafvtgngfvrsdcjixwtkuylckolqtqcnoqpuerbfrdxjruciwogzyyyibffqrlbvoyw",
    optionA: "wiykvn",
    optionB: "waxnakegic",
    optionC: "qgteysn",
    optionD: "yuzapntah",
    answer: "C",
  },
  {
    questionId: "-82877050002680320",
    questionContent:
      "geyruosjidddbevgqjucstcmejumjjotupwrnkgmzimledtnwujumqnjvnvjkujoakstlhuwjpqfloknywbpnbsjvqdapqtxwl",
    optionA: "yqadmih",
    optionB: "yfpglng",
    optionC: "mqscni",
    optionD: "ssqsymy",
    answer: "C",
  },
  {
    questionId: "-83494801691561480",
    questionContent:
      "vsijuodrqbpdhbfwulkrtosqkjkcviltypmrkuszwycxizlawvmcfhttrezfscosvxmfcqlhreyendwmxclhqnysnufawvniwjnf",
    optionA: "qnpoqtc",
    optionB: "uvoqgkbqzc",
    optionC: "epotdwh",
    optionD: "hfrbv",
    answer: "C",
  },
  {
    questionId: "-73435545471192680",
    questionContent:
      "sewywjdlvhojyomumjdnbjrvcvoyvyiqkouckfpkgnfwlsemzdstvjmgccufmwmwwtdbhboiiqguzi",
    optionA: "lpacqfh",
    optionB: "lvrqxx",
    optionC: "ciugvosnq",
    optionD: "fuzjrmhzk",
    answer: "B",
  },
  {
    questionId: "-21296753185471280",
    questionContent: "enkmxtzqmjihvfvrqwlddbebkesjvywfuqtrrwtfneauldhriezcomvl",
    optionA: "bprcqib",
    optionB: "rpylvy",
    optionC: "eywqvmh",
    optionD: "lkbdoe",
    answer: "C",
  },
  {
    questionId: "52120887140652000",
    questionContent:
      "tqtwvlqmoykygmklfqlnxmxpoopwkivpwtnyundbvxsebwtkyhywyfgiywxzwcggennhumytkw",
    optionA: "xxktr",
    optionB: "gtrtana",
    optionC: "vtsvecsw",
    optionD: "frtyjdkyvm",
    answer: "C",
  },
  {
    questionId: "-456315709080520",
    questionContent:
      "ygnqlxfnrjdvhkddxfdheknvkggglhwonpipxusrtlbndqkfumcpbqhvbpkupmfopolfsxnjzuqhkrxdqefx",
    optionA: "nwcpsmfkr",
    optionB: "regivrdp",
    optionC: "qkdum",
    optionD: "topayq",
    answer: "A",
  },
  {
    questionId: "-55688693350439120",
    questionContent:
      "izrczaygcaqftyrsmogpimyvhniylfflkbgcsyrrmkeitccsbcwhmflnglorpasylvupzymhnvahunjhosxwym",
    optionA: "mcvulnrs",
    optionB: "uricps",
    optionC: "ngxey",
    optionD: "duxvlc",
    answer: "B",
  },
  {
    questionId: "46422032541865120",
    questionContent:
      "zysepwpptvlgfjyjhtiydnfiskmfpmbloowrgegbeusefibfxiufmhhbbntyfsqndgdttlrjlipvlsr",
    optionA: "cmuubs",
    optionB: "wvmxlp",
    optionC: "tpilgbkns",
    optionD: "dbjwf",
    answer: "B",
  },
  {
    questionId: "-61211793166913760",
    questionContent:
      "gekunrfqaroypsoutpvnqpdpkczvlxmnmiwgvdetstresceuegkfnjqesmwjvrsnmalcbvjbwrilyxblzyjserjhpmnvmkdbic",
    optionA: "xoorpojb",
    optionB: "ivcrypxv",
    optionC: "mdfdjirh",
    optionD: "mewedrnk",
    answer: "B",
  },
  {
    questionId: "-1883644977033400",
    questionContent:
      "pzcpijnhkodxcuxaxpctaxmowwofvvjrybivpwikhsjplzarhhugkbopsnglqfclkynntplmxijqempr",
    optionA: "qlustwhpx",
    optionB: "xcexwqy",
    optionC: "kcghhpd",
    optionD: "qugkskmbk",
    answer: "D",
  },
  {
    questionId: "23994457262264640",
    questionContent:
      "geebblimkuzhbojmnfqsexmaxywothkchesbxnsmdemhdqybygtybojmsjterchlegmgkdtewkgotphykbvstkqprfmf",
    optionA: "kockidirl",
    optionB: "kpfzqqa",
    optionC: "fhnsxasdog",
    optionD: "huztln",
    answer: "B",
  },
  {
    questionId: "20430207256202280",
    questionContent:
      "vnicqcfjfkijejgisbgukkcidcjzmiqdeojwzrylrqfwiflvkftsucyiqdr",
    optionA: "yoghxlc",
    optionB: "fgsfuj",
    optionC: "uikcu",
    optionD: "nyvgcyov",
    answer: "B",
  },
  {
    questionId: "-48227655560107960",
    questionContent:
      "cenmsivxvxoewkjtulbbcwyidecxqkmzoyfmxemmzfrvcflcuatszcwxddzidzw",
    optionA: "riyffym",
    optionB: "wxpsjxz",
    optionC: "pmhbre",
    optionD: "otwdum",
    answer: "D",
  },
  {
    questionId: "35349707314824480",
    questionContent:
      "jwcevtupkrqgaotdfeldkyvqxkxcqhewajcyricdwcejtqjbtiqfpdlsuumlzempttesnlfkwbguqkycnhtxdmhw",
    optionA: "wnkqgbf",
    optionB: "nlyzmqa",
    optionC: "vfyhbpwb",
    optionD: "nwnwhcums",
    answer: "B",
  },
];
const questionAnswers = [
  {},
  { questionId: "-46505886112954320", answer: 0 },
  { questionId: "-32377424962168800", answer: 0 },
  { questionId: "-20082709465895080", answer: 0 },
  { questionId: "-3903035295930480", answer: null },
  { questionId: "-2398135318463840", answer: 1 },
  { questionId: "-39987613343154240", answer: 0 },
  { questionId: "-10267735969812320", answer: 1 },
  { questionId: "28568493078299840", answer: null },
  { questionId: "-59731919238752320", answer: 1 },
  { questionId: "63135593522702440", answer: 1 },
  { questionId: "20337265820639560", answer: null },
  { questionId: "-5490498138654040", answer: "D" },
  { questionId: "-82913043165410240", answer: "B" },
  { questionId: "64824594325433240", answer: null },
  { questionId: "78178223311573080", answer: "C" },
  { questionId: "55800584023087480", answer: "A" },
  { questionId: "53099335697851720", answer: "B" },
  { questionId: "-53387040487037840", answer: "B" },
  { questionId: "70681208838626280", answer: "B" },
  { questionId: "33377078757250720", answer: "C" },
  { questionId: "3743871891810400", answer: "C" },
  { questionId: "58263724823762880", answer: "C" },
  { questionId: "54446858995846400", answer: "C" },
  { questionId: "80475482172267840", answer: "B" },
  { questionId: "63342109317318760", answer: "C" },
  { questionId: "34800198876482840", answer: "C" },
  { questionId: "-27379117581953800", answer: "A" },
  { questionId: "26891178729235840", answer: "B" },
  { questionId: "68089056993488360", answer: "D" },
  { questionId: "33433971854586760", answer: "B" },
  { questionId: "19547671492468240", answer: "C" },
  { questionId: "64528688993214960", answer: "B" },
  { questionId: "85367758941440400", answer: "C" },
  { questionId: "-24119026757834520", answer: "A" },
  { questionId: "-20440327678946160", answer: "D" },
  { questionId: "16890467179574280", answer: "B" },
  { questionId: "-82877050002680320", answer: "B" },
  { questionId: "-83494801691561480", answer: "D" },
  { questionId: "-73435545471192680", answer: "A" },
  { questionId: "-21296753185471280", answer: "B" },
  { questionId: "52120887140652000", answer: "B" },
  { questionId: "-456315709080520", answer: "C" },
  { questionId: "-55688693350439120", answer: "B" },
  { questionId: "46422032541865120", answer: "C" },
  { questionId: "-61211793166913760", answer: "C" },
  { questionId: "-1883644977033400", answer: "C" },
  { questionId: "23994457262264640", answer: "D" },
  { questionId: "20430207256202280", answer: "B" },
  { questionId: "-48227655560107960", answer: "B" },
  { questionId: "35349707314824480", answer: "A" },
];

Mock.mock(/api\/exercise\/random/, {
  code: 200,
  passingScore: 600,
  data: {
    size: 50,
    examTime: 120,
    totalPoints: 1000,
    // 判断题
    TFQuestions,
    // 选择题 单选题
    choiceQuestions,
    // 考试ID
    examId: Random.string("lower", 5, 10),
  },
});

// 提交卷子
Mock.mock(/api\/submit\/exercise/, {
  code: 201,
  msg: "提交成功",
});

// 中途退出功能
Mock.mock(/api\/submit\/exit/, {
  code: 201,
  msg: "收到请求",
});

// 获取更改后的卷子
Mock.mock(/api\/exercise\/review/, {
  code: 200,
  data: {
    size: 50,
    // 判断题
    TFQuestions,
    // 选择题 单选题
    choiceQuestions,
    questionAnswers,
    test: "q23qaw",
  },
});
