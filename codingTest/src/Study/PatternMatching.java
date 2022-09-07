package Study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

////Âü°íÀÚ·á
//https://so4869.tistory.com/29 ½Ç½À¿¹Á¦
//https://coding-factory.tistory.com/529 ½ÉÈ­
public class PatternMatching {

	public static void main(String[] args) {
		String userId = "dumbalom009";
		String password = "asdf!@#$";
		
		String userIdRegex = "^[a-zA-Z0-9]{8,20}$";
		String passwordRegex = "^[a-zA-Z0-9!@#$]{8,20}$";
		//Sting.match : ÀÏÄ¡¿©ºÎ¿¡ µû¶ó boolean°ª ¹İÈ¯, À¯È¿¼ºO ¹®ÀÚ¿­ÀçÁ¶ÇÕX
			//À¯È¿¼º °Ë»ç => id : ¿µ¹®¼ıÀÚ¸¸À¸·Î 8±ÛÀÚ¿¡¼­ 20±ÛÀÚ pw : ¿µ¹®¼ıÀÚÆ¯¼ö¹®ÀÚ(?!@#$%) 8±ÛÀÚ¿¡¼­ 20±ÛÀÚ
		boolean id = userId.matches(userIdRegex);
		boolean pw = password.matches(passwordRegex);
		System.out.println(id);
		System.out.println(pw);
		
		//String.replaceAll : Æ¯Á¤ ³»¿ëÀ» Ä¡È¯ÇÏ´Â ¸Ş¼Òµå À¯È¿¼ºO ¹®ÀÚ¿­ÀçÁ¶ÇÕX ÀÌÁö¸¸ À¯È¿¼ºÀº °ÅÀÇ ¾²ÀÌÁö ¾ÊÀ½
			//1.À¯È¿¼º°Ë»ç : °¡´É¸¸ ÇÏ´Ù°í ¾Ë°íÀÖ°í »ç¿ëÇÏÁö ¾Ê´Â°Ô ÁÁÀ½
		boolean id1 = userId.replaceAll(userIdRegex, "").equals("");
		boolean pw1 = password.replaceAll(passwordRegex, "").equals("");
			//2.¹®ÀÚ¿­ °¡°ø(ÀçÁ¶ÇÕ)
		String str = "»ç°ú°¡ 10°³ ÀÖ´Ù.\r\n" + "¹è´Â 14°³°¡ ÀÖ´Ù.\r\n" + "¹Ù³ª³ª´Â 12341234°³°¡ ÀÖ´Ù.";
		String regex = "([°¡-ÆR]+)[Àº´ÂÀÌ°¡] ([0-9]+)°³.*ÀÖ´Ù.";
		String result = str.replaceAll(regex, "$1, $2");
		String result2 = str.replaceAll(regex, "{\"item\": \"$1\", \"quantity\": \"$2\"}");
		System.out.println(result);
		
		
		//String.replaceFirst
			//1.À¯È¿¼º°Ë»ç: replaceAll°ú µ¿ÀÏ
			//2.¹®ÀÚ¿­°¡°ø(ÀçÁ¶ÇÕ): Á¦ÇÑÀû
		String str1 = "ÀÌÅÂÈÆÀÌ ÀºÆò¿¡¼­ Á¾·Î·Î Ãâ±ÙÇÕ´Ï´Ù.";
		String regex1 = "([°¡-ÆR]+)[Àº´ÂÀÌ°¡] ([°¡-ÆR]+)¿¡¼­ ([°¡-ÆR]+)·Î ([°¡-ÆR]+)ÇÕ´Ï´Ù.";
		System.out.println(str1.replaceFirst(regex1, "$1, $2, $3, $4"));
		
		//String.split : ±ÔÄ¢À» ±¸ºĞÀÚ·Î ÇÏ¿© ¹è¿­À» ¸¸µë
		String str2 = "ÀÌÅÂÈÆÀÌ ¸¶Æ®·Î ÀåÀ» º¸·¯°¬´Ù.";
		String[] result3 = str2.split(" ");
		System.out.println(Arrays.asList(result3));
			//1.À¯È¿¼º°Ë»ç: replaceAllÀ» ÀÌ¿ëÇÑ ²Ä¼öÀÌ±â¶§¹®¿¡ »ç¿ëx ¾Ë¾Æ¸¸ µÎÀÚ
			//2.¹®ÀÚ¿­ ÀçÁ¶ÇÕ: ¸¶Âù°¡Áö·Î String.join¸Ş¼Òµå·Î °¡´ÉÀº ÇÏÁö¸¸ ±×³É replaceAllÀ» ¾²ÀÚ
		
		//Pattern & Matcher ¹æ½Ä : ±Ùº»ÀûÀÎ ¹æ½Ä
			//1.À¯È¿¼º °Ë»ç : String.match¿Í ºñ½ÁÇÑ ¹æ½Ä
		System.out.println(Pattern.matches(userIdRegex, userId));
			//2.¹®ÀÚ¿­ ÀçÁ¶ÇÕ
		Pattern pa = Pattern.compile(regex);
		Matcher mat = pa.matcher(str);
		while(mat.find()) {
			String match = mat.group();
			String group1 = mat.group(1);
			String group2 = mat.group(2);
			System.out.println("matched string: " + match);
			System.out.println("°ıÈ£1: " + group1);
			System.out.println("°ıÈ£2: " + group2);
			System.out.println();
		}
		
		
		String email = "test@naver.com";
		boolean emch = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", email);
		System.out.println(emch);
		/*
		 * String.match ¾î¶² ¹®ÀÚ¿­ÀÌ ³»°¡ ¿øÇÏ´Â Çü½ÄÀÎÁö È®ÀÎÇÒ ¶§ »ç¿ëÇÑ´Ù.
		 * String.replaceAll ¾î¶² ¹®ÀÚ¿­ ³»¿¡¼­ °ª"A"¸¦ °ª"B"·Î Ä¡È¯ÇÏ°Å³ª, °£´ÜÇÑ ¹®ÀÚ¿­ µ¥ÀÌÅÍ¸¦ °¡°øÇÒ ¶§ »ç¿ëÇÑ´Ù. 
		 * String.split ¿©·¯ µ¥ÀÌÅÍ¸¦ ÇÕÃÄ¼­ ÇÏ³ªÀÇ ¹®ÀÚ¿­·Î ÁÖ°í¹ŞÀº °ÍÀ» ´Ù½Ã ¶¼¾î³¾¶§ »ç¿ëÇÑ´Ù. 
		 * Pattern, Matcher ÅØ½ºÆ® ÆÄÀÏ ³»¿¡¼­ µ¥ÀÌÅÍ¸¦ Á¤±Ô½Ä ´ÜÀ§·Î »Ì¾Æ³»¼­ ±× °ªÀ» Á÷Á¢ »ç¿ëÇÒ ¶§ »ç¿ëÇÑ´Ù.
		 */
	
	}
	
	
}
