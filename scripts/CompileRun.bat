cd ..
mkdir dist
javac -source 8 -sourcepath ./src -cp ./src/app -d ./dist ./src/Bootstrap.java
xcopy assets dist\assets /d /s /e /y /i
xcopy config dist\config  /d /s /e /y /i
copy manifest.mf dist\manifest.mf
cd dist
jar cvfm .\Tank2020.jar manifest.mf .
cd ..
java -jar .\dist\Tank2020.jar
