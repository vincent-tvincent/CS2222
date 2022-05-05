public class hw6main2 {
	// 创建二维数组

	public static void main(String[] args) {
		int n = 8;
		boolean flag;
		int[][] arr = new int[n][n];
		// int[] Board = {1,6,8,3,7,4,2,5};
		int[] Board = { 1, 6, 8, 3, 7, 0, 0, 0 };
		// int[] Board = {1,6,8,3,5,0,0,0};
		// 初始化二维数组，输入的 board 为每一列的标识皇后的位置
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == (Board[i] - 1)) { // 由于数组是从0开始计算的，所以要 减 1
					arr[i][j] = 1;
				} else {
					arr[i][j] = 0;
				}
			}
		}

		outPrint(arr);
		int[] outBoard;
		outBoard = NextLegalPosition(arr, Board);
		for (int i = 0; i < Board.length; i++) {
			System.out.print(Board[i]);
		}
	}

	public static int[] NextLegalPosition(int[][] arr, int[] Board) {
		int[] outData;
		outData = Board;
		for (int k = 0; k < Board.length; k++) {
			if (Board[k] == 0) {
				for (int i = k; i < arr.length; i++) {
					for (int j = 0; j < arr.length; j++) {
						arr[i][j] = 1;// 先设置为1；判断三个条件，若不行在修改回来
						if (!(isLine(i, j, arr) && isLine1(i, j, arr) && isLine2(
								i, j, arr))) {
							arr[i][j] = 0;
						} else if ((isLine(i, j, arr) && isLine1(i, j, arr) && isLine2(
								i, j, arr))) {
							outData[i] = j + 1;
							System.out.println(j);
							break;
						}
					}
				}
			}
		}

		return Board;
	}

	public static void outPrint(int[][] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("---------");
	}

	// 判断给定位置 右斜线（ \ ） 是否已存在皇后
	public static boolean isLine(int i, int j, int[][] arr) {
		System.out.println(i + "," + j + "有值的坐标");
		int m = i;
		int n = j;
		int row = arr.length;
		int sum = 0;
		// 右斜线
		for (int count = 0; count < row; count++) {

			if (n < (row)) {

				if (m < row && n < row) {
					sum += arr[m][n];
					// System.out.print((m) + "," + (n) + "\t");
					m = m + 1;
					n = n + 1;
				}
			} else {
				i = i - 1;
				j = j - 1;
				if (i < 0 || j < 0) {
					break;
				} else {
					// System.out.print(i + "," + j + "\t");
					sum += arr[i][j];
				}
			}

		}

		if (sum > 1) {
			return false;
		} else {
			return true;
		}
	}

	// 判断给定位置 左斜线（ / ） 是否已存在皇后
	public static boolean isLine1(int i, int j, int[][] arr) {
		int m = i;
		int n = j;
		int row = arr.length;
		int sum = 0;

		// 左斜线
		for (int count1 = 0; count1 < row; count1++) {

			if (m < (row)) {
				sum += arr[m][n];
				// System.out.print(m + "," + n + "\t");
				m = m + 1;
				n = n - 1;
				if (n < 0) {
					m = 8;
					continue;
				}
			} else {
				i = i - 1;
				j = j + 1;
				if (i < 0 || j >= (row)) {
					break;
				} else {
					// System.out.print(i + "," + j + "\t");
					sum += arr[i][j];
				}

			}

		}
		if (sum > 1) {
			return false;
		} else {
			return true;
		}
	}

	// 判断给定位置 竖线（ | ） 是否已存在皇后
	public static boolean isLine2(int i, int j, int[][] arr) {
		System.out.println(i + "," + j + "有值的坐标");
		int m = i;
		int n = j;
		int row = arr.length;
		int sum = 0;

		// 列线
		for (int count1 = 0; count1 < row; count1++) {

			if (m < (row)) {
				sum += arr[m][n];
				// System.out.print(m + "," + n + "\t");
				m = m + 1;
			} else {
				i = i - 1;
				if (i < 0 || j >= (row)) {
					break;
				} else {
					// System.out.print(i + "," + j + "\t");
					sum += arr[i][j];
				}

			}

		}

		if (sum > 1) {
			return false;
		} else {
			return true;
		}
	}

}
