# opengemini-client-test-common
A common module for storing the tools and files required for unit or integration testing.

English | [简体中文](README_CN.md)

## Structure
```
└─src
    └─main
        └─resources
           └─jks    # jks files for tls testing, include keystore.jks and truststore.jks. See "Generate JKS File" to generate and replace these files if expires.
```

## Generate JKS File
Execute the following command in terminal: 
<br>
` keytool -genkey -alias [alias] -keyalg RSA -keystore [output-file]`
<br>
**Note: When the command line prompts "Enter Keystore Password", please enter 123456 (do not enter any other password, otherwise it will cause the test case to fail to parse the jks file)**
<br><br>
example:
<br>
` keytool -genkey -alias test -keyalg RSA -keystore D:\test.jks`