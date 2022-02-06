package com.jizhe.exshophd.util.qiniu;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Client;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;

/**
 * @author Ya <br/>
 * date: 2021/5/18 <br/>
 * <p>
 * description:
 * </p>
 */
@Service
public class QiniuPictureService {

    String accessKey = "LTG19Mo0HzIcgQHojpFYveZcyjsQ5jgc91bpx3xk";
    String secretKey = "KJzQhunIDybTee4ASFTT4Kn5W2wwPiaRaVzjLiXG";
    String bucket = "yapic1";

    public String createAuth(){
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(bucket);

    }
    public String deletepicture(String key){
        //对传入的key进行处理
        int index = key.indexOf("com");
        if(index != -1)
        {
            key = key.substring(index+4);
        }
        Auth auth = Auth.create(accessKey, secretKey);
        Configuration configuration = new Configuration(Region.huadong());
        Client client = new Client(configuration);
        BucketManager bucketManager = new BucketManager(auth,client);
        try{
            Response response = bucketManager.delete(bucket,key);
            if(response.statusCode==200)
            {
                return response.bodyString();
            }
            else
            {
                return response.error;
            }
        }catch (QiniuException ex){
            System.out.println("删除照片出现以下错误："+ex);
            return ex.toString();
        }

    }
}
