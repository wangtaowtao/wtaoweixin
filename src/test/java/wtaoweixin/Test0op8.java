package wtaoweixin;

public class Test0op8 {

	public static String generator(int num) {
		String[] str = {"0","8"};
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++) {
			int index = (int)(Math.random()*2);
			sb.append(",").append(str[index]);
		}
		return sb.toString().substring(1);
	}
	
	public static void main(String[] args) {
		String a = generator(10);
		a = "0,0,8,0";
		String rex = "[08,]*";
		boolean matches = a.matches(rex);
		System.out.println(matches);
	}
}

