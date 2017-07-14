# thinkLib
base lib for android

test use：

透明状态栏
-----------
  TransparentStatusBarActivity<br>
  style/TransparentStatusTheme<br>
  >在需要的页面设置theme，继承TransparentStatusBarActivity，设置layout根布局背景色
  >如果设置了fitsSystemWindows="true"属性，那么在使用Toast的时候要用getApplicationContext()作为Context参数，不能用this，否则会错位​

​​CustomTitle​​
-----------
  CustomTitle<br>
  >addLeftView (BaseTitleLeftView是简单的左侧view，图片文字)<br>
  >addRightView (BaseTitleRightView是简单的右侧view，文字图片)<br>
  >addOnlyTextMid 添加中间文字标题<br>
  >addMidView 添加中间部分View<br>

BaseSimpleAdapter基础类
-----------
  使用：创建Adapter继承BaseSimpleAdapter，需要创建构造函数。(mContext = context)

DrawableUtil
-----------
  setRoundRectBackground<br>
	设置圆角矩形背景，与使用shape效果一样（限圆角矩形），因为不想因为一个颜色不同就要创建不同的xml文件，所以创建这个方法<br>
  setCompoundStateStyle<br>
	同上，这个是设置radioButton或者checkBox的选中/未选中时的背景和文字颜色，和设置selector效果一样(xml文件不少)<br>
  >因为一般就是两个drawable和一个selector文件，这里的两个drawable也可以是xml文件；在这里无非就是没有了selector文件，属于动态设置而已

BaseView/BasePresenter接口
-----------
  MVP设计模式实现：这两个接口分别被具体的页面类和具体的请求操作类实现<br>
  在view里面设置presenter<br>
  因为presenter接收了view对象，可以直接调用view对象的方法来执行数据操作。<br>


BasePullActivity/Fragment
-----------
  包含下拉上滑的显示组件<br>
  包含BGARefreshLayout的下拉上滑页面，使用的时候要继承BasePullActivity/Fragment，然后在layout中要有BGARefreshLayout，（在gradle中导入：
  compile 'cn.bingoogolapple:bga-refreshlayout:1.1.7@aar'），然后记得调用initRefreshLayout来进行初始化。会提示重写两个方法：一个刷新，一个加载更多

DisplayUtil
-----------
  尺寸转换，如px转dp,sp,和sp,dp转px等<br>

SharedPreferenceUtil
-----------
  提供sharePreference的一般操作，两个构造函数，没有名称的是默认文件为config；有名称的是自己想要保存的名字<br>

NetUtils
-----------
  检测网络状态和网络类型<br>

Tools
-----------
  hasSDcard 是否有SD卡<br>
  isMobilePhone 是否是手机号<br>
  isRightPw 字符串是否符合6-20位字母和数字的需求<br>
  parseStrToMd5L32 执行md5加密<br>
  startDownLoad 进行后台下载安装apk<br>

TimeUtils
-----------
  millisecondToHMS 毫秒格式化为时分秒<br>
  timestampToDate 时间转换为date(年月日时分秒)<br>

CallUtils
-----------
  call 拨打电话<br>

MathUtils
-----------
  getCombinationNum 获取组合数<br>

BaseWebView
-----------
  instanceNonZoom 初始化setting，支持js，不支持缩放，适配屏幕宽度<br>
  instanceSupportZoom 初始化setting，支持js，支持缩放，原样显示<br>

GlideCacheUtil
-----------
  getInstance 获取实例<br>
  getCacheSize 获取缓存大小，用于显示<br>
  clearImageAllCache 清除缓存<br>

PercentLayout(百分比Layout)
-----------
  导入包：compile 'com.android.support:percent:24.0.0'<br>
  有PercentFrameLayout；PercentRelativeLayout；PercentLinearLayout<br>
  动态设计百分比Layout中的View所占的百分比：<br>
    PercentFrameLayout.LayoutParams params = (PercentFrameLayout.LayoutParams) tvRed.getLayoutParams(); <br>
    params.getPercentLayoutInfo().widthPercent = 0.5f; <br>
    tvRed.setLayoutParams(params);<br>
