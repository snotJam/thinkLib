# thinkLib
base lib for android

test use:

导入：
----------
allprojects {<br>
	repositories {<br>
		...
		maven { url 'https://jitpack.io' }<br>
	}<br>
}<br>

dependencies {<br>
	compile 'com.github.snotJam:thinkLib:v1.1.3'<br>
}


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
  使用：创建Adapter继承BaseSimpleAdapter<Class>，需要创建构造函数。(mContext = context)，泛型是接收的数据类型

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
  compile 'cn.bingoogolapple:bga-refreshlayout:1.1.7@aar'和compile 'com.android.support:recyclerview-v7:24.2.1'），然后记得调用initRefreshLayout来进行初始化。会提示重写两个方法：一个刷新，一个加载更多<br>
  注意要在项目中添加recyclerView依赖，否则会报错<br>

DisplayUtil
-----------
  尺寸转换，如px转dp,sp,和sp,dp转px等<br>
  获取状态栏和导航栏高度<br>

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
  getAppVersion 获取应用版本号<br>

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

BaseViewPagerAdapter
-----------
  viewPager基础Adapter<br>
	
NormalDialog
------------
  简单dialog的创建，使用方法<br>
  dialog = new NormalDialog(context,R.style.CustomDialog，view);<br>
  R.style.CustomDialog属性设置：无标题，无边框，背景默认白色。简而言之就是可以直接拿view当做dialog来显示<br>
  
NormalPopupTools
------------------
  简单popupWindow创建<br>
  PopupWindow createNormalPopup(view,width,height)：内容和宽高。默认点击边界外关闭，可以获取焦点<br>

gson目录
---------------
  在使用retrofit进行gson转换的时候用到<br>

ThinkRetrofitUtil
------------------
  可以用这个工具创建Retrofit<br>
  createRetrofit(String baseUrl)：接收url作为参数创建retrofit<br>
  getApi(String baseUrl, Class<T> service):接收url，指定api.class作为参数直接返回api对象<br>
  createRetrofitWithInterceptor(String baseUrl, Interceptor interceptor)：接收url，拦截器创建一个带有拦截器的retrofit<br>
  createRetrofitWithRxAdapter(String baseUrl):创建一个可以配合RxJava使用的retrofit<br>
  getRxApi(String baseUrl, Class<T> service)：接收url，指定api.class作为参数直接返回api对象<br>

Acache
-----------------
  一个简单的缓存工具，使用可以参考https://github.com/yangfuhai/ASimpleCache<br>
  
GsonUtil
-----------------
  一个gson转换工具，用来实现object和json字符串之间的转换<br>

GlideRoundTransform
----------------
Glide圆角转换，使用方式为：
Glide.with(context).load(path)
                .transform(new CenterCrop(context), new GlideRoundTransform(context, 6))
                .into(imageView);

SimpleProgressView
-----------------
简单的progressBar，在网络请求等待的时候显示



关于屏幕适配
-----------------------
直接参考大神的使用
https://github.com/hongyangAndroid/AndroidAutoLayout


CalendarUtils
--------------------------
日历，可以获取当前天的年月日<br>
可以获取上一天，下一天，上一月，下一月


RxTransformUtil
-----------------------------
简单指定调度线程<br>
配合Retrofit和RxJava使用<br>
使用的时候：<br>
	Subscription sub = xxxapi.xxx().compose(RxtransformUtil.composeHelper()).subscribe(......)
	

	
