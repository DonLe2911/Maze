cd leaderboards/
DATE=`date '+%d-%b-%Y_%H-%M'`
mkdir $DATE
cd ..
mv version-beta/apache-tomcat-9.0.12/webapps/Maze/leaderboard.db leaderboards/$DATE
cd version-beta/apache-tomcat-9.0.12/webapps/Maze/WEB-INF/classes/
java -classpath ".:sqlite-jdbc-3.23.1.jar" libs.SQLiteDriverConnection
mv leaderboard.db ../../
cd ../../../Maze/
jar -uvf ../Maze.war leaderboard.db
cd ../../../../
./stop-app.sh
./start-app.sh