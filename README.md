# Graduation-Project-Client-
## 毕业设计
###	功能需求
#### 功能划分
##### 1)	一个用于将线上辅助教学资源与二维码相关联的管理平台
https://github.com/JiuMingZhu/Graduation-Project-Server-
###### 实现方案：
1.	管理员页面：管理员维护线下资源以及对应的视频信息，储存在数据库中。（操作类型：增、删、查（时间允许的话增加 改））
2.	用户页面：查询资源列表（可点击资源信息进而查询对应二维码）
3.	采用J2EE搭建管理平台
##### 2)	生成辅助教学资源对应的二维码
###### 实现方案：
根据点击的视频信息从数据库中查询视频URL，生成二维码
注：二维码生成采用现有技术，在此仅调用对应的API，参考：
http://www.swetake.com/qrcode/java/docs/index.html
##### 3)	一个承载辅助教学资源的服务器
###### 实现方案：
采用流媒体传输实现教学视频的点播功能，流媒体服务器采用Red5
注：目前把视频资源放在官方的Demo目录下使用，时间来得及的话会整合到管理平台的J2EE工程中。
参考：
https://github.com/Red5/red5-server
##### 4)	手机端扫描二维码并完成辅助教学资源的点播
###### 实现方案：
1.	采用谷歌开源项目ZXing的一个简化版本ZXing-Android-Embedded（因为该版本支持Intent调用），调用该版本的扫描API，取得扫描结果。
2.	将扫描结果传入播放器Activity，播放相应的流媒体资源。
注：ZXing-Android-Embedded参考：
https://github.com/journeyapps/zxing-android-embedded
流媒体播放组件参考：
https://github.com/yixia/VitamioBundle
