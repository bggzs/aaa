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
		f1.setFault_type("门富士定型机不开机");
		f1.setFault_msg("主要检查启动部份电路   062/80 +D1  按下主启动按钮前，必须先按警铃，按下警铃按钮后，+D1 =062-K91时间继电器工作，7秒后要以按启动按钮，若无法启动，直接手工按动+D1=062-K30接触器，若接触器能吸合，机器能运转，说明故障出在中间电路，依次查 +F1=062-K63,+F2 =121-K34 +F2=062-K64  +D1=062-K43 +D1=062-K18  +D1=062-K90 +D1=062-K91 +D1=062-K25 +D1=062-K20 +D1=062-K41  检查所有零件的常闭触点有没有未导通的情况， 特别注意检查时间继电器有没有在运行状态，或时间继电器有故障存在，一般看指示灯就很容易分辨时间继电器有否存在故障");
		list.add(f1);
		fault f2=new fault();
		f2.setFault_type("门富士定型机不点火");
		f2.setFault_msg("经查，点火控制器无供电，供电由K08/09（以9号烘箱为例）继电器及合后供电，K08/09继电器是自吸式继电器，辅助供电电路由点火器伺服电机电电路板辅助触点，当风门没有回到位，即伺服电机没回到位，点火器无法供电，因此，点火器无供电，是因为K08/09未吸全中，出现此问题后，可以手动使伺服电机回位。 伺服电机与风门连杆的长度为10.5CM,点火针露出外面标准为4.2CM 或以上，检测探针露出外面为2.5CM 以上。");
		list.add(f2);
		fault f3=new fault();
		f3.setFault_type("滴液机转盘无法移动");
		f3.setFault_msg("当出现无法移动到下一转盘位置时，在缸杯转盘下面有两组传感器，其中，SETP组传感器被污染（露染料）或有灰尘或其它杂物挡信，用压缩空气吹去灰尘，呢要时拆下来清理。");
		list.add(f3);
		fault f4=new fault();
		f4.setFault_type("染缸升温后出现水位0或超100");
		f4.setFault_msg("出现此种情况，一般都是差压传感器清洗阀漏水导致，此情况通常出现在升温过程中，常压下，稍许的漏水不足以影响差压传感器的计量，但当缸内压力上升时，会将有小故障的阀门稍微顶开，导致水量测量不准，生产完毕后，将差压传感器前面的冲洗阀拆下，检查阀门漏的情况，通常为有杂质导致。");
		list.add(f4);
		String string="门富士定型机不开机";
		int res=findLCS(string, string.length(), f1.getFault_type(), f1.getFault_type().length());
		System.out.println(res);
		
		
	}

}
