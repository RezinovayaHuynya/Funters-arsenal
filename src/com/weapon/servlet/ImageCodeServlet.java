package com.weapon.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.media.jfxmediaimpl.platform.ios.IOSMediaPlayer;



/**
 * Servlet implementation class ImageCodeServlet
 */
@WebServlet("/imagecode")
public class ImageCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> words = new ArrayList<String>();

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		// super.init();
		String path = getServletContext().getRealPath("WEB-INF/new_words.txt");
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf-8"));
			String line;
			for (; (line = reader.readLine()) != null;) {
				words.add(line);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageCodeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//java�������ͼƬ
		//awt��
		//��ϰ��
		//��Ϊʲô�ܿ���ͼƬ��ͼƬ��һ��һ�����ص㡣
		//ÿһ���㶼�� ��͸���ȣ���ɫ����ɫ����ɫ���ĸ�������ɡ�
		//��ԭɫ��
		//�����ɫ�ķ�ʽ��ʹ��һ��int����
		//int�����ֽڣ�4��
		//�ĸ��ֽڷ�Ϊ��8λ���θ�8λ���ε�8λ����8λ��
		//˳������ʾ͸���ȣ���ɫ����ɫ����ɫ
		//1111 1111
		//1111 1111
		//0000 0000
		//1111 1111
		
		//����ͼƬ��֤��
		Random random=new Random();
		int index=random.nextInt(words.size());
		//�������һ������
		String word=words.get(index);
		request.getSession().setAttribute("checkcode", word);
		//������֤��Ŀ��
		int width=120;
		int height=30;
		//����һ��ͼƬ
		BufferedImage bufferedImage=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//��ȡ���ƶ���
		Graphics graphics=bufferedImage.getGraphics();
		//����
		//��֤���Ϊ�������֣���һ�����Ǳ������ڶ����������ݡ�������������㡣
		//��һ���ֱ�����ǳ��ɫ
		Color color=getRandomColor(200, 240);
		//���ø����ƶ�����ɫ
		graphics.setColor(color);
		//����������֤�ķ�ΧΪcolor
		//������һ����ͼƬһ����ľ��Ρ�
		graphics.fillRect(0, 0, width, height);
		//�����߿�
		graphics.setColor(Color.WHITE);
		//��fillRect��ͬ��drawRect��ʽ����ߵķ�ʽ����һ������
		graphics.drawRect(0, 0, width-1, height-1);
		//end ���Ʊ�����ɫ���
		
		
		//���Ƶڶ����֣�����
		Graphics2D graphics2d=(Graphics2D) graphics;
		//��������
		int x=10;
		graphics2d.setFont(new Font("����",Font.BOLD,18));
		for (int i = 0; i < word.length(); i++) {
			//����һ���Ƚ������ɫ
			graphics2d.setColor(getRandomColor(20, 110));
			
			//Ҫת
			int angle=random.nextInt(60)-30;
			//����
			double theta=Math.PI/180*angle;
			//��ȡ��������
			char c=word.charAt(i);
			
			//ת
			graphics2d.rotate(theta, x, 20);
			
			//д��
			graphics2d.drawString(""+c, x, 20);
			
			//ת����
			graphics2d.rotate(-theta, x, 20);
			x+=30;
		}
		
		//�������֣����
		graphics.setColor(getRandomColor(160, 200));
		int x1;
		int x2;
		int y1;
		int y2;
		for (int i = 0; i < 30; i++) {
			//�߲�����̫��
			//���sqrt(288)
			x1=random.nextInt(width);
			y1=random.nextInt(height);
			
			x2=random.nextInt(12);
			y2=random.nextInt(12);
			graphics.drawLine(x1, y1, x1+x2, y1+y2);
		}
		
		//�ͷ���Դ
		graphics.dispose();
		
		//���һ��ͼƬ�������
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
		
	}
	
	//��ɫ��û�������������������֣��ֱ����ǳ�����ǳ��
	private Color getRandomColor(int fc,int ec) {
		
		Random random=new Random();
		int r=random.nextInt(ec-fc)+fc;
		int g=random.nextInt(ec-fc)+fc;
		int b=random.nextInt(ec-fc)+fc;
		return new Color(r,g,b);
		//�����ɫ
		//��ο�����ɫ��ǳ��
		//1111 1111
		//0000 0000
		//0000 0000
		//0000 0000
		
		//1111 1111
		//1111 1111
		//1111 1111
		//1111 1111
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
