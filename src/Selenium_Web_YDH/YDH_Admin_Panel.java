package Selenium_Web_YDH;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
/**
 * @author  ҿ�Ʋ�����
 * @time    2015��12��7��
 * @see     �׶����Զ�������ͼ�λ��û����棨һ����������һ����ť��
 * @version V1.0
 * @since   Ԥ��ʵ��һ��������ϵͳ�������쳣��ͼ���������Ա��� 
 */ 

public class YDH_Admin_Panel extends JFrame implements ActionListener {
	JButton an,an1, an2, an3, an4,an5, an_login,an_logout,buttton_logo;
	
	JButton //�����������ر�
	         button_startBrower,button_endBrower,
	         //��¼ע��ģ��
	         button_mob_login,button_help_login,button_id_login,button_agent_login,button_staff_login,
	         button_enroll,button_find_password,button_find_username,
	         //����˶�����
	         button_order_replaceAgent,//���µ�   ��
	         button_order_check,button_order_finance_check,button_order_warehouseOut_check,button_order_diliverGoods_check,//�������
	         button_order_back,button_order_cancelDelete,button_order_delete,//ɾ��
	         button_order_goodRemark,//��Ʒ��ע
	         button_order_modify,button_order_addNote,button_order_modifyAddress,//�޸�
	         //������˻���
	         button_return_order_replaceAgent,//  ��  ���µ�
	         button_return_order_check,button_return_order_defind,button_return_order_refund,  //�˻������
	         button_return_order_back,button_return_order_cancelDelete,button_return_order_delete,   //ɾ��
	         button_return_order_addNote,    //�޸�
	         //������������
	         button_order_new,button_order_shopCat, button_orderPay, //����
	         button_order_agentModifyAddress,button_order_agentAddNote,button_order_agentCancel,//�޸� ������
	         //�������˻���
	         button_return_order_new,button_return_order_agentShopCat,
	         button_return_order_agentAddNote,button_return_order_agentCancel,
	         //������������������Ҫ�ǹ���˲����������ܣ��������ƶ����� �Ĺ��ܣ�
	         button_order_search,button_order_advancedSearch,
	         //��Ʒ��ť
	         button_newGood,button_showGood,button_deleteGood,button_modifyGood,button_shareGood,button_searchGood,button_AddUnit,
	         //��Ʒ����
	         button_newRootSort,button_newNextsort,button_deleteSort,button_seeNextSort,button_modifySort,
	         //��Ʒ���
	         button_SearchWareHouse,button_Procurement,//�ɹ����
	         button_inWareHouse,button_sellOut,button_outWareHouse,
	         //��Ʒ����
	         button_addSaleDiscount,button_addSaleDiscount2,button_addSalePromotion,button_addSalePresent,
	         //��������
	         button_addOrderSaleDiscount,button_addOrderSaleDiscount2,button_addOrderSalePromotion,button_addOrderSalePresent,
	         //��������Ʒ����       
	         button_agentGoods,
	         //�ʽ�ģ��
	         button_fundOpen,button_fundInitialize,button_fundRecharge,button_backRecharge,button_hongchong,button_confirmPay,
	         button_addBankAccount,button_deleteBankAccount,button_statisticsDeliverGoods,button_agentFundRecharge,
	         //ϵͳ�������
	         button_toSystemSuggest,button_agentToSystemSuggest,
	         //�����������η������
	         button_agentToAdminSuggest,button_deleteSuggent,	         
	         //�ͻ�
	         button_addClient,button_modifyClient,Button_deleteClient,button_addClientlevel,button_modifyClientlevel,
	         button_deleteClientlevel,button_topClientlevel,button_seeClientMessage,button_addOrdeleteArea,
	         //֪ͨģ��
	         button_newNotify,button_deleteNotify,button_makeNotify,button_agentMakeNotify,button_addNotifyClass,
	         button_topNotifyClass,button_modifyNotifyClass,button_deletrNotifyClass,
	         //һ������
	         button_testAll,button_productAll,
	         button_allGoods,button_allOrder,button_allClient,button_allSuggest,button_allfund,button_allNotify,
	         button_allGoodSale,button_allOrderSala,button_allGroupSale
	         ;
	JPanel panel_logo,panel_order,panel_goods,panel_fund,panel_notify,
	       panel_seting,panel_sala,panel_report,panel_agent,panel_oneKeyRun,panel_orther,
	       panel_login_enroll,panel_order_product,panel_order_agent;
	JLabel label_logo,label_chooseBrower,label_firefox,label_chrome,label_IE,label_choose_environment,
	       label_dinghuoduan,label_guanliduan;
    JTabbedPane xxk;//����һ��ѡ�
    JRadioButton g1,g2,g3,en1,en2;//��ѡ��ť
    ButtonGroup gg,ee;//��ѡ��ť����һ���飬Ĭ��һ��������ֻ��ѡһ����ť
    int  browser=0;//���ڼ�¼ѡ��������
    int  setting=0;//��������������ѡ��
	public static void main(String[] args) {
		YDH_Admin_Panel lx = new YDH_Admin_Panel();
	}

	public YDH_Admin_Panel() {
		
		
		
	  //�������
	
		panel_logo=new JPanel();
	
		panel_order=new JPanel();
		panel_order.setLayout(new  GridLayout(1,2));
	
		panel_agent=new JPanel();
		panel_fund=new JPanel();
		panel_notify=new JPanel();
		panel_goods=new JPanel();
		panel_sala=new JPanel();
		panel_report=new JPanel();
		panel_seting=new JPanel();
		panel_oneKeyRun=new JPanel();
		panel_orther=new JPanel();
		
	    //Image im1= Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/�����01.jpg"));
	    //Image im2= Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/������01.jpg"));
	    //Image im3= Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/denglu.png"));
	    panel_login_enroll=new JPanel();
		panel_order_product=new JPanel();
		//panel_order_product.repaint();
		panel_order_agent=new JPanel();
		//panel_order_agent.repaint();
		panel_order.add(panel_order_product);
		panel_order.add(panel_order_agent);
		
		//��ǩ����
		label_logo=new JLabel(new ImageIcon("image/yidinghuo_head4.gif"));		
		label_chooseBrower=new JLabel("  ѡ�������:",JLabel.RIGHT);
		label_chooseBrower.setForeground(Color.red);
		label_chooseBrower.setFont(new Font("��Բ",Font.BOLD,24));
		label_firefox=new JLabel(new ImageIcon("image/firefox_logo.png"));
		label_chrome=new JLabel(new ImageIcon("image/chrome_logo.png"));
		label_IE=new JLabel(new ImageIcon("image/IE_logo.png"));
		label_choose_environment=new JLabel("ѡ�񻷾�:",JLabel.RIGHT);
		label_choose_environment.setForeground(Color.red);
		label_choose_environment.setFont(new Font("��Բ",Font.BOLD,24));
		label_guanliduan=new JLabel(new ImageIcon("image/guanliduan.gif"));
		label_dinghuoduan=new JLabel(new ImageIcon("image/dinghuoduan.gif"));
		
		//�����ѡ��ѡ������
		g1=new JRadioButton("FireFox",true);//Ĭ��ѡ��FireFox�����
		g2=new JRadioButton("Chrome");
		g3=new JRadioButton("IE 11");
		gg=new ButtonGroup();
		gg.add(g1);
		gg.add(g2);
		gg.add(g3);
		g1.setFont(new Font("��Բ",Font.BOLD,15));
		g2.setFont(new Font("��Բ",Font.BOLD,15));
		g3.setFont(new Font("��Բ",Font.BOLD,15));
		
		
		
		//����ѡ��ѡ������
		en1=new JRadioButton("����");
		en2=new JRadioButton("����   ",true);
		ee=new ButtonGroup();
		ee.add(en1);
		ee.add(en2);
		en1.setFont(new Font("��Բ",Font.BOLD,20));
		en2.setFont(new Font("��Բ",Font.BOLD,20));
		
		//�����������ر�
		button_startBrower=new JButton("START");
		button_endBrower=new JButton("END");
		button_startBrower .setFont(new Font("����", 1, 10));
	    button_startBrower.setBackground(Color.red);
	    button_endBrower .setFont(new Font("����", 1, 10));
	    button_endBrower.setBackground(Color.red);
	    
	    
	    //һ������
	    button_allGoods=new JButton("һ����Ʒ");
	    button_allGoods.setFont(new Font("��Բ", 1, 18));
	    button_allGoods.setBackground(Color.cyan);	    
	    button_allOrder=new JButton("һ������");
	    button_allOrder.setFont(new Font("��Բ", 1, 18));
	    button_allOrder.setBackground(Color.cyan);
	    button_allClient=new JButton("һ���ͻ�");
	    button_allClient.setFont(new Font("��Բ", 1, 18));
	    button_allClient.setBackground(Color.cyan); 
	    button_allSuggest=new JButton("һ���������");
	    button_allSuggest.setFont(new Font("��Բ", 1, 12));
	    button_allSuggest.setBackground(Color.cyan);
	    button_allfund=new JButton("һ���ʽ��˺�");
	    button_allfund.setFont(new Font("��Բ", 1, 12));
	    button_allfund.setBackground(Color.cyan);
	    button_allNotify=new JButton("һ��֪ͨ����");
	    button_allNotify.setFont(new Font("��Բ", 1, 12));
	    button_allNotify.setBackground(Color.cyan);
	    button_allGoodSale=new JButton("һ����Ʒ����");
	    button_allGoodSale.setFont(new Font("��Բ", 1, 12));
	    button_allGoodSale.setBackground(Color.cyan);
	    button_allOrderSala=new JButton("һ����������");
	    button_allOrderSala.setFont(new Font("��Բ", 1, 12));
	    button_allOrderSala.setBackground(Color.cyan);
	    button_allGroupSale=new JButton("һ����ϴ���");
	    button_allGroupSale.setFont(new Font("��Բ", 1, 12));
	    button_allGroupSale.setBackground(Color.cyan);
		
		//ע���¼ģ��
		button_enroll=new JButton("ע��");
		button_agent_login=new JButton("�����̵�¼");
		button_help_login=new JButton("�˺����ֵ�¼");
		button_id_login=new JButton("�����ID��¼");
		button_mob_login=new JButton("�ֻ������¼");
		button_staff_login=new JButton("Ա����¼");
		button_find_password=new JButton("�һ�����");
		button_find_username=new JButton("�һ��û���");
		
		//����˶�������ť����		
		button_order_replaceAgent=new JButton("����˴��¶���");
		button_order_check=new JButton("�������");
		button_order_finance_check=new JButton("�������");
		button_order_warehouseOut_check=new JButton("�������");
		button_order_diliverGoods_check=new JButton("����ȷ��");
		button_order_back=new JButton("�����˻�");
		button_order_cancelDelete=new JButton("����˶�������ɾ��");
		button_order_delete=new JButton("����ɾ��");
		button_order_modify=new JButton("�����޸�");
		button_order_addNote=new JButton("����˶�����ע");
		button_order_modifyAddress=new JButton("������޸Ķ�����ַ");
		button_order_goodRemark=new JButton("������Ʒ��ע");
		
		
		
        //�����ʵ�ֶ�����������
		button_order_advancedSearch=new JButton("�����߼�����");
		button_order_search=new JButton("��������");//����Ҫʵ�֡����������������������˻򵥡������ѿͻ��ѡ���������Ʒ�������ѿ�桯
		
		button_return_order_replaceAgent=new JButton("����˴����˵�");  
		button_return_order_check=new JButton("�˵����");
		button_return_order_defind=new JButton("�˻�ȷ��");
		button_return_order_refund=new JButton("�˿�ȷ��");
		button_return_order_back=new JButton("�˻����˻�");
		button_return_order_cancelDelete=new JButton("�˵�����ɾ��");	
		//button_return_order_delete=new JButton("�˵�ɾ��");
		button_return_order_addNote=new JButton("������˵���ӱ�ע");
		
		//�����˶�����ť����		
		button_order_shopCat=new JButton("���ﳵ�µ�");
		button_order_new=new JButton("��������");
		button_order_agentModifyAddress=new JButton("�������޸Ķ�����ַ");
		button_order_agentAddNote=new JButton("��Ӷ�����ע");
		button_order_agentCancel=new JButton("��������������");
		button_orderPay=new JButton("��������");
		//�����˶�����ť����
		button_return_order_new=new JButton("�����˻���");
		button_return_order_agentShopCat=new JButton("���ﳵ���˻���");
        button_return_order_agentAddNote=new JButton("�˻�����ӱ�ע");
        button_return_order_agentCancel=new JButton("�˻�������");
        
        //��Ʒ��ť����
        button_newGood=new JButton("������Ʒ");
        button_deleteGood=new JButton("ɾ����Ʒ");
        button_modifyGood=new JButton("�޸���Ʒ");
        button_searchGood=new JButton("��Ʒ����");
        button_AddUnit=new JButton("������Ʒ��λ");
        button_shareGood=new JButton("��Ʒ����");
        button_SearchWareHouse=new JButton("����Ʒ���");
        button_Procurement=new JButton("�ɹ����");
        button_outWareHouse=new JButton("��������");
        button_inWareHouse=new JButton("�������");
        button_sellOut=new JButton("���۳���");
        button_addSaleDiscount=new JButton("��Ʒ���۴���");
        button_addSalePromotion=new JButton("��Ʒ���۴���");
        button_addSalePresent=new JButton("��Ʒ��������");
        button_addSaleDiscount2=new JButton("��Ʒ���ݴ���");
        button_addOrderSaleDiscount=new JButton("�������۴���");
        button_addOrderSaleDiscount2=new JButton("�������ݴ���");
        button_addOrderSalePromotion=new JButton("������������");
        button_addOrderSalePresent=new JButton("������������");
        button_agentGoods=new JButton("��������Ʒ����");
        
        //�ʽ���ذ�ť
        button_fundOpen=new JButton("�ʽ��˺ſ���");
        button_fundInitialize=new JButton("��ʼ���ʽ��˺�");
        button_fundRecharge=new JButton("�ʽ��ֵ");
        button_backRecharge=new JButton("�ʽ�ۿ�");
        button_hongchong=new JButton("���");
        button_confirmPay=new JButton("�տ�ȷ��");
        button_addBankAccount=new JButton("���������˺�");
        button_deleteBankAccount=new JButton("ɾ�������˺�");
        button_statisticsDeliverGoods=new JButton("����ͳ��");
        button_agentFundRecharge=new JButton("�������ʽ��ֵ");
        //�������
        button_agentToAdminSuggest=new JButton("�����������η������");
        button_deleteSuggent=new JButton("ɾ���������");
        button_toSystemSuggest=new JButton("�������ϵͳ�������");
        button_agentToSystemSuggest=new JButton("��������ϵͳ�������");
        //�ͻ�
        button_addClient=new JButton("�����ͻ�");
        button_modifyClient=new JButton("�޸Ŀͻ�");
        Button_deleteClient=new JButton("ɾ���ͻ�");
        button_addClientlevel=new JButton("��ӿͻ�����");
        button_modifyClientlevel=new JButton("�޸Ŀͻ�����");
        button_deleteClientlevel=new JButton("ɾ���ͻ�����");
        button_topClientlevel=new JButton("�ö��ͻ�����");
        button_seeClientMessage=new JButton("�鿴������Ϣ");
        button_addOrdeleteArea=new JButton("��/ɾ�ͻ�����");
        //֪ͨ
        button_newNotify=new JButton("����֪ͨ����");
        button_deleteNotify=new JButton("ɾ��֪ͨ����");
        button_makeNotify=new JButton("����˲鿴֪ͨ");
        button_agentMakeNotify=new JButton("�����˲鿴֪ͨ");
        button_addNotifyClass=new JButton("���֪ͨ����");
        button_topNotifyClass=new JButton("�ö�֪ͨ����");
        button_modifyNotifyClass=new JButton("�޸�֪ͨ����");
        button_deletrNotifyClass=new JButton("ɾ��֪ͨ����");
        //һ������
        button_testAll=new JButton("���Ի���һ�����в���");
        button_productAll=new JButton("��������һ�����в���");
        
		
		//ѡ�����
		xxk=new JTabbedPane();
		xxk.setBackground(Color.CYAN);
		xxk.setFont(new Font("��Բ",Font.BOLD,21));
		xxk.add("ע���¼",panel_login_enroll);
		xxk.add("����",panel_order);
		xxk.add("��Ʒ",panel_goods);
		xxk.add("�ʽ�",panel_fund);
		xxk.add("�ͻ�",panel_agent);	
		xxk.add("֪ͨ/����/����",panel_notify);
		//xxk.add("����",panel_report);
		//xxk.add("����",panel_seting);
		//xxk.add("����",panel_sala);		
		//xxk.add("һ������",panel_oneKeyRun);
		
		
		//ע���¼�������
		//panel_login_enroll.setLayout(new GridLayout(5,5));//��������
		panel_login_enroll.add(button_enroll);
		panel_login_enroll.add(button_mob_login);
		panel_login_enroll.add(button_help_login);
		panel_login_enroll.add(button_id_login);
		panel_login_enroll.add(button_agent_login);
		panel_login_enroll.add(button_staff_login);
		panel_login_enroll.add(button_find_password);
		panel_login_enroll.add(button_find_username);
		
		
		//����˶����������
		//panel_order_product.setLayout(new GridLayout(5,5,8,8));//��������
		//panel_order_product.add(label_guanliduan);
		panel_order_product.add(button_order_search);
		panel_order_product.add(button_order_advancedSearch);
		//���µ�
		panel_order_product.add(button_order_replaceAgent);
		panel_order_product.add(button_return_order_replaceAgent);
        //���������
		panel_order_product.add(button_order_check);
		//panel_order_product.add(button_order_finance_check);
		//panel_order_product.add(button_order_diliverGoods_check);
		//panel_order_product.add(button_order_warehouseOut_check);
		//�˻������
		panel_order_product.add(button_return_order_check);
		//panel_order_product.add(button_return_order_defind);
		//panel_order_product.add(button_return_order_refund);
		//������  ɾ	
		panel_order_product.add(button_order_back);
		panel_order_product.add(button_order_cancelDelete);
		//panel_order_product.add(button_order_delete);
		panel_order_product.add(button_order_goodRemark);
		panel_order_product.add(button_order_modify);
		panel_order_product.add(button_order_addNote);
		panel_order_product.add(button_order_modifyAddress);
		panel_order_product.add(button_return_order_back);
		panel_order_product.add(button_return_order_cancelDelete);
		//panel_order_product.add(button_return_order_delete);
		panel_order_product.add(button_return_order_addNote);
		panel_order_product.add(button_allOrder);
		//�����˶����������
		//panel_order_agent.setLayout(new GridLayout(5,5,8,8));//��������
		//panel_order_agent.add(label_dinghuoduan);
		panel_order_agent.add(button_order_shopCat);
		panel_order_agent.add(button_return_order_agentShopCat);
		panel_order_agent.add(button_order_new);
		panel_order_agent.add(button_return_order_new);
		panel_order_agent.add(button_order_agentModifyAddress);
		panel_order_agent.add(button_order_agentAddNote);
		panel_order_agent.add(button_order_agentCancel);
		panel_order_agent.add(button_return_order_agentAddNote);
		panel_order_agent.add(button_return_order_agentCancel);	
		panel_order_agent.add(button_orderPay);
		
		
		//orther�������
		//panel_orther.setLayout(new GridLayout(1,10));//��������
		panel_orther.add(label_choose_environment);
		panel_orther.add(en2);
		panel_orther.add(en1);
		panel_orther.add(label_chooseBrower);
		panel_orther.add(label_firefox);
		panel_orther.add(g1);
		panel_orther.add(label_chrome);
		panel_orther.add(g2);
		panel_orther.add(label_IE);
		panel_orther.add(g3);
		//panel_orther.add(button_startBrower);
		//panel_orther.add(button_endBrower);
		
		//��Ʒ�������
		panel_goods.add(button_newGood);
		panel_goods.add(button_deleteGood);
		panel_goods.add(button_modifyGood);
		panel_goods.add(button_searchGood);
		panel_goods.add(button_AddUnit);
		panel_goods.add(button_shareGood);
		panel_goods.add(button_SearchWareHouse);
		panel_goods.add(button_Procurement);		
		panel_goods.add(button_inWareHouse);
		panel_goods.add(button_sellOut);
		panel_goods.add(button_outWareHouse);
		panel_goods.add(button_addSaleDiscount);
		panel_goods.add(button_addSalePromotion);
		panel_goods.add(button_addSalePresent);
		panel_goods.add(button_addSaleDiscount2);
		panel_goods.add(button_addOrderSaleDiscount);
		panel_goods.add(button_addOrderSaleDiscount2);
		panel_goods.add(button_addOrderSalePresent);
		panel_goods.add(button_addOrderSalePromotion);
		panel_goods.add(button_agentGoods);
		panel_goods.add(button_allGoods);
		panel_goods.add(button_allGoodSale);
		panel_goods.add(button_allOrderSala);
		panel_goods.add(button_allGroupSale);
		//�ʽ�����������
		panel_fund.add(button_fundOpen);
		panel_fund.add(button_fundInitialize);
		panel_fund.add(button_fundRecharge);
		panel_fund.add(button_backRecharge);
		panel_fund.add(button_hongchong);
		panel_fund.add(button_confirmPay);
		panel_fund.add(button_addBankAccount);
		panel_fund.add(button_deleteBankAccount);
		panel_fund.add(button_statisticsDeliverGoods);
		panel_fund.add(button_agentFundRecharge);
		panel_fund.add(button_allfund);
		//�������
		panel_notify.add(button_agentToAdminSuggest);
		panel_notify.add(button_deleteSuggent);
		panel_notify.add(button_toSystemSuggest);
        panel_notify.add(button_agentToSystemSuggest);
		
		//�ͻ�
		panel_agent.add(button_addClient);
		panel_agent.add(button_modifyClient);
		panel_agent.add(Button_deleteClient);
		panel_agent.add(button_addClientlevel);
		panel_agent.add(button_modifyClientlevel);
		panel_agent.add(button_deleteClientlevel);
		panel_agent.add(button_topClientlevel);
		panel_agent.add(button_seeClientMessage);
		panel_agent.add(button_addOrdeleteArea);
		panel_agent.add(button_allClient);
		//֪ͨ
		panel_notify.add(button_newNotify);
		panel_notify.add(button_deleteNotify);
		panel_notify.add(button_makeNotify);
		panel_notify.add(button_agentMakeNotify);
		panel_notify.add(button_addNotifyClass);
		panel_notify.add(button_topNotifyClass);
		panel_notify.add(button_modifyNotifyClass);
		panel_notify.add(button_deletrNotifyClass);
		panel_notify.add(button_allNotify);
		panel_notify.add(button_allSuggest);
        //һ������
		panel_oneKeyRun.add(button_testAll);
		panel_oneKeyRun.add(button_productAll);
		
		
		
		//��������
		this.add(label_logo,BorderLayout.NORTH);
		this.add(xxk,BorderLayout.CENTER);
		this.add(panel_orther,BorderLayout.SOUTH);
		
		
        //��ť��ش���
		//����������ر�
		button_startBrower.addActionListener(this);
		button_startBrower.setActionCommand("���������");
		button_endBrower.addActionListener(this);
		button_endBrower.setActionCommand("�ر������");			
		//��¼ע��ģ��
		button_enroll.addActionListener(this);//this ��ָһ����
		button_enroll.setActionCommand("ע��");// ��ť��ʾ����ť
		button_help_login.addActionListener(this);
		button_help_login.setActionCommand("�˺����ֵ�¼");
		button_mob_login.addActionListener(this);
		button_mob_login.setActionCommand("�ֻ������¼");
		button_id_login.addActionListener(this);
		button_id_login.setActionCommand("�����ID��¼");
		button_agent_login.addActionListener(this);
		button_agent_login.setActionCommand("�����̵�¼");
		button_staff_login.addActionListener(this);
		button_staff_login.setActionCommand("Ա����¼");
		button_find_password.addActionListener(this);
		button_find_password.setActionCommand("�һ�����");
		button_find_username.addActionListener(this);
		button_find_username.setActionCommand("�һ��û���");
		//����ģ��
		button_order_search.addActionListener(this);
		button_order_search.setActionCommand("��������");
		button_order_advancedSearch.addActionListener(this);
		button_order_advancedSearch.setActionCommand("�����߼�����");
		
		button_order_replaceAgent.addActionListener(this);
		button_order_replaceAgent.setActionCommand("����˴��¶���");
		button_order_shopCat.addActionListener(this);
		button_order_shopCat.setActionCommand("���ﳵ�µ�");
		button_return_order_agentShopCat.addActionListener(this);
		button_return_order_agentShopCat.setActionCommand("���ﳵ���˻���");
		button_order_check.addActionListener(this);
		button_order_check.setActionCommand("�������");
		button_return_order_check.addActionListener(this);
		button_return_order_check.setActionCommand("�˵����");
		button_return_order_replaceAgent.addActionListener(this);
		button_return_order_replaceAgent.setActionCommand("����˴����˻���");	
		button_order_back.addActionListener(this);
		button_order_back.setActionCommand("�����˻�");
		button_order_cancelDelete.addActionListener(this);
		button_order_cancelDelete.setActionCommand("����˶�������ɾ��");
		button_return_order_cancelDelete.addActionListener(this);
		button_return_order_cancelDelete.setActionCommand("�˵�����ɾ��");
		button_order_goodRemark.addActionListener(this);
		button_order_goodRemark.setActionCommand("������Ʒ��ע");
		button_order_addNote.addActionListener(this);
		button_order_addNote.setActionCommand("����˶�����ע");
		button_order_modify.addActionListener(this);
		button_order_modify.setActionCommand("�����޸�");
		button_return_order_back.addActionListener(this);
		button_return_order_back.setActionCommand("�˻����˻�");
		button_return_order_addNote.addActionListener(this);
		button_return_order_addNote.setActionCommand("�˻�����ע");
		button_order_modifyAddress.addActionListener(this);
		button_order_modifyAddress.setActionCommand("������޸Ķ�����ַ");
		button_order_new.addActionListener(this);
		button_order_new.setActionCommand("��������������");
		button_return_order_new.addActionListener(this);
		button_return_order_new.setActionCommand("�����������˻���");
		button_order_agentModifyAddress.addActionListener(this);
		button_order_agentModifyAddress.setActionCommand("�������޸Ķ�����ַ");
		button_order_agentAddNote.addActionListener(this);
		button_order_agentAddNote.setActionCommand("��������Ӷ�����ע");
		button_order_agentCancel.addActionListener(this);
		button_order_agentCancel.setActionCommand("�����˶�������");
		button_return_order_agentAddNote.addActionListener(this);
		button_return_order_agentAddNote.setActionCommand("�������˻�����ӱ�ע");
		button_return_order_agentCancel.addActionListener(this);
		button_return_order_agentCancel.setActionCommand("�������˻�������");
	    //button_return_order_agentCancel.setContentAreaFilled(false);//��ť����͸������
		//button_return_order_agentCancel.setPreferredSize(new Dimension(120,30));//��ť��С����
		button_newGood.addActionListener(this);
		button_newGood.setActionCommand("��Ʒ����");
		button_deleteGood.addActionListener(this);
		button_deleteGood.setActionCommand("ɾ����Ʒ");
		button_modifyGood.addActionListener(this);
		button_modifyGood.setActionCommand("�޸���Ʒ");
		button_searchGood.addActionListener(this);
		button_searchGood.setActionCommand("��Ʒ����");
		button_AddUnit.addActionListener(this);
		button_AddUnit.setActionCommand("������Ʒ��λ");
		button_shareGood.addActionListener(this);
		button_shareGood.setActionCommand("��Ʒ����");
		button_SearchWareHouse.addActionListener(this);
		button_SearchWareHouse.setActionCommand("����Ʒ���");
		button_Procurement.addActionListener(this);
		button_Procurement.setActionCommand("�ɹ����");
		button_outWareHouse.addActionListener(this);
		button_outWareHouse.setActionCommand("��������");
		button_sellOut.addActionListener(this);
		button_sellOut.setActionCommand("���۳���");
		button_inWareHouse.addActionListener(this);
		button_inWareHouse.setActionCommand("�������");
		button_addSaleDiscount.addActionListener(this);
		button_addSaleDiscount.setActionCommand("��Ʒ���۴���");
		button_addSalePromotion.addActionListener(this);
		button_addSalePromotion.setActionCommand("��Ʒ���۴���");
		button_addSalePresent.addActionListener(this);
		button_addSalePresent.setActionCommand("��Ʒ��������");
		button_addSaleDiscount2.addActionListener(this);
		button_addSaleDiscount2.setActionCommand("��Ʒ���ݴ���");
		button_addOrderSaleDiscount.addActionListener(this);
		button_addOrderSaleDiscount.setActionCommand("�������۴���");
		button_addOrderSaleDiscount2.addActionListener(this);
		button_addOrderSaleDiscount2.setActionCommand("�������ݴ���");
		button_addOrderSalePresent.addActionListener(this);
		button_addOrderSalePresent.setActionCommand("������������");
		button_addOrderSalePromotion.addActionListener(this);
		button_addOrderSalePromotion.setActionCommand("������������");
		button_agentGoods.addActionListener(this);
		button_agentGoods.setActionCommand("��������Ʒ����");
		button_orderPay.addActionListener(this);
		button_orderPay.setActionCommand("��������");
		button_toSystemSuggest.addActionListener(this);
		button_toSystemSuggest.setActionCommand("�������ϵͳ�������");
		button_agentToSystemSuggest.addActionListener(this);
		button_agentToSystemSuggest.setActionCommand("��������ϵͳ�������");
		 button_fundOpen.addActionListener(this);
		 button_fundInitialize.addActionListener(this);
		 button_fundRecharge.addActionListener(this);
		 button_backRecharge.addActionListener(this);
		 button_hongchong.addActionListener(this);
		 button_confirmPay.addActionListener(this);
         button_addBankAccount.addActionListener(this);
         button_deleteBankAccount.addActionListener(this);
         button_statisticsDeliverGoods.addActionListener(this);
         button_fundOpen.setActionCommand("�ʽ��˺ſ���");
		 button_fundInitialize.setActionCommand("��ʼ���ʽ��˺�");
		 button_fundRecharge.setActionCommand("�ʽ��˺ų�ֵ");
		 button_backRecharge.setActionCommand("�ʽ��˺ſۿ�");
		 button_hongchong.setActionCommand("���");
		 button_confirmPay.setActionCommand("�տ�ȷ��");
         button_addBankAccount.setActionCommand("�����տ�����");
         button_deleteBankAccount.setActionCommand("ɾ���տ�����");
         button_statisticsDeliverGoods.setActionCommand("����ͳ��");
         button_agentFundRecharge.addActionListener(this);
         button_agentFundRecharge.setActionCommand("�������ʽ��ֵ");
         button_agentToAdminSuggest.addActionListener(this);
         button_agentToAdminSuggest.setActionCommand("�����������˷������");
         button_deleteSuggent.addActionListener(this);
         button_addClient.addActionListener(this);
         button_modifyClient.addActionListener(this);
         Button_deleteClient.addActionListener(this);
         button_addClientlevel.addActionListener(this);
         button_modifyClientlevel.addActionListener(this);
         button_deleteClientlevel.addActionListener(this);
         button_topClientlevel.addActionListener(this);
         button_seeClientMessage.addActionListener(this);
         button_addOrdeleteArea.addActionListener(this);
         button_newNotify.addActionListener(this);
         button_deleteNotify.addActionListener(this);
         button_makeNotify.addActionListener(this);
         button_agentMakeNotify.addActionListener(this);
         button_addNotifyClass.addActionListener(this);
         button_topNotifyClass.addActionListener(this);
         button_modifyNotifyClass.addActionListener(this);
         button_deletrNotifyClass.addActionListener(this);
         button_deleteSuggent.setActionCommand("ɾ���������");
         button_addClient.setActionCommand("�����ͻ�");
         button_modifyClient.setActionCommand("�޸Ŀͻ�");
         Button_deleteClient.setActionCommand("ɾ���ͻ�");
         button_addClientlevel.setActionCommand("��ӿͻ�����");
         button_modifyClientlevel.setActionCommand("�޸Ŀͻ�����");
         button_deleteClientlevel.setActionCommand("ɾ���ͻ�����");
         button_topClientlevel.setActionCommand("�ö��ͻ�����");
         button_seeClientMessage.setActionCommand("�鿴������Ϣ");
         button_addOrdeleteArea.setActionCommand("��/ɾ�ͻ�����");
         button_newNotify.setActionCommand("����֪ͨ����");
         button_deleteNotify.setActionCommand("ɾ��֪ͨ����");
         button_makeNotify.setActionCommand("����˲鿴֪ͨ");
         button_agentMakeNotify.setActionCommand("�����˲鿴֪ͨ");
         button_addNotifyClass.setActionCommand("���֪ͨ����");
         button_topNotifyClass.setActionCommand("�ö�֪ͨ����");
         button_modifyNotifyClass.setActionCommand("�޸�֪ͨ����");
         button_deletrNotifyClass.setActionCommand("ɾ��֪ͨ����");
		 button_testAll.addActionListener(this);
		 button_testAll.setActionCommand("���Ի���һ�����в���");
		 button_productAll.addActionListener(this);
		 button_productAll.setActionCommand("��������һ�����в���");
		 button_allClient.addActionListener(this);
		 button_allfund.addActionListener(this);
		 button_allGoods.addActionListener(this);
		 button_allNotify.addActionListener(this);
		 button_allOrder.addActionListener(this);
		 button_allSuggest.addActionListener(this);
		 button_allGoods.setActionCommand("һ����Ʒ");
		 button_allOrder.setActionCommand("һ������");
		 button_allClient.setActionCommand("һ���ͻ�");
		 button_allSuggest.setActionCommand("һ���������");
		 button_allfund.setActionCommand("һ���ʽ��˺�");
		 button_allNotify.setActionCommand("һ��֪ͨ����");	 	
		 button_allGoodSale.addActionListener(this);
		 button_allGroupSale.addActionListener(this);
		 button_allOrderSala.addActionListener(this);
		 button_allGoodSale.setActionCommand("һ����Ʒ����");
		 button_allGroupSale.setActionCommand("һ����ϴ���");
		 button_allOrderSala.setActionCommand("һ����������");
		//��ť��С����      
		button_mob_login.setPreferredSize(new Dimension(120,30));
		button_help_login.setPreferredSize(new Dimension(120,30));
		button_id_login.setPreferredSize(new Dimension(120,30));
		button_agent_login.setPreferredSize(new Dimension(120,30));
		button_staff_login.setPreferredSize(new Dimension(120,30));
		button_enroll.setPreferredSize(new Dimension(120,30));
		button_find_password.setPreferredSize(new Dimension(120,30));
		button_find_username.setPreferredSize(new Dimension(120,30));
		button_order_replaceAgent.setPreferredSize(new Dimension(120,30));	         
		button_order_check.setPreferredSize(new Dimension(120,30));
		button_order_finance_check.setPreferredSize(new Dimension(120,30));
		button_order_warehouseOut_check.setPreferredSize(new Dimension(120,30));
		button_order_diliverGoods_check.setPreferredSize(new Dimension(120,30));	         
		button_order_back.setPreferredSize(new Dimension(120,30));
		button_order_cancelDelete.setPreferredSize(new Dimension(120,30));
		button_order_delete.setPreferredSize(new Dimension(120,30));
		button_order_goodRemark.setPreferredSize(new Dimension(120,30));	         
		button_order_modify.setPreferredSize(new Dimension(120,30));
		button_order_addNote.setPreferredSize(new Dimension(120,30));
		button_order_modifyAddress.setPreferredSize(new Dimension(120,30));
		button_return_order_replaceAgent.setPreferredSize(new Dimension(120,30));
		button_return_order_check.setPreferredSize(new Dimension(120,30));
		button_return_order_defind.setPreferredSize(new Dimension(120,30));
		button_return_order_refund.setPreferredSize(new Dimension(120,30));
		button_return_order_back.setPreferredSize(new Dimension(120,30));
		button_return_order_cancelDelete.setPreferredSize(new Dimension(120,30));
		button_return_order_addNote.setPreferredSize(new Dimension(120,30));  
		button_order_new.setPreferredSize(new Dimension(120,30));
		button_order_shopCat.setPreferredSize(new Dimension(120,30));  
		button_order_agentModifyAddress.setPreferredSize(new Dimension(120,30));
		button_order_agentAddNote.setPreferredSize(new Dimension(120,30));
		button_order_agentCancel.setPreferredSize(new Dimension(120,30));	     	         
		button_return_order_new.setPreferredSize(new Dimension(120,30));
		button_return_order_agentShopCat.setPreferredSize(new Dimension(120,30));
		button_return_order_agentAddNote.setPreferredSize(new Dimension(120,30));
		button_return_order_agentCancel.setPreferredSize(new Dimension(120,30));
		button_order_search.setPreferredSize(new Dimension(120,30));
		button_order_advancedSearch.setPreferredSize(new Dimension(120,30));
		button_orderPay.setPreferredSize(new Dimension(120,30));
		button_allGoods.setPreferredSize(new Dimension(120,30));
		button_allOrder.setPreferredSize(new Dimension(120,30));
		button_allNotify.setPreferredSize(new Dimension(120,30));
		button_allClient.setPreferredSize(new Dimension(120,30));
		button_allSuggest.setPreferredSize(new Dimension(120,30));
		button_allfund.setPreferredSize(new Dimension(120,30));
		button_newGood.setPreferredSize(new Dimension(120,30));
		button_deleteGood.setPreferredSize(new Dimension(120,30));
		button_modifyGood.setPreferredSize(new Dimension(120,30));
		button_shareGood.setPreferredSize(new Dimension(120,30));
		button_searchGood.setPreferredSize(new Dimension(120,30));
		button_AddUnit.setPreferredSize(new Dimension(120,30));	        
		button_allGoodSale.setPreferredSize(new Dimension(120,30));	 
		button_allGroupSale.setPreferredSize(new Dimension(120,30));	 
		button_allOrderSala.setPreferredSize(new Dimension(120,30));	 

		button_SearchWareHouse.setPreferredSize(new Dimension(120,30));
		button_Procurement.setPreferredSize(new Dimension(120,30));
		button_inWareHouse.setPreferredSize(new Dimension(120,30));
		button_sellOut.setPreferredSize(new Dimension(120,30));
		button_outWareHouse.setPreferredSize(new Dimension(120,30));	         
		button_addSaleDiscount.setPreferredSize(new Dimension(120,30));
		button_addSaleDiscount2.setPreferredSize(new Dimension(120,30));
		button_addSalePromotion.setPreferredSize(new Dimension(120,30));
		button_addSalePresent.setPreferredSize(new Dimension(120,30));	         
		button_addOrderSaleDiscount.setPreferredSize(new Dimension(120,30));
		button_addOrderSaleDiscount2.setPreferredSize(new Dimension(120,30));
		button_addOrderSalePromotion.setPreferredSize(new Dimension(120,30));
		button_addOrderSalePresent.setPreferredSize(new Dimension(120,30));
		button_agentGoods.setPreferredSize(new Dimension(120,30));	         
		button_fundOpen.setPreferredSize(new Dimension(120,30));
		button_fundInitialize.setPreferredSize(new Dimension(120,30));
		button_fundRecharge.setPreferredSize(new Dimension(120,30));
		button_backRecharge.setPreferredSize(new Dimension(120,30));
		button_hongchong.setPreferredSize(new Dimension(120,30));
		button_confirmPay.setPreferredSize(new Dimension(120,30));
		button_addBankAccount.setPreferredSize(new Dimension(120,30));
		button_deleteBankAccount.setPreferredSize(new Dimension(120,30));
		button_statisticsDeliverGoods.setPreferredSize(new Dimension(120,30));
		button_agentFundRecharge.setPreferredSize(new Dimension(120,30));
		button_toSystemSuggest.setPreferredSize(new Dimension(120,30));
		button_agentToSystemSuggest.setPreferredSize(new Dimension(120,30));
		button_agentToAdminSuggest.setPreferredSize(new Dimension(120,30));
		button_deleteSuggent.setPreferredSize(new Dimension(120,30));	         	         
		button_addClient.setPreferredSize(new Dimension(120,30));
		button_modifyClient.setPreferredSize(new Dimension(120,30));
		Button_deleteClient.setPreferredSize(new Dimension(120,30));
		button_addClientlevel.setPreferredSize(new Dimension(120,30));
		button_modifyClientlevel.setPreferredSize(new Dimension(120,30));	         
		button_deleteClientlevel.setPreferredSize(new Dimension(120,30));
		button_topClientlevel.setPreferredSize(new Dimension(120,30));
		button_seeClientMessage.setPreferredSize(new Dimension(120,30));
		button_addOrdeleteArea.setPreferredSize(new Dimension(120,30));	             
		button_newNotify.setPreferredSize(new Dimension(120,30));
		button_deleteNotify.setPreferredSize(new Dimension(120,30));
		button_makeNotify.setPreferredSize(new Dimension(120,30));
		button_agentMakeNotify.setPreferredSize(new Dimension(120,30));
		button_addNotifyClass.setPreferredSize(new Dimension(120,30));	         
		button_topNotifyClass.setPreferredSize(new Dimension(120,30));
		button_modifyNotifyClass.setPreferredSize(new Dimension(120,30));
		button_deletrNotifyClass.setPreferredSize(new Dimension(120,30));
		
		
		//��ť����ƶ���ȥ������ʾ
		button_mob_login.setToolTipText(button_mob_login.getText());
		button_help_login.setToolTipText(button_help_login.getText());
		button_id_login.setToolTipText(button_id_login.getText());
		button_agent_login.setToolTipText(button_agent_login.getText());
		button_staff_login.setToolTipText(button_staff_login.getText());
		button_enroll.setToolTipText(button_enroll.getText());
		button_find_password.setToolTipText(button_find_password.getText());
		button_find_username.setToolTipText(button_find_username.getText());
		button_order_replaceAgent.setToolTipText(button_order_replaceAgent.getText());
		button_order_check.setToolTipText(button_order_check.getText());
		button_order_finance_check.setToolTipText(button_order_finance_check.getText());
		button_order_warehouseOut_check.setToolTipText(button_order_warehouseOut_check.getText());
		button_order_diliverGoods_check.setToolTipText(button_order_diliverGoods_check.getText());
		button_order_back.setToolTipText(button_order_back.getText());
		button_order_cancelDelete.setToolTipText(button_order_cancelDelete.getText());
		button_order_delete.setToolTipText(button_order_delete.getText());
		button_order_goodRemark.setToolTipText(button_order_goodRemark.getText());
		button_order_modify.setToolTipText(button_order_modify.getText());
		button_order_addNote.setToolTipText(button_order_addNote.getText());
		button_order_modifyAddress.setToolTipText(button_order_modifyAddress.getText());
		button_return_order_replaceAgent.setToolTipText(button_return_order_replaceAgent.getText());
		button_return_order_check.setToolTipText(button_return_order_check.getText());
		button_return_order_defind.setToolTipText(button_return_order_defind.getText());
		button_return_order_refund.setToolTipText(button_return_order_refund.getText());
		button_return_order_back.setToolTipText(button_return_order_back.getText());
		button_return_order_cancelDelete.setToolTipText(button_return_order_cancelDelete.getText());
		button_return_order_addNote  .setToolTipText(button_return_order_addNote  .getText());
		button_order_new.setToolTipText(button_order_new.getText());
		button_order_shopCat  .setToolTipText(button_order_shopCat  .getText());
		button_order_agentModifyAddress.setToolTipText(button_order_agentModifyAddress.getText());
		button_order_agentAddNote.setToolTipText(button_order_agentAddNote.getText());
		button_order_agentCancel.setToolTipText(button_order_agentCancel.getText());
		button_return_order_new.setToolTipText(button_return_order_new.getText());
		button_return_order_agentShopCat.setToolTipText(button_return_order_agentShopCat.getText());
		button_return_order_agentAddNote.setToolTipText(button_return_order_agentAddNote.getText());
		button_return_order_agentCancel.setToolTipText(button_return_order_agentCancel.getText());
		button_order_search.setToolTipText(button_order_search.getText());
		button_order_advancedSearch.setToolTipText(button_order_advancedSearch.getText());  		
		button_SearchWareHouse.setToolTipText(button_SearchWareHouse.getText());
		button_Procurement.setToolTipText(button_Procurement.getText());
		button_inWareHouse.setToolTipText(button_inWareHouse.getText());
		button_sellOut.setToolTipText(button_sellOut.getText());
		button_outWareHouse.setToolTipText(button_outWareHouse.getText());
		button_addSaleDiscount.setToolTipText(button_addSaleDiscount.getText());
		button_addSaleDiscount2.setToolTipText(button_addSaleDiscount2.getText());
		button_addSalePromotion.setToolTipText(button_addSalePromotion.getText());
		button_addSalePresent.setToolTipText(button_addSalePresent.getText());
		button_addOrderSaleDiscount.setToolTipText(button_addOrderSaleDiscount.getText());
		button_addOrderSaleDiscount2.setToolTipText(button_addOrderSaleDiscount2.getText());
		button_addOrderSalePromotion.setToolTipText(button_addOrderSalePromotion.getText());
		button_addOrderSalePresent.setToolTipText(button_addOrderSalePresent.getText());
		button_agentGoods.setToolTipText(button_agentGoods.getText());
		button_fundOpen.setToolTipText(button_fundOpen.getText());
		button_fundInitialize.setToolTipText(button_fundInitialize.getText());
		button_fundRecharge.setToolTipText(button_fundRecharge.getText());
		button_backRecharge.setToolTipText(button_backRecharge.getText());
		button_hongchong.setToolTipText(button_hongchong.getText());
		button_confirmPay.setToolTipText(button_confirmPay.getText());
		button_addBankAccount.setToolTipText(button_addBankAccount.getText());
		button_deleteBankAccount.setToolTipText(button_deleteBankAccount.getText());
		button_statisticsDeliverGoods.setToolTipText(button_statisticsDeliverGoods.getText());
		button_agentFundRecharge.setToolTipText(button_agentFundRecharge.getText());
		button_toSystemSuggest.setToolTipText(button_toSystemSuggest.getText());
		button_agentToSystemSuggest.setToolTipText(button_agentToSystemSuggest.getText());
		button_agentToAdminSuggest.setToolTipText(button_agentToAdminSuggest.getText());
		button_deleteSuggent.setToolTipText(button_deleteSuggent.getText());
		button_addClient.setToolTipText(button_addClient.getText());
		button_modifyClient.setToolTipText(button_modifyClient.getText());
		Button_deleteClient.setToolTipText(Button_deleteClient.getText());
		button_addClientlevel.setToolTipText(button_addClientlevel.getText());
		button_modifyClientlevel.setToolTipText(button_modifyClientlevel.getText());
		button_deleteClientlevel.setToolTipText(button_deleteClientlevel.getText());
		button_topClientlevel.setToolTipText(button_topClientlevel.getText());
		button_seeClientMessage.setToolTipText(button_seeClientMessage.getText());
		button_addOrdeleteArea.setToolTipText(button_addOrdeleteArea.getText());
		button_newNotify.setToolTipText(button_newNotify.getText());
		button_deleteNotify.setToolTipText(button_deleteNotify.getText());
		button_makeNotify.setToolTipText(button_makeNotify.getText());
		button_agentMakeNotify.setToolTipText(button_agentMakeNotify.getText());
		button_addNotifyClass.setToolTipText(button_addNotifyClass.getText());
		button_topNotifyClass.setToolTipText(button_topNotifyClass.getText());
		button_modifyNotifyClass.setToolTipText(button_modifyNotifyClass.getText());
		button_deletrNotifyClass.setToolTipText(button_deletrNotifyClass.getText());


		//��ť����������ã��ǹ���ƶ���ȥ��ΪС����״��
		button_mob_login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_help_login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_id_login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_agent_login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_staff_login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_enroll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_find_password.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_find_username.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_replaceAgent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_check.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_finance_check.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_warehouseOut_check.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_diliverGoods_check.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_cancelDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_goodRemark.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_modify.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_addNote.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_modifyAddress.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_replaceAgent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_check.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_defind.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_refund.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_cancelDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_addNote  .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_new.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_shopCat  .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_agentModifyAddress.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_agentAddNote.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_agentCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_new.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_agentShopCat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_agentAddNote.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_agentCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_advancedSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		en1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		en2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		g1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		g2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		g3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
      //�����ѡ��ѡ����
	class Listener1 implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if (g1.isSelected()) browser=0;
                 else if (g2.isSelected()) browser=1;
                 else if (g3.isSelected()) browser=2;       
            }
        }
		g1.addActionListener(new Listener1());
		g2.addActionListener(new Listener1());
		g3.addActionListener(new Listener1());
		if(g1.isSelected()) browser=0;
		else if(g2.isSelected()) browser=1;
		else if(g3.isSelected()) browser=2;
		
		
	 //����ѡ��ѡ����
		class Listener2 implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if (en2.isSelected()) setting=0;
                 else if (en1.isSelected())setting=1;     
            }
        }
		en1.addActionListener(new Listener2());
		en2.addActionListener(new Listener2());
		if(en2.isSelected()) setting=0;
	    else if(en1.isSelected())setting=1;
				
		
		//��������
		this.setSize(1042, 700);
		this.setLocation(100, 20);
		this.setTitle("�׶����Զ�������ϵͳ");
		this.setIconImage(new ImageIcon("image/yi_logo.png").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
       // �¼���������
	
	   //ע���¼ģ���¼������������¼�
      public void actionPerformed(ActionEvent e) {
		TestCase testCase=new TestCase();
		if (e.getActionCommand().equals("ע��")) { 
			if(setting==1)
				JOptionPane.showMessageDialog(null, "Sorry,���������ݲ�֧�֡�ע�ᡱ�Զ������ԡ�����", "������ʾ", JOptionPane.ERROR_MESSAGE);
			else if(setting==0){
			try {
				testCase.setUp(browser);
				testCase.enroll();
				testCase.logout();
				testCase.tearDown();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		} else if (e.getActionCommand().equals("�ֻ������¼")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("18720091223","123456");
				else if(setting==1)
				testCase.login("18633333333","123456");
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("�˺����ֵ�¼")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login_help("13607099149","123456");
				else if(setting==1)
				testCase.login_help("18607099149","123456");
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�����ID��¼")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				//testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}	else if (e.getActionCommand().equals("�����̵�¼")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				//testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}	else if (e.getActionCommand().equals("Ա����¼")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("ku123","123456");
				else if(setting==1)
				testCase.login("autostaff","123456");
				//testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}   else if (e.getActionCommand().equals("�һ�����")) { 
			if(setting==1)
				JOptionPane.showMessageDialog(null, "Sorry,���������ݲ�֧�֡��һ����롱�Զ������ԡ�����", "������ʾ", JOptionPane.ERROR_MESSAGE);
		  else if(setting==0){
			try {
				testCase.setUp(browser);
				testCase.findPassword();
				testCase.tearDown();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			}
		}else if (e.getActionCommand().equals("�һ��û���")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.findUsername("3123512624@qq.com");//���Ի����˺Ű�����
				else if(setting==1)
			    testCase.findUsername("1533985604@qq.com");//���������˺Ű�����
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£���ϵͳ�쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}   else if (e.getActionCommand().equals("��������")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.orderSearch();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}  else if (e.getActionCommand().equals("�����߼�����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.advancedSearch();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}  else if (e.getActionCommand().equals("����˴��¶���")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.order_replaceAgent();
				testCase.logout();
				testCase.tearDown();	
				//JOptionPane.showMessageDialog(null, "Sorry,����˴��µ���ʱ��������������", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("����˴����˻���")) {
				try {
					testCase.setUp(browser);
					if(setting==0)
					testCase.login("310007707","123456");
					else if(setting==1)
					testCase.login("310021564","123456");
					testCase.returnOrder_replaceAgent();
					testCase.logout();
					testCase.tearDown();	
					//JOptionPane.showMessageDialog(null, "Sorry,����˴��µ���ʱ��������������", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			} else if (e.getActionCommand().equals("���ﳵ�µ�")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					//testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}	
				testCase.testShopcat();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("���ﳵ���˻���")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.backOrder();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("�������")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testShopcat();
				testCase.logout1();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");				
				testCase.orderCheck();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("�˵����")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.backOrder();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.ruturnOrderCheck();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("�����˻�")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testShopcat();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.orderBack();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("����˶�������ɾ��")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testShopcat();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.OrderCancelDelete();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("�˵�����ɾ��")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.backOrder();
				testCase.logout3();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.returnOrderCancelDelete();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("������Ʒ��ע")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testShopcat();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.goodRemark();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("����˶�����ע")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.testOrderRemark();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�����޸�")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testShopcat();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.testOrderModify();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("�˻����˻�")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.backOrder();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.testReturnOrderBack();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("�˻�����ע")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.backOrder();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.testReturnOrderRemark();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("������޸Ķ�����ַ")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testShopcat();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.orderModifyAddress();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("��������������")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testAgentNewOrder();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�����������˻���")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testAgentNewReturnOrder();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�������޸Ķ�����ַ")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testAgentNewOrder();
				testCase.testAgentModifyAddress();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("��������Ӷ�����ע")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testAgentNewOrder();
				testCase.testAgentOrderAddNote();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�����˶�������")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}	
				testCase.testAgentNewOrder();
				testCase.testAgentOrderCancel();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�������˻�����ӱ�ע")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}	
				testCase.testAgentNewReturnOrder();
				testCase.testAgentReturnOrderAddNote();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�������˻�������")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testAgentNewReturnOrder();
				testCase.testAgentReturnOrderCancel();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("��Ʒ����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310013008","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testAddGood();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("ɾ����Ʒ")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310013008","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testAddGood2();
				testCase.testDeleteGood();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�޸���Ʒ")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310013008","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testAddGood2();
				testCase.testModifyGood();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("��Ʒ����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testSearchGood();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("������Ʒ��λ")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testAddUnit();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("��Ʒ����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testAddGood2();
				testCase.testShareGood();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("����Ʒ���")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testSearchWarehouse();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�ɹ����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testProcurement();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("��������")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testOutWareHouse();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�������")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testInWareHouse();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("���۳���")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testSellOut();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("��Ʒ���۴���")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testSaleDiscount();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("��Ʒ���۴���")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testSalePromotion();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("��Ʒ��������")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testSalePresent();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("��Ʒ���ݴ���")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testSaleDiscount2();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}			
		}else if (e.getActionCommand().equals("�������۴���")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testOrderSaleDiscount();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("������������")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testOrderSalePromotion();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("������������")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testOrderSalePresent();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�������ݴ���")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testOrderSaleDiscount2();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("��������Ʒ����")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
				testCase.login("ku123456","123456");				
				testCase.closeBoundMessage();
				testCase.closeSystemInform();
				}
				else if(setting==1){
				testCase.login("autotest1","123456");
				testCase.closeBoundMessage();
				}
				testCase.testAgentGoods(0);
				testCase.logout3();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("��������")) {
			try {
				testCase.setUp(browser);
				if(setting==0){									
				testCase.login("ku123456","123456");				
				testCase.closeBoundMessage();
				testCase.closeSystemInform();
				}
				else if(setting==1){
				testCase.login("autotest1","123456");
				testCase.closeBoundMessage();
				}
				testCase.testShopcat();
				testCase.orderPay();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�ʽ��˺ſ���")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
				testCase.login("310007707","123456");				
				}
				else if(setting==1){
				testCase.login("310021564","123456");
				}
				testCase.closeOpenFund();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("��ʼ���ʽ��˺�")) {
			try {
				testCase.setUp(browser);
				if(setting==0)					
				testCase.login("310007707","123456");				
				else if(setting==1)
				testCase.login("310021564","123456");				
				testCase.fundInitialize();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ���ʽ��˺��Ƿ����������ʽ��˺��ѱ���ʼ��", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�ʽ��˺ų�ֵ")) {
			try {
				testCase.setUp(browser);
				if(setting==0)				
				testCase.login("310007707","123456");								
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.fundRecharge();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "��ȷ���Ƿ����ʽ��˺źͳ�ʼ���ʽ��˺ţ�����", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�ʽ��˺ſۿ�")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
				testCase.login("310007707","123456");				
				}
				else if(setting==1){
				testCase.login("310021564","123456");
				}
				testCase.backRecharge();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "��ȷ���Ƿ����ʽ��˺źͳ�ʼ���ʽ��˺ţ������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("���")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
				testCase.login("310007707","123456");				
				}
				else if(setting==1){
				testCase.login("310021564","123456");
				}
				testCase.hongChong();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "��ȷ���Ƿ����ʽ��˺źͳ�ʼ���ʽ��˺ţ��������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�տ�ȷ��")) {
			try {
				testCase.setUp(browser);
				if(setting==0){									
				testCase.login("ku123456","123456");				
				testCase.closeBoundMessage();
				testCase.closeSystemInform();
				}
			   else if(setting==1){
				testCase.login("autotest1","123456");
				testCase.closeBoundMessage();
					}
				testCase.testShopcat();
				testCase.orderPay();
				testCase.logout1();
				if(setting==0){					
				testCase.login("310007707","123456");				
				}
				else if(setting==1){
				testCase.login("310021564","123456");
				}				
				testCase.confirmPay();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�����տ�����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.addBankAccount();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£��������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("ɾ���տ�����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.deleteBankAccount();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ���Ƿ�����տ����У������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("����ͳ��")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.statisticsDeliverGoods();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�������ʽ��ֵ")) {
			try {
				testCase.setUp(browser);
				if(setting==0){									
				testCase.login("ku123456","123456");				
				testCase.closeBoundMessage();
				testCase.closeSystemInform();
				}
				else if(setting==1){
				testCase.login("autotest1","123456");
				testCase.closeBoundMessage();
				}
				testCase.testAgentFundRecharge();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�����������˷������")) {
			try {
				testCase.setUp(browser);
				testCase.testAgentToAdminSuggest(setting);
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("ɾ���������")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testDeleteSuggest();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "��ȷ���˺�310007707/310021564�Ƿ��п�ɾ���Ķ����˷������������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�����ͻ�")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testAddClient();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ�ϸ��˺�310007707/310021564�Ƿ�ﵽ�ͻ����ߣ�����������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�޸Ŀͻ�")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testModifyClient();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("ɾ���ͻ�")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testDeleteClient();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("��ӿͻ�����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testClientlevel();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�޸Ŀͻ�����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testModifyClientlevel();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("ɾ���ͻ�����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testDeleteClientlevel();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�ö��ͻ�����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testTopClientlevel();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�鿴������Ϣ")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testSeeClientMessage();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("��/ɾ�ͻ�����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testAddArea();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("����֪ͨ����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testNewNotify();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("ɾ��֪ͨ����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testDeleteNotify();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("����˲鿴֪ͨ")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testMakeNotify();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�����˲鿴֪ͨ")) {
			try {
				testCase.setUp(browser);
				if(setting==0){									
				testCase.login("ku123456","123456");				
				testCase.closeBoundMessage();
				testCase.closeSystemInform();
				}
				else if(setting==1){
				testCase.login("autotest1","123456");
				testCase.closeBoundMessage();
				}
				testCase.testAgentMakeNotify();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("���֪ͨ����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testAddNotifyClass();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�ö�֪ͨ����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testTopNotifyClass();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�޸�֪ͨ����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testModifyNotifyClass();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("ɾ��֪ͨ����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testDeleteNotifyClass();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("�������ϵͳ�������")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testToSystemSuggest();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("��������ϵͳ�������")) {
			try {
				testCase.setUp(browser);
				if(setting==0){									
				testCase.login("ku123456","123456");				
				testCase.closeBoundMessage();
				testCase.closeSystemInform();
				}
				else if(setting==1){			
				testCase.login("autotest1","123456");
				testCase.closeBoundMessage();
				}	
				testCase.testAgentToSystemSuggest();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("һ����Ʒ")) {
			try {
				testCase.setUp(browser);			
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				System.out.println("��ʼִ��������Ʒ��");
				testCase.testAddGood2();
		        System.out.println("������Ʒ����ͨ��������");
		        System.out.println("��ʼִ���޸���Ʒ��");
		        testCase.testModifyGood();
		        System.out.println("�޸���Ʒ����ͨ��������");
		        System.out.println("��ʼִ��������Ʒ������λ��");
				testCase.testAddUnit();
		        System.out.println("������Ʒ������λ����ͨ��������");
		        System.out.println("��ʼִ��������Ʒ��");
		        testCase.testSearchGood();
		        System.out.println("������Ʒ����ͨ��������");		        
		        System.out.println("��ʼִ����Ʒ�ɹ���⣡");
		        testCase.testProcurement();
		        System.out.println("��Ʒ�ɹ��������ִ��ͨ��������");
		        System.out.println("��ʼִ����Ʒ������⣡");
		        testCase.testInWareHouse();
		        System.out.println("��Ʒ�����������ִ��ͨ��������");
		        System.out.println("��ʼִ����Ʒ���۳��⣡");
		        testCase.testSellOut();
		        System.out.println("��Ʒ���۳�������ִ��ͨ��������");
		        System.out.println("��ʼִ����Ʒ�������⣡");
		        testCase.testOutWareHouse();
		        System.out.println("��Ʒ������������ִ��ͨ��������");
		        System.out.println("��ʼִ����Ʒ����");
		        testCase.testShareGood();
		        System.out.println("��Ʒ��������ִ��ͨ��������");
		        System.out.println("��ʼִ��������Ʒ��棡");
		        testCase.testSearchWarehouse();
		        System.out.println("������Ʒ�������ִ��ͨ��������");
		        System.out.println("��ʼִ��������Ʒ��棡");
		        testCase.testSearchWarehouse();
		        System.out.println("������Ʒ�������ִ��ͨ��������");
		        testCase.logout();
		        System.out.println("�������Ʒ������ɣ���ʼִ�ж�������Ʒ������������");
		        System.out.println("��Ʒһ����������ִ����ɡ�������ע��ִ�й����е��쳣���⡣");
		        if(setting==0){									
				testCase.login("ku123456","123456");				
				testCase.closeBoundMessage();
				testCase.closeSystemInform();
				}
				else if(setting==1){			
				testCase.login("autotest1","123456");
				testCase.closeBoundMessage();
				}	
		        System.out.println("��ʼִ�ж�������Ʒһϵ�в�����");
		        testCase.testAgentGoods(0);
		        System.out.println("��������Ʒϵ�в�������ִ��ͨ��������");
		        testCase.logout3();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£���\n���ٴ�ִ��һ�Σ��򵥶�ִ��û��ͨ����������", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("һ������")) {
			try {
				testCase.setUp(browser);	
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				System.out.println("��ʼִ�ж����˹������µ���");
				testCase.testShopcat();
				System.out.println("���ﳵ�µ�����ִ��ͨ��������");
				testCase.logout1();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				System.out.println("��ʼִ�ж�������ˣ�");
				testCase.orderCheck();
				System.out.println("���������ͨ��������");
				testCase.logout();
				if(setting==0){					
					testCase.login("ku123456","123456");				
					//testCase.closeBoundMessage();
					//testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					//testCase.closeBoundMessage();
					}
				System.out.println("��ʼִ�й��ﳵ���˻�����");
				testCase.backOrder();
				System.out.println("���ﳵ���˻�������ִ��ͨ��������");
				testCase.logout1();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				System.out.println("��ʼִ���˻�����ˣ�");
				testCase.ruturnOrderCheck();
				System.out.println("�˻����������ִ��ͨ��������");
				testCase.logout();
				System.out.println("��������������������ݽ��й��ﳵ�µ������ﳵ���˻�����������˺��˵���ˣ���������������Ҫ��ֱ𵥶�ִ�С�����");
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("һ���ͻ�")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				System.out.println("��ʼִ�������ͻ�!");				
				testCase.testAddClient();
				System.out.println("�����ͻ�����ִ��ͨ��������");
				System.out.println("��ʼִ���޸Ŀͻ���");
				testCase.testModifyClient();
				System.out.println("�޸Ŀͻ�����ִ��ͨ��������");
				System.out.println("��ʼִ��ɾ���ͻ���");
				testCase.testDeleteClient();
				System.out.println("ɾ���ͻ�����ִ����ɣ�����");
				System.out.println("��ʼִ�������ͻ�����");
				testCase.testClientlevel();
				System.out.println("�����ͻ���������ִ��ͨ��������");
				System.out.println("��ʼִ���޸Ŀͻ�����");
				testCase.testModifyClientlevel();
				System.out.println("�޸Ŀͻ���������ִ��ͨ��������");
				System.out.println("��ʼִ��ɾ���ͻ�����");
				testCase.testDeleteClientlevel();
				System.out.println("ɾ���ͻ���������ִ��ͨ��������");
				System.out.println("��ʼִ��������ɾ���ͻ�����");
				testCase.testAddArea();
				System.out.println("������ɾ���ͻ���������ִ��ͨ��������");
				System.out.println("һ���ͻ�ִ��ͨ�������в�������û��ִ�У�������Ҫ�뵥��ִ�У�����");
				testCase.logout();			
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("һ���������")) {
			try {
				testCase.setUp(browser);	
				if(setting==0){									
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){			
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
				}
				System.out.println("��ʼִ�ж�������ϵͳ���������");
				testCase.testAgentToSystemSuggest();
				System.out.println("��������ϵͳ�����������ִ��ͨ��������");
				testCase.logout1();
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				System.out.println("��ʼִ�й���˶���ϵͳ���������");
				testCase.testToSystemSuggest();
				System.out.println("����˶���ϵͳ�����������ִ��ͨ��������");
				testCase.logout();
				System.out.println("��ʼִ�ж�������ϵͳ�����������ز�����");
				testCase.testAgentToAdminSuggest(setting+3);
				System.out.println("�������������ύ��������������ִ��ͨ��������");
				testCase.logout1();
				System.out.println("һ�������������ִ����ɣ�������ִ�й��̣�ע�����е��쳣���⡣������");
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("һ���ʽ��˺�")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				System.out.println("��ʼִ�йر��ʽ��˺ţ�");
				testCase.closeOpenFund();
				System.out.println("�ر��ʽ��˺�����ִ��ͨ��������");
				System.out.println("��ʼִ�п����ʽ��˺ţ�");
				testCase.closeOpenFund();
				System.out.println("�����ʽ��˺�����ִ��ͨ��������");
				System.out.println("��ʼ��ʼ���ʽ��˺ţ�");
				testCase.fundInitialize();
				System.out.println("��ʼ������ִ��ͨ��������");
				System.out.println("��ʼִ���ʽ��ֵ��");
				testCase.fundRecharge();
				System.out.println("�ʽ��ֵ����ͨ��������");
				System.out.println("��ʼִ���ʽ��˺ſۿ");
				testCase.backRecharge();
				System.out.println("�ʽ�ۿ�����ִ��ͨ��������");
				System.out.println("��ʼִ������տ����У�");
				testCase.addBankAccount();
				System.out.println("����տ���������ִ��ͨ��������");
				System.out.println("��ʼɾ���տ����У�");
				testCase.deleteBankAccount();
				System.out.println("ɾ���տ�����ִ��ͨ��������");
				testCase.logout();
				if(setting==0){									
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
				}
				else if(setting==1){			
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
				}
				System.out.println("��ʼִ�ж������ʽ��ֵ��");
				testCase.testAgentFundRecharge();
				System.out.println("�������ʽ��ִֵ��ͨ��������");
				testCase.logout1();			
				System.out.println("һ���ʽ��˺�����ִ��ͨ�������в�������û��ִ�У�������Ҫ�뵥��ִ�У�����");
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("һ��֪ͨ����")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				System.out.println("��ʼִ������֪ͨ����");
				testCase.testNewNotify();
				//testCase.testNewNotify();
				System.out.println("����֪ͨ����ִ��ͨ��������");
				System.out.println("��ʼִ�й���˲鿴֪ͨ���棡");
				testCase.testMakeNotify();
				System.out.println("����˲鿴֪ͨ����ִ��ͨ��������");
				System.out.println("��ʼִ��ɾ��֪ͨ���棡");
				testCase.testDeleteNotify();
				System.out.println("ɾ��֪ͨ����ִ��ͨ��������");
//				System.out.println("��ʼִ�����֪ͨ���࣡");
//				testCase.testAddNotifyClass();
//				System.out.println("���֪ͨ����ִ��ͨ��������");
//				System.out.println("��ʼִ���޸�֪ͨ���࣡");
//				testCase.testModifyClientlevel();
//				System.out.println("�޸�֪ͨ����ִ��ͨ��������");
//				System.out.println("��ʼִ��ɾ��֪ͨ���࣡");
//				testCase.testDeleteNotifyClass();
//				System.out.println("ɾ��֪ͨ����ִ��ͨ��������");
				System.out.println("��ʼִ�ж����˲鿴֪ͨ���棡");
				testCase.logout1();
				if(setting==0){									
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
				}
				else if(setting==1){			
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
				}
				testCase.testAgentMakeNotify();
				System.out.println("�����˲����鿴֪ͨ����ִ��ͨ��������");			
				testCase.logout1();
				System.out.println("һ��֪ͨ����ִ����ɣ����ֹ���δ����һ�������У�����ִ�й��̣�ע�����е��쳣���⡣������");
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "������ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("һ����Ʒ����")) {
			try {
				testCase.setUp(browser);	
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");			
				System.out.println("��ʼִ����Ʒ���۴�����");
				testCase.testSaleDiscount();
				System.out.println("��Ʒ���۴�������ִ��ͨ��������");
				System.out.println("��ʼִ����Ʒ����������");
				testCase.testSalePresent();
				System.out.println("��Ʒ������������ִ��ͨ��������");
				System.out.println("��ʼִ����Ʒ����������");
				testCase.testSalePromotion();
				System.out.println("��Ʒ������������ִ��ͨ��������");
				System.out.println("��ʼִ����Ʒ���ݴ��۴�����");
				testCase.testSaleDiscount2();
				System.out.println("��Ʒ���ݴ��۴�������ִ��ͨ��������");
				System.out.println("һ����Ʒ����ͨ��������ִ�й��̣�ע�����е��쳣���⡣������");
				testCase.tearDown();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£���\n���ٴ�ִ��һ�Σ��򵥶�ִ��û��ͨ����������", "�쳣��ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("һ����������")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				System.out.println("��ʼִ�ж������۴�����");
				testCase.testOrderSaleDiscount();
				System.out.println("�������۴�������ִ��ͨ��������");
				System.out.println("��ʼִ�ж�������������");
				testCase.testOrderSalePresent();
				System.out.println("����������������ִ��ͨ��������");
				System.out.println("��ʼִ�ж�������������");
				testCase.testOrderSalePromotion();
				System.out.println("����������������ִ��ͨ��������");
				System.out.println("��ʼִ�ж����������۴�����");
				testCase.testOrderSaleDiscount2();
				System.out.println("�����������۴�������ִ��ͨ��������");
				System.out.println("һ����������ͨ��������ִ�й��̣�ע�����е��쳣���⡣������");
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£���\n���ٴ�ִ��һ�Σ��򵥶�ִ��û��ͨ����������", "�쳣��ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("һ����ϴ���")) {
			try {
				JOptionPane.showMessageDialog(null, "��ϴ������ڿ������̣�����ʵ�ֲ���������", "��ܰ��ʾ��", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ȷ��ѡ��ϵͳ���������ʵ�ʻ����Ƿ�һ�£������������쳣", "�쳣��ʾ", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}
       
	}
}
