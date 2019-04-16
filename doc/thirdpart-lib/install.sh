# 如果需要安装文档和源码，需要指定-Dclassifier参数，如果仅需要安装jar包，则忽略-Dclassifier参数
# mvn install:install-file \
#   -Dfile=<path-to-file> \
#   -DgroupId=<group-id> \
#   -DartifactId=<artifact-id> \
#   -Dversion=<version> \
#   -Dpackaging=<packaging> [-Dclassifier=[sources|javadoc]]
# 大于短信
# jar包
mvn install:install-file \
    -Dfile=taobao-sdk/taobao-sdk-java-auto_1455552377940-20160607.jar \
    -DgroupId=com.aliyun \
    -DartifactId=taobao-sdk-java-auto_1455552377940 \
    -Dversion=20160607 \
    -Dpackaging=jar
# 源码
mvn install:install-file \
    -Dfile=taobao-sdk/taobao-sdk-java-auto_1455552377940-20160607-source.jar \
    -DgroupId=com.aliyun \
    -DartifactId=taobao-sdk-java-auto_1455552377940 \
    -Dversion=20160607 \
    -Dpackaging=jar \
    -Dclassifier=sources

