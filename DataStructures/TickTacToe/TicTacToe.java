package tictactoe;

public class TicTacToe {

	private char[][] board = new char[3][3];
	private int turn = 0;
	private String brd;

//***************************************************************************************************

	int getTurns() {

		int result = turn;

		return result;

	}
//***************************************************************************************************

	boolean isTied() {

		boolean result;

		result = false;

		if (!isWinner('X') && !isWinner('O') && isFull()) {

			result = true;
		}

		return result;

	}
//***************************************************************************************************

	boolean isFull() {

		return turn == 9;

	}

//***************************************************************************************************

	boolean isWinner(char p) {

		for (int i = 0; i < board.length; i++) {

			if (board[i][0] == p && board[i][1] == p && board[i][2] == p) {
				return true;
			}
			if (board[0][i] == p && board[1][i] == p && board[2][i] == p) {
				return true;
			}
		}

		if (board[0][0] == p && board[1][1] == p && board[2][2] == p) {
			return true;
		}

		if (board[2][0] == p && board[1][1] == p && board[0][2] == p) {
			return true;
		}

		return false;
	}

//***************************************************************************************************	
	public String toString() {

		for (int i = 0; i < board.length; i++) {
			System.out.print("-------------\n");
			System.out.print("| ");
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " | ");
			}

			System.out.println();

		}

		brd = "-------------";
		return brd;

	}
//***************************************************************************************************

	void playMove(char p, int r, int c) {

		board[r][c] = p;
		turn++;

	}

// **************************************************************************************************

	public char playerAt(int r, int c) {

		char result = ' ';

		if (board[r][c] == 'X') {
			result = 'X';
		} else if (board[r][c] == 'O') {
			result = 'O';
		}

		return result;
	}

// **************************************************************************************************
	public boolean isValid(int r, int c) {
		boolean result;

		if ((r < 0) || (c < 0) || (r > 2) || (c > 2)) {

			result = false;
		} else {
			result = true;
		}
		return result;
	}

// *****************************************************************************************************
	public TicTacToe() {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				board[i][j] = ' ';

			}

		}

	}
}
