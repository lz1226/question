# target目录存在，先清空；不存在，先创建
test -d ./target && rm -rf ./target/* || mkdir target
# 数据库逆向工程
java -jar config/lib/mybatis-generator-core-1.3.6.jar -configfile config/generatorConfig.xml -overwrite -verbose