# Maze

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for use.

### Prerequisites

What things you need to run the software

```
Java 
```

### Installing

A step by step series of examples that tell you how to get a development env running

Download the code repository

Navigate to the root directory of the project (using the command line), and run the following command
to start the application.

On Mac & linux
```
./start-app.sh
```

On windows
```
start-app
```

You can then access the application from the following url: http://localhost:8080/Maze/

You can stop the application by running the following command

On Mac & linux
```
./stop-app.sh
```

On windows
```
stop-app
```

## Exporting a leaderboard (automatically creates a new one) [Bash terminal only]

Navigate to the root directory of the project (using the command line), and run the following command.

On Mac & linux
```
./export-and-compile-leaderboard.sh
```

On windows
```
./export-and-compile-leaderboard-ws.sh
```

You should then be able to see your database file for the current leaderboard under the "leaderboards" folder.
The application should also automatically have been populated with a new leaderboard.

If you wish to view a leaderboard you had exported previously, navigate to the "leaderboards" folder, and copy the 
"leaderboard.db" file (inside the appropriate folder) that you wish to view. 
Starting from the root path of the project, navigate then to **version-beta/apache-tomcat-9.0.12/webapps/Maze** and 
remove the "leaderboard.db" file from that directory. Finally, paste the new "leaderboard.db" file which you copied 
previously. Return to the root path of the project, and run the following command.

On Mac , linux and windows
```
./compile-leaderboard.sh
```


## Modifying a level

In Eclipse, navigate to: **File (in the toolbar) > import... > General > Existing Maven Projects**.
As a root directory, choose the **version-beta/maze/Maze** (from the root directory of the project) folder.
Click "Finish". (Make sure that the workspace you use when running Eclipse is not the same as the one where 
the project is installed).

Right click the project (i.e. maze), and choose the option: **Run as > Run on server**. In the dropdown list to 
choose a server, select the option: **Apache > Tomcat v9.0 Server**. Click on "next".
Click the "Browse" button for the Tomcat installation directory, and navigate (starting from the root 
path of the project) to **version-beta/apache-tomcat-9.0.12**. Click "Open", and "Finish".

Once the project is opened, in the project, navigate to: **Maze > WebContent > resources > js > vars**. 
Open the "grids.js" file. 
In this file, you can modify the "_grid_level_1", "_grid_level_2" object variables to make your own maze.
The "[_width]" and "[_height]" attributes define the size of the maze. 
The "[_start]" and "[_end]" attributes define the positions of the starting and ending points of the maze.
For the "[_start]" attribute, the "[_direction]" attribute defines the initial direction of the arrow when starting the level.
The "[_paths]" attribute, lists the coordinates of the maze that will be initiated as "paths" (i.e. cells the arrow can access).
All the other cells will be initiated as walls.
Once your modifications are completed, save the file.

You now need to navigate (in eclipse), to **Maze > Java Resources > src > libs**.
Open the "SQLiteDriverConnection.java" file.
On line 238 of that file, you will see the following line of code:

```
Path currentPath = Paths.get(System.getProperty("user.dir"), Tag.dir_web);
```

Replace that line with the following

```
Path currentPath = Paths.get(System.getProperty("user.dir"));
```

Once this is done, save the file.

You can now export your modifications.
In Eclipse, right click on the project (i.e. Maze), and choose the option: **Export > WAR file**.
Click the "Browse" button for the destination field. Under the directory where you have downloaded
the project source code, navigate to: **version-beta/apache-tomcat-9.0.12/webapps/** and click "Save".
Make sure that the "Web project" is Maze.
On the same window, choose the option "Overwrite existing file", and click finish.

From the command line, you can then navigate to the root directory of the project, and run the command 
to start the application (if it was running, stop it first).

On linux
```
./start-app.sh
```

On windows
```
start-app
```

## Share application across several computers

Find the local ip of your computer 

On linux
```
ifconfig
```

On windows
```
ipconfig
```

and copy the ip address next to the "inet" (or ipv4) attribute (e.g. inet 172.20.192.91).

Open your project in Eclipse. 
In Eclipse, navigate to **Maze > WebContent > resources > js > vars** and open the "variables.js" file.
On line 114, you should see the following line:

```
var _path_websocket = "ws://localhost:8080/Maze/Websocket";
```

Replace it with the following line:

```
var _path_websocket = "ws://<ip address>:8080/Maze/Websocket";
```

where &lt;ip address&gt; is the local ip of your computer.

For example:

```
var _path_websocket = "ws://172.20.192.91:8080/Maze/Websocket";
```

You will then need to export your project to a WAR file as explained previously in the **Modifying a level** section.

In your browser, from any computer on the same Wifi network, navigate to the following 
url to access the application: http://&lt;ip address&gt;:8080/Maze/ (e.g. http://172.20.192.91:8080/Maze/).


## Authors

* **Chris Iliev** - Developer
* **Marc-steeven Eyeni-Kantsey** - Developer
* **Don Le** - Project manager


