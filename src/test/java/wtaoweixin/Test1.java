package wtaoweixin;

import java.io.File;

public class Test1 {

	public static void main(String[] args) {
		String path = "C:\\Users\\wtao\\Desktop\\[www.java1234.com]一头扎进Centos7视频教程";
		File file = new File(path);
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			String name = file2.getName();
			System.out.println("原名称是::"+name);
			if(name.indexOf("]")>0) {
				String name1 = name.substring(name.indexOf("]")+1);
				File file1 = new File(path+"\\"+name1);
				file2.renameTo(file1);
				System.out.println("后名称是::"+file1.getName());
			}
		}
	}

}

