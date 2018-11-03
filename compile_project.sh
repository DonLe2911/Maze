cd version-beta/apache-tomcat-9.0.12/webapps/Maze
jar -uvf ../Maze.war *
cd ../../../../
./stop-app.sh
./start-app.sh
