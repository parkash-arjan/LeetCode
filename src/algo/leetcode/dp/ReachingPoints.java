package algo.leetcode.dp;

import java.util.HashSet;
import java.util.Set;

public class ReachingPoints {

	private static boolean isFound = false;
	private static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		System.out.println(reachingPoints(35, 13, 455955547, 420098884));
	}

	public static boolean reachingPoints(int sx, int sy, int tx, int ty) {

		while (sx <= tx && sy <= ty) {

			if (tx > ty) {
				tx = tx - ty;
			} else {
				ty = ty - tx;
			}
			if (sx == tx && sy == ty) {
				return true;

			}

		}

		return false;

	}
//	public static boolean reachingPoints(int sx, int sy, int tx, int ty) throws Exception {
//
//		if (sx == tx && sy == ty) {
//			return true;
//		}
//		return reachingPointsDfs(sx, sy, tx, ty);
//	}
//
//	private static boolean reachingPointsDfs(int sx, int sy, int tx, int ty) throws Exception {
//
//		if (set.contains("(" + sx + "," + sy + ")")) {
//
//			throw new Exception("Found " + "(" + sx + "," + sy + ")" + "  " + "(" + tx + "," + ty + ")");
//
//		} else {
//			set.add("(" + sx + "," + sy + ")");
//		}
//		if (sx > tx || sy > ty)
//			return false;
//
//		if (sx == tx && sy == ty)
//			return true;
//
//		if (!isFound)
//			isFound = reachingPointsDfs((sx + sy), sy, tx, ty);
//
//		if (!isFound)
//			isFound = reachingPointsDfs(sx, (sy + sx), tx, ty);
//
//		return isFound;
//
//	}

}
