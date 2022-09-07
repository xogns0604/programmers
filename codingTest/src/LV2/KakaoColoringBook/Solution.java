//https://programmers.co.kr/learn/courses/30/lessons/1829
package LV2.KakaoColoringBook;

//for(int[] arr : picture)System.out.println(Arrays.toString(arr));
//System.out.println();
import java.util.Arrays;

public class Solution {
	int xl;
	int yl;
	int size = 0;
	
	public  int[] solution(int m, int n, int[][] picture) {
		xl = m;
		yl = n;
		
		int numberOfArea = 0;
		int maxSizeArea = 0;
		
		for(int i=0; i<m; i++) {
			for(int j=0 ; j<n ; j++) {
				if(picture[i][j] > 0) {
					isNearPoint(picture, i, j, picture[i][j]);
					maxSizeArea = Math.max(maxSizeArea, size);
					size=0;
					numberOfArea++;
				}
			}
		}

		for(int[] arr : picture)System.out.println(Arrays.toString(arr));
		
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeArea;
        return answer;
    }
	

	public void isNearPoint(int[][] picture, int x, int y, int color) {
		picture[x][y] = -color;
		size++;
		if(x != 0) {
			if(color == picture[x-1][y]) {
				isNearPoint(picture, x-1, y, color);
			}
		}
		
		if(x != (xl-1)) {
			if(color == picture[x+1][y]) {
				isNearPoint(picture, x+1, y, color);
			}
		}
		
		if(y != (yl-1)) {
			if(color == picture[x][y+1]) {
				isNearPoint(picture, x, y+1, color);
			}
		}
		if(y != 0) {
			if(color == picture[x][y-1]) {
				isNearPoint(picture, x, y-1, color);
			}
		}
	}
}
	/*
	 * public int[] solution(int m, int n, int[][] picture) { List<Point> pL = new
	 * ArrayList<Point>();
	 * 
	 * //0이 아닌 좌표만 List에 등록 int have1Num = 0; for(int i=0; i<m; i++) { for(int j=0 ;
	 * j<n ; j++) { if(picture[i][j] != 0) { boolean isOnePlus = false;
	 * 
	 * if(i != 0)if(picture[i][j] == picture[i-1][j]) isOnePlus = true; if(i !=
	 * m-1)if(picture[i][j] == picture[i+1][j]) isOnePlus = true; if(j !=
	 * n-1)if(picture[i][j] == picture[i][j+1]) isOnePlus = true; if(j !=
	 * 0)if(picture[i][j] == picture[i][j-1]) isOnePlus = true;
	 * 
	 * if(isOnePlus) { pL.add(new Point(i, j, picture[i][j])); }else have1Num++; } }
	 * }
	 * 
	 * List<Points> pls = new ArrayList<Points>();
	 * 
	 * //모든 포인트를 근처에 있는거끼리 매칭해서 Points 리스트 만들기 for(Point p : pL) { if(pls.isEmpty())
	 * { Points ps = new Points(p.color); ps.PL.add(p); pls.add(ps); }else { boolean
	 * isNotNear = true;
	 * 
	 * for(Points ps : pls) { if(ps.isnears(p)) { ps.PL.add(p); isNotNear = false;
	 * 
	 * } } if(isNotNear) { Points ps = new Points(p.color); ps.PL.add(p);
	 * pls.add(ps); } } }
	 * 
	 * List<Points> plsR = new ArrayList<Points>();
	 * 
	 * for(int i=0 ; i<pls.size() ; i++) { if(pls.get(i).hapCom) continue;
	 * 
	 * boolean isNoHap = true; for(int j=i+1 ; j<pls.size() ; j++) {
	 * if(pls.get(i).isHap(pls.get(j))){ pls.get(i).hap(pls.get(j));
	 * plsR.add(pls.get(i)); isNoHap = false; } }
	 * 
	 * if(isNoHap) plsR.add(pls.get(i)); }
	 * 
	 * int max = 0; for(Points ps : plsR) { max = Math.max(max, ps.PL.size()); } int
	 * numberOfArea = plsR.size() + have1Num; int maxSizeOfOneArea = max;
	 * 
	 * int[] answer = new int[2]; answer[0] = numberOfArea; answer[1] =
	 * maxSizeOfOneArea; return answer; }
	 */
	
	
//	private class Point{
//		int x;
//		int y;
//		int color;
//		//ArrayList<Point> nearPoint = new ArrayList<Point>();
//		
//		public Point() {}
//		public Point(int x, int y, int color) {
//			this.x = x;
//			this.y = y;
//			this.color = color;
//		}
//
//		
//		@Override
//		public String toString() {
//			return "Point [x=" + x + ", y=" + y + ", color=" + color + "]";
//		}	
//		
//		public boolean isNear(Point p) {
//			int xsum = Math.abs(this.x - p.x);
//			int ysum = Math.abs(this.y - p.y);
//			
//			if((xsum+ysum) <= 1 && this.color == p.color) return true;
//			else return false;
//		}
//		
//		public boolean isEqual(Point p) {
//			if(this.x == p.x && this.y == p.y)return true;
//			else return false;
//		}
//	}
//	
//	private class Points{
//		Set<Point> PL = new HashSet<Point>();
//		int color;
//		boolean hapCom = false;
//		
//		
//		public Points() {}
//		public Points(int color) {
//			this.color = color;
//		}
//
//		public boolean isnears(Point p) {
//			boolean result = false;
//			for(Point tp : PL) {
//				if(tp.isNear(p)) result = true;
//			}
//			
//			return result;
//		}
//		
//		public boolean isHap(Points p) {
//			boolean result = false;
//			
//			for(Point p1 : PL) {
//				for(Point p2 : p.PL) {
//					if(p1.isEqual(p2)) result = true;
//				}
//			}
//			return result;
//		}
//		
//		public void hap(Points ps){
//			for(Point p : ps.PL) {
//				PL.add(p);
//			}
//			ps.hapCom = true;
//		}
//		@Override
//		public String toString() {
//			return "Points [PL=" + PL + ", color=" + color + "]" + "\n";
//		}
//		
//		
//	}



