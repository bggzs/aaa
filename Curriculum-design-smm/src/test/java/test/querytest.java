package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bgg.ssm.entity.fault;
import com.sun.javafx.collections.MappingChange.Map;

public class querytest {
	public static int findLCS(String A, int n, String B, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }


		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<fault> list=new ArrayList<>();
		fault f1=new fault();
		f1.setFault_type("�Ÿ�ʿ���ͻ�������");
		f1.setFault_msg("��Ҫ����������ݵ�·   062/80 +D1  ������������ťǰ�������Ȱ����壬���¾��尴ť��+D1 =062-K91ʱ��̵���������7���Ҫ�԰�������ť�����޷�������ֱ���ֹ�����+D1=062-K30�Ӵ��������Ӵ��������ϣ���������ת��˵�����ϳ����м��·�����β� +F1=062-K63,+F2 =121-K34 +F2=062-K64  +D1=062-K43 +D1=062-K18  +D1=062-K90 +D1=062-K91 +D1=062-K25 +D1=062-K20 +D1=062-K41  �����������ĳ��մ�����û��δ��ͨ������� �ر�ע����ʱ��̵�����û��������״̬����ʱ��̵����й��ϴ��ڣ�һ�㿴ָʾ�ƾͺ����׷ֱ�ʱ��̵����з���ڹ���");
		list.add(f1);
		fault f2=new fault();
		f2.setFault_type("�Ÿ�ʿ���ͻ������");
		f2.setFault_msg("���飬���������޹��磬������K08/09����9�ź���Ϊ�����̵������Ϻ󹩵磬K08/09�̵���������ʽ�̵��������������·�ɵ�����ŷ�������·�帨�����㣬������û�лص�λ�����ŷ����û�ص�λ��������޷����磬��ˣ�������޹��磬����ΪK08/09δ��ȫ�У����ִ�����󣬿����ֶ�ʹ�ŷ������λ�� �ŷ������������˵ĳ���Ϊ10.5CM,�����¶�������׼Ϊ4.2CM �����ϣ����̽��¶������Ϊ2.5CM ���ϡ�");
		list.add(f2);
		fault f3=new fault();
		f3.setFault_type("��Һ��ת���޷��ƶ�");
		f3.setFault_msg("�������޷��ƶ�����һת��λ��ʱ���ڸױ�ת�����������鴫���������У�SETP�鴫��������Ⱦ��¶Ⱦ�ϣ����лҳ����������ﵲ�ţ���ѹ��������ȥ�ҳ�����Ҫʱ����������");
		list.add(f3);
		fault f4=new fault();
		f4.setFault_type("Ⱦ�����º����ˮλ0��100");
		f4.setFault_msg("���ִ��������һ�㶼�ǲ�ѹ��������ϴ��©ˮ���£������ͨ�����������¹����У���ѹ�£������©ˮ������Ӱ���ѹ�������ļ�������������ѹ������ʱ���Ὣ��С���ϵķ�����΢����������ˮ��������׼��������Ϻ󣬽���ѹ������ǰ��ĳ�ϴ�����£���鷧��©�������ͨ��Ϊ�����ʵ��¡�");
		list.add(f4);
		String string="�Ÿ�ʿ���ͻ�������";
		int res=findLCS(string, string.length(), f1.getFault_type(), f1.getFault_type().length());
		System.out.println(res);
		
		
	}

}
