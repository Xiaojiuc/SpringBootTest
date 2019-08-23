package com.qhit.test;

import com.qhit.App;
import com.qhit.mapper.UsersMapping;
import com.qhit.pojo.Users;
import com.qhit.service.UsersService;
import org.csource.fastdfs.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.csource.fastdfs.*;

import java.io.*;
import java.util.List;

/**
 * @Date:2019/6/1
 * @Description:
 * @version:1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class UsersTest {

    public String conf_filename = System.getProperty("user.dir")+"\\src\\main\\resources\\fdfs_client.conf";
    public String local_filename = "C:\\Users\\56828\\Pictures\\Saved Pictures\\00008.png";//要上传的文件

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersMapping usersMapping;

    @Test
    public void selectUsers() {
        List<Users> users = usersMapping.selectUsersAll();
        for (Users user : users) {
            System.out.println(user.getName());
        }
    }

    @Test
    public void selectUserList() {
        List<Users> users = usersService.selectUsers();
        for (Users user : users) {
            System.out.println(user.getName());
        }

        usersService.selectUsers();
    }
    @Test
    public void selectUser() {
        System.out.println("第一次查询");
        List<Users> users = usersService.selectUsersById(1);
        for (Users user : users) {
            System.out.println(user.getName());
        }
        System.out.println("第二次查询");
        List<Users> users1 = usersService.selectUsersById(2);
        for (Users user : users1) {
            System.out.println(user.getName());
        }
        System.out.println("第三次查询");
        List<Users> users2 = usersService.selectUsersById(1);
        for (Users user : users2) {
            System.out.println(user.getName());
        }

    }

    @Test
    public void selectUserIdName() {
        System.out.println("第一次查询");
        List<Users> users = usersService.selectUsersByIdName(new Users(1,"qwe",null));
        System.out.println(users.size());
        for (Users user : users) {
            System.out.println(user.getId());
        }
        System.out.println("第二次查询");
        List<Users> users1 = usersService.selectUsersByIdName(new Users(2,"qwe",null));
        System.out.println(users1.size());
        for (Users user : users1) {
            System.out.println(user.getId());
        }
        System.out.println("第三次查询");
        List<Users> users2 = usersService.selectUsersByIdName(new Users(2,"qwe",null));
        System.out.println(users2.size());
        for (Users user : users2) {
            System.out.println(user.getId());
        }

    }

    @Test
    public void fastDfs(){
        try {
            ClientGlobal.init(conf_filename);
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;
            StorageClient storageClient = new StorageClient(trackerServer,storageServer);
            byte[] buffer = null;
            File file=new File(local_filename);
            try
            {
                FileInputStream fis = new FileInputStream(file);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] b = new byte[1024];
                int n;
                while ((n = fis.read(b)) != -1)
                {
                    bos.write(b, 0, n);
                }
                fis.close();
                bos.close();
                buffer = bos.toByteArray();
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
//            buffer

            // 图片元数据,如果设置为空，那么服务器上不会生成-m的原数据文件
            NameValuePair[] meta_list = new NameValuePair[2];
            meta_list[0] = new NameValuePair();
            meta_list[1] = new NameValuePair();
            String[] strings = storageClient.upload_file(buffer, file.getName(), null);
            System.out.println(strings.length);
            // NameValuePair nvp = new NameValuePair("age", "18");







        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
