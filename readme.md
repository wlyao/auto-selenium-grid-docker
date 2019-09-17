
Github：https://github.com/SeleniumHQ/docker-selenium

#### images
- selenium/hub: The Hub receives a test to be executed along with information on which browser and 'platform' where the test should be run. The hub will use this information and delegate to a node that can service those needs.

- NodeChrome： 不带图形的界面的 Selenium Node configured to run Google Chrome

- selenium/node-chrome-debug：带图形界面 可以看到浏览器的运行 This image is only intended for development purposes! Runs a Selenium Grid Node with a VNC Server to allow you to visually see the browser being automated. Since it runs additional services to support this it is too heavy weight for usage within a Selenium Grid cluster.

- NodeBase：Node基础镜像 用来自定义镜像 This image is not meant to be run directly! It serves as the base image used for Selenium Nodes.

##### 1. Start hub:
`docker run --name=hub -p 5001:4444 -e GRID_TIMEOUT=0 -e GRID_THROW_ON_CAPABILITY_NOT_PRESENT=TRUE -e GRID_NEW_SESSION_WAIT_TIMEOUT=-1 -e GRID_BROWSER_TIMEOUT=15000 -e GRID_TIMEOUT=3000 -e GRID_CLEAN_UP_CYCLE=3000 -d selenium/hub:3.7.1-beryllium`

- GRID_TIMEOUT
- GRID_THROW_ON_CAPABILITY_NOT_PRESENT
- GRID_NEW_SESSION_WAIT_TIMEOUT
- GRID_BROWSER_TIMEOUT
- GRID_TIMEOUT
- GRID_CLEAN_UP_CYCLE

Visit http://localhost:5001/ see if hub starts successfully

##### 2. Start node
- Start 1st node:  
`docker run -d --name chrome -p 5902:5900 -e NODE_MAX_INSTANCES=6 -e NODE_MAX_SESSION=6 -e NODE_REGISTER_CYCLE=5000 -e DBUS_SESSION_BUS_ADDRESS=/dev/null -v /dev/shm:/dev/shm --link hub selenium/node-chrome-debug:3.7.1-beryllium`

- Start 2nd node:  
docker run -d --name chrome1 -p 5903:5900 -e NODE_MAX_INSTANCES=10 -e NODE_MAX_SESSION=10 -e NODE_REGISTER_CYCLE=5000 -e DBUS_SESSION_BUS_ADDRESS=/dev/null -v /dev/shm:/dev/shm --link hub selenium/node-chrome-debug:3.7.1-beryllium

##### 安装VNC Vierer 
连接node机子 实时查看浏览器运行效果 VNC密码：secret


##### 通过testng.xml来并发运行 同时启动三个浏览器


上面hub node都是在同一个机器上配置的 这个肯定是不能满足需求  一般都是hub node都是在不同的机器上