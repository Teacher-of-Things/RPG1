echo "Version: \c"
read answer
echo Compiling...
#Make All Folders
mkdir build build/Jar build/Jar/$answer build/Jar/$answer/Data build/Class build/Class/$answer build/Class/$answer/Data source source/$answer
clear
echo Compiling...
#Class Files
javac *.java
#Jar File
jar cvfe Data.jar JarExample *.class
jar uf Data.jar res
mv Data.jar build/Jar/$answer/Data
#Copying
cp --remove-destination *.class build/Class/$answer/Data
cp --remove-destination *.java source/$answer
cp --remove-destination Readme.md build/Jar/$answer
cp --remove-destination Readme.md build/Class/$answer
cp --remove-destination Readme.md source/$answer
cp --remove-destination License.md build/Jar/$answer
cp --remove-destination License.md build/Class/$answer
cp --remove-destination License.md source/$answer
#Copy res Folder
cp --remove-destination -r res build/Jar/$answer/Data
cp --remove-destination -r res build/Class/$answer/Data
cp --remove-destination -r res source/$answer
#Launchers
echo cd Data \&\& java -jar Data.jar>build/Jar/$answer/Launcher.sh
chmod +x build/Jar/$answer/Launcher.sh
echo cd Data \&\& java Launcher>build/Class/$answer/Launcher.sh
chmod +x build/Class/$answer/Launcher.sh
echo
echo
echo Done!
sleep 1
exit