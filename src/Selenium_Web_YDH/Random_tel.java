package Selenium_Web_YDH;

import java.util.Random;
/**
 * @author  ҿ�Ʋ�����
 * @time    2015��12��3��
 * @see     ʵ���������һ����1350000��ͷ�ĵ绰����
 */
public class Random_tel {

	String tel_back_4 = null;
    String tel="1350000";
	public String get_Random_Tel() {
		Random getTel = new Random();
		int j;
		String s = null;
		for (int i = 0; i < 4; i++) {//������ֵ��ַ���������
			j = (int) getTel.nextInt(9);//�������һ��0-9������
			s = Integer.toString(j);//����ת��Ϊ�ַ���
			if (i == 0)
				tel_back_4 = s;
			else
				tel_back_4 =tel_back_4+s;
		}
		tel=tel+tel_back_4;
		return tel;
	}
}