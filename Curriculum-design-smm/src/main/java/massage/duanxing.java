package massage;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class duanxing {
	public static void sendMassage() throws HttpException, IOException {
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://gbk.api.smschinese.cn"); 
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//��ͷ�ļ�������ת��
		NameValuePair[] data ={ 
				new NameValuePair("Uid", "bggzs1"),
				new NameValuePair("Key", "d41d8cd98f00b204e980"),
				new NameValuePair("smsMob","13758825386"),
				new NameValuePair("smsText","��֤�룺��ǩ�����ݡ�")
		};
		post.setRequestBody(data);

		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:"+statusCode);
		for(Header h : headers)
		{
			System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes("gbk")); 
		System.out.println(result); //��ӡ������Ϣ״̬


		post.releaseConnection();
	}
}
