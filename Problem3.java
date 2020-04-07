import java.util.Scanner;

public class Problem3 {

	public static void main(String[] args) {

		double[][] A = new double[2][2];
		System.out.print("Enter a, b, c, d: ");
		Scanner in = new Scanner(System.in);

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				A[i][j] = in.nextDouble();
			}
		}
		double determinant = (A[0][0] * A[1][1]) - (A[0][1] * A[1][0]);
		System.arraycopy(inverse(A), 0, A, 0, inverse(A).length);

		if (determinant != 0) {
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A[i].length; j++) {
					System.out.print(A[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("no inverse matrix");
		}
	}

	public static double[][] inverse(double[][] A) {

		double determinant = (A[0][0] * A[1][1]) - (A[0][1] * A[1][0]);

		double temp = A[0][0];
		A[0][0] = A[1][1];
		A[1][1] = temp;

		A[0][1] = -A[0][1];
		A[1][0] = -A[1][0];

		double[][] inverse = new double[2][2];

		for (int i = 0; i < inverse.length; i++) {
			for (int j = 0; j < inverse[i].length; j++) {
				inverse[i][j] = A[i][j] / determinant;
			}
		}
		return inverse;
	}

}
