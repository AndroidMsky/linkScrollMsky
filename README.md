# linkScrollMsky
Link Scroll CoordinatorLayout,仿知乎个人主页渐隐嵌套滑动。

讲解链接：

http://blog.csdn.net/AndroidMsky/article/details/53784984

觉得有帮助，欢迎star fork支持作者。


先看知乎的效果：

![这里写图片描述](http://img.blog.csdn.net/20161221135930061?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvQW5kcm9pZE1za3k=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)



再看我们实现的效果：

![这里写图片描述](http://img.blog.csdn.net/20161221140702576?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvQW5kcm9pZE1za3k=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

网上也有很多嵌套滑动的例子，先说说我这个的优点。

1.头部可以参与滑动

2.下面可以加viewpager

3.支持RecyclerView和ScrollView

4.基于Behavior可以获取事实滚动距离可做更多联动

5.不必重写过多的滑动事件处理，几乎只是玩xml
