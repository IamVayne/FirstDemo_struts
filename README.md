# FirstDemo_struts
This is my first Demo which use to learn struts.

				项目小总结：
1.项目开发环境：MyEclipse + Mysql5.0 + Tomcat 7.0
2.项目框架：struts 1.3 
3.主要功能：①完成了用户的注册（包括姓名和头像）。
			②完成用户头像的上传和下载
4.主要学习点：①配置struts环境。
			  ②EL表达式和struts标签库的使用。
			  ③struts框架工作原理和流程。
			  ④上传动作的实现。
			  ⑤下载动作的实现
5.遇到的主要问题。
			①如何处理服务器项目下同一文件夹下头像文件名称冲突的问题？
			答：使用UUID类，UUID存在一个方法UUID.randomUUID.toString(),可以用使用UUID类得到的随机数来替换上传的头像文件名，不过需要在数据库中使用表来存储name,filegoalname,sourcefilename的相互对应关系，便于下载时的处理。
			
			②上传的具体流程？
			答：上传的用户名和头像对应一个表单类（String name,FormFile photo）,因而可以从这个类中得到上传的头像文件的文件名称（用UUID类进行再处理），然后使用servlet类得到Tomcat下发布的该项目的路径，再将前面得到的用UUID文件名称和该路径连接起来得到存储路径。建立输出流，用通过表单类得到的Formfile属性值建立输入流，然后进行文件复制即可。
			
			③展示存储的用户时，如何得到这些用户的信息？
			答：使用sqlHelper封装类进行查询，然后将查询得到的结果存到一个ArrayList中，再把这个ArrayList放到request中，最后在jsp页面中使用struts标签库循环取出每条信息。要注意的是，如何解决展示头像的问题（具体见showuserlist.jsp）。
			
			④下载的流程？
			答：基本跟上传相反。showuserlist.jsp中传入动作（href="FileupAndLoad/download.do?username=${user.name}"），然后在downloadAction类中得到request中的username属性，然后查数据库得到与这个user有关的一条user记录。接着要处理的还是路径的问题，跟上传用的取法一样，不过输入流和输出流要相反的处理。这一步要注意的是，要在response中设立相关信息告诉浏览器有文件要下载，
								response.setContentType("text/html;charset=utf-8");
								response.setHeader("Content-Disposition","attachment;filename="+java.net.URLEncoder.encode(user.getSourcefilename,"utf-8"));
			上面要注意的是，为了避免原文件名是中文导致的下载文件名乱码问题，对sourcefilename进行URL的编码处理。还要注意，管理下载的action最后要返回null，不然会产生错误。