(window.webpackJsonp=window.webpackJsonp||[]).push([[9],{284:function(t,a,v){"use strict";v.r(a);var r=v(10),_=Object(r.a)({},(function(){var t=this,a=t._self._c;return a("ContentSlotsDistributor",{attrs:{"slot-key":t.$parent.slotKey}},[a("h1",{attrs:{id:"🧚‍♀️-花楹-api-文档"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#🧚‍♀️-花楹-api-文档"}},[t._v("#")]),t._v(" 🧚‍♀️ 花楹 "),a("code",[t._v("API")]),t._v(" 文档")]),t._v(" "),a("p"),a("div",{staticClass:"table-of-contents"},[a("ul",[a("li",[a("a",{attrs:{href:"#api-说明"}},[t._v("API 说明")]),a("ul",[a("li",[a("a",{attrs:{href:"#获取随机资源"}},[t._v("获取随机资源")])]),a("li",[a("a",{attrs:{href:"#获取今日资源"}},[t._v("获取今日资源")])])])]),a("li",[a("a",{attrs:{href:"#api-示例"}},[t._v("API 示例")]),a("ul",[a("li",[a("a",{attrs:{href:"#随机图片-api"}},[t._v("随机图片 API")])]),a("li",[a("a",{attrs:{href:"#每日一图-api"}},[t._v("每日一图 API")])])])])])]),a("p"),t._v(" "),a("ArticleAds"),t._v(" "),a("h2",{attrs:{id:"api-说明"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#api-说明"}},[t._v("#")]),t._v(" "),a("code",[t._v("API")]),t._v(" 说明")]),t._v(" "),a("h3",{attrs:{id:"获取随机资源"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#获取随机资源"}},[t._v("#")]),t._v(" 获取随机资源")]),t._v(" "),a("ul",[a("li",[a("p",[t._v("请求方式："),a("code",[t._v("GET")])])]),t._v(" "),a("li",[a("p",[t._v("请求地址："),a("code",[t._v("https://api.lilu.org.cn/shushan/huaying/random/{category}")])])]),t._v(" "),a("li",[a("p",[t._v("请求参数：")]),t._v(" "),a("ul",[a("li",[a("code",[t._v("{category}")]),t._v("：路径参数。资源分类名。可选值：\n"),a("ul",[a("li",[a("code",[t._v("cartoon")]),t._v("：二次元动漫")]),t._v(" "),a("li",[a("code",[t._v("mc")]),t._v("："),a("code",[t._v("mc")]),t._v(" 酱动漫")])])]),t._v(" "),a("li",[a("code",[t._v("type")]),t._v("：返回数据格式。非必传，默认为 "),a("code",[t._v("json")]),t._v(" 格式。可选值：\n"),a("ul",[a("li",[a("code",[t._v("302")]),t._v("：直接跳转到图片源文件地址，可用作随机背景图等。")]),t._v(" "),a("li",[a("code",[t._v("json")]),t._v("：返回标准 "),a("code",[t._v("RESTful API")]),t._v(" 接口格式的数据。")])])])])]),t._v(" "),a("li",[a("p",[t._v("返回"),a("code",[t._v("json")]),t._v("示例：")]),t._v(" "),a("div",{staticClass:"language-text extra-class"},[a("pre",{pre:!0,attrs:{class:"language-text"}},[a("code",[t._v('{\n  "code": 20000,\n  "msg": "请求成功",\n  "data": "https://cdn.lilu.org.cn/avatar.png"\n}\n')])])])])]),t._v(" "),a("h3",{attrs:{id:"获取今日资源"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#获取今日资源"}},[t._v("#")]),t._v(" 获取今日资源")]),t._v(" "),a("ul",[a("li",[a("p",[t._v("请求方式："),a("code",[t._v("GET")])])]),t._v(" "),a("li",[a("p",[t._v("请求地址："),a("code",[t._v("https://api.lilu.org.cn/shushan/huaying/today/{category}")])])]),t._v(" "),a("li",[a("p",[t._v("请求参数：")]),t._v(" "),a("ul",[a("li",[a("code",[t._v("{category}")]),t._v("：路径参数。资源分类名。可选值：\n"),a("ul",[a("li",[a("code",[t._v("cartoon")]),t._v("：二次元动漫")]),t._v(" "),a("li",[a("code",[t._v("mc")]),t._v("："),a("code",[t._v("mc")]),t._v(" 酱动漫")])])]),t._v(" "),a("li",[a("code",[t._v("type")]),t._v("：返回数据格式。非必传，默认为 "),a("code",[t._v("json")]),t._v(" 格式。可选值：\n"),a("ul",[a("li",[a("code",[t._v("302")]),t._v("：直接跳转到图片源文件地址，可用作随机背景图等。")]),t._v(" "),a("li",[a("code",[t._v("json")]),t._v("：返回标准 "),a("code",[t._v("RESTful API")]),t._v(" 接口格式的数据。")])])])])]),t._v(" "),a("li",[a("p",[t._v("返回"),a("code",[t._v("json")]),t._v("示例：")]),t._v(" "),a("div",{staticClass:"language-text extra-class"},[a("pre",{pre:!0,attrs:{class:"language-text"}},[a("code",[t._v('{\n  "resultCode": 20000,\n  "resultMsg": "请求成功",\n  "data": "https://cdn.lilu.org.cn/avatar.png"\n}\n')])])])])]),t._v(" "),a("h2",{attrs:{id:"api-示例"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#api-示例"}},[t._v("#")]),t._v(" "),a("code",[t._v("API")]),t._v(" 示例")]),t._v(" "),a("h3",{attrs:{id:"随机图片-api"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#随机图片-api"}},[t._v("#")]),t._v(" 随机图片 "),a("code",[t._v("API")])]),t._v(" "),a("table",[a("thead",[a("tr",[a("th",[t._v("分类")]),t._v(" "),a("th",[t._v("示例")])])]),t._v(" "),a("tbody",[a("tr",[a("td",[t._v("二次元动漫")]),t._v(" "),a("td",[a("code",[t._v("json")]),t._v(" 形式："),a("a",{attrs:{href:"https://api.lilu.org.cn/shushan/huaying/random/cartoon",target:"_blank",rel:"noopener noreferrer"}},[a("code",[t._v("https://api.lilu.org.cn/shushan/huaying/random/cartoon")]),a("OutboundLink")],1),a("br"),a("br"),a("code",[t._v("302")]),t._v(" 形式："),a("code",[t._v('<img src="https://api.lilu.org.cn/shushan/huaying/random/cartoon?type=302">')])])]),t._v(" "),a("tr",[a("td",[a("code",[t._v("mc")]),t._v(" 酱动漫")]),t._v(" "),a("td",[a("code",[t._v("json")]),t._v(" 形式："),a("a",{attrs:{href:"https://api.lilu.org.cn/shushan/huaying/random/mc",target:"_blank",rel:"noopener noreferrer"}},[a("code",[t._v("https://api.lilu.org.cn/shushan/huaying/random/mc")]),a("OutboundLink")],1),a("br"),a("br"),a("code",[t._v("302")]),t._v(" 形式："),a("code",[t._v('<img src="https://api.lilu.org.cn/shushan/huaying/random/mc?type=302">')])])])])]),t._v(" "),a("h3",{attrs:{id:"每日一图-api"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#每日一图-api"}},[t._v("#")]),t._v(" 每日一图 "),a("code",[t._v("API")])]),t._v(" "),a("table",[a("thead",[a("tr",[a("th",[t._v("分类")]),t._v(" "),a("th",[t._v("示例")])])]),t._v(" "),a("tbody",[a("tr",[a("td",[t._v("二次元动漫")]),t._v(" "),a("td",[a("code",[t._v("json")]),t._v(" 形式："),a("a",{attrs:{href:"https://api.lilu.org.cn/shushan/huaying/today/cartoon",target:"_blank",rel:"noopener noreferrer"}},[a("code",[t._v("https://api.lilu.org.cn/shushan/huaying/today/cartoon")]),a("OutboundLink")],1),a("br"),a("br"),a("code",[t._v("302")]),t._v(" 形式："),a("code",[t._v('<img src="https://api.lilu.org.cn/shushan/huaying/today/cartoon?type=302">')])])]),t._v(" "),a("tr",[a("td",[a("code",[t._v("mc")]),t._v(" 酱动漫")]),t._v(" "),a("td",[a("code",[t._v("json")]),t._v(" 形式："),a("a",{attrs:{href:"https://api.lilu.org.cn/shushan/huaying/today/mc",target:"_blank",rel:"noopener noreferrer"}},[a("code",[t._v("https://api.lilu.org.cn/shushan/huaying/today/mc")]),a("OutboundLink")],1),a("br"),a("br"),a("code",[t._v("302")]),t._v(" 形式："),a("code",[t._v('<img src="https://api.lilu.org.cn/shushan/huaying/today/mc?type=302">')])])])])]),t._v(" "),a("ArticleAds")],1)}),[],!1,null,null,null);a.default=_.exports}}]);