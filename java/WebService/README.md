*工程 WebService： 发布WebService*
1. 直接执行com.test.publisher.Publisher， 控制台上输出： "wsdl的地址：http://localhost:8080/helloWebService?WSDL"
2. 复制http://localhost:8080/helloWebService?WSDL 并用浏览器打开，看到XML，如 WSDL-examples/example.xml
3. 发布成功，等待client 调用


*工程 WebServiceProject： 调用WebService*
1. 用下面命令生成包 com.test.client.generated 下的文件
wsimport -s {path}/workspace/WebServiceProject/src -p com.test.client.generated -keep http://localhost:8080/helloWebService?wsdl
2. 在创建Main类用来调用导入的WebService 的方法，执行时请注意Service是否已开启


常见问题：
1. 发布端需要开启，否则执行wsimport命令时失败
2. 自动生成的文件必须放到生成时指定的包下，否则换位置时需要同步更新生成类中package相关信息
