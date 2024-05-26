# opengemini-client-test-common
一个用于存放单元或集成测试所需的工具类、文件的公共模块。

简体中文 | [English](README.md)

## 目录结构
```
└─src
    └─main
        └─resources
           └─jks    #用于TLS相关测试的jks文件，包括keystore.jks和truststore.jks。请参阅“生成JKS文件”以在过期时生成和替换这些文件。
```

## 生成JKS文件
在终端执行以下命令:
<br>
` keytool -genkey -alias [alias] -keyalg RSA -keystore [output-file]`
<br>
**注意：当命令行提示“输入密钥库口令”，请输入123456（请勿输入除此之外的其他口令，否则会导致测试用例解析jks文件失败）。**
<br><br>
示例:
<br>
` keytool -genkey -alias test -keyalg RSA -keystore D:\test.jks`