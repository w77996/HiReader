# HiReader
RxJava+Retrofit+MVP的阅读类APP,包含新闻资讯，知乎豆瓣，历史上的今天，聊天机器人，城市天气五个模块


# HiReader
毕业设计做完后距离答辩还有好一段时间，平时开发任务也没有，闲的时间也比较多，正好那段时间几乎是没啥事情可以做，就花时间来写一个项目，然后模块越写越多，一发不可收拾。

果然看源码学习是学的最快的，即时看不懂也只能搜点资料自己消化。

项目地址:[HiReader](https://github.com/w77996/HiReader)

HiReader是我觉得写得还不错的一个APP，Rxjava+Retrofit+Mvp设计，包含知乎豆瓣，新闻资讯，城市天气，历史上的今天，聊天机器人这五个模块，每个模块都用包区分开来，基本遵循MVP模式的开发。



网络请求部分不得不说，Rxjava+Retrofit+Gson的结合节省了很多的代码。

MVP就不介绍，弄懂以后写代码66的，逻辑十分的清晰，修改添加功能也变的很容易。

Meterial Design 设计

个人博客广告一波：

Github:https://github.com/w77996

CSDN:http://blog.csdn.net/w77996?viewmode=list

简书：http://www.jianshu.com/u/7e2a1f1b1529

---
# 新闻资讯
这是新闻内容，可下拉刷新，上拉加载（自定义的RecyclerView,其实很简单，就是动画少了一点）

![新闻](https://raw.githubusercontent.com/w77996/BlogsImage/master/HiReader/news.gif)

因为url的原因，查看新闻详情那边体验不是很好。



# 知乎豆瓣
拿的是知乎日报和豆瓣精选的API，网络上有一个很好的教程，叫PaperPlan。这个模块是从那边学来的

![知乎豆瓣](https://raw.githubusercontent.com/w77996/BlogsImage/master/HiReader/zhihudouban.gif)

# 历史上的今天
这个无聊可以看看，之后看一下要不要优化一下添加自定义的日期选择。

![历史上的今天](https://raw.githubusercontent.com/w77996/BlogsImage/master/HiReader/hof.gif)

# 聊天机器人
觉得没有上下文语义进行分析可惜了，不然应该很好玩。


只是对返回结果的文字进行了解析，其实还是很鸡肋的一个模块，请忽略气泡，太丑了，这是大三时候倒腾的气泡，当初期末的时候去一家小公司实习没事的时候就看聊天机器人的视频教程，现在还记得，不知不觉也快一年了~

![聊天机器人](https://raw.githubusercontent.com/w77996/BlogsImage/master/HiReader/chat.gif)

# 城市天气
界面和我的毕业设计是不是很像哈哈~UI是在太花时间了所以就直接复制了一些，不过比毕业设计的好看，因为状态栏我改了颜色，那时候还不会弄主题，搞得一团糟= =

定位用的高德，后期画双折线，显示未来天气温度的走势，还在学。


毕业设计传送门：[多知天气](https://github.com/w77996/Weather)

![城市天气](https://raw.githubusercontent.com/w77996/BlogsImage/master/HiReader/2547E64121360AA7026A57CF3B515363.jpg)

# 关于和设置
设置里面只有一个清除缓存项

关于用的是别人写的，不过觉得还是自己写的好一些，以后就自己封装一个调用

# 其他
这个项目断断续续的做了二十天左右，主要是学习MVP模式和Rxjava+Retrofit+Okhttp的结合，刚学Android的时候就想完成一个类似功能的APP，现在一点点的积累也知道了个大概，数据库是没有的，还有点BUG，大神勿喷。有时间就改改吧。



很多东西都是从网络上别人的开源代码中学到的，为此献上我的劳动成果，让更多的人从中受益。


觉得对你有帮助，请在Github上给个star~

