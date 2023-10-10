import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 플레이어 클래스
	static class Player implements Comparable<Player> {
		private int level;
		private String nickname;

		public Player(int level, String nickname) {
			super();
			this.level = level;
			this.nickname = nickname;
		}

		public int getLevel() {
			return level;
		}

		public String getNickname() {
			return nickname;
		}

		@Override
		public int compareTo(Player o) {
			return this.nickname.compareTo(o.nickname);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 플레이어 수 & 방 정원 입력
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 플레이어를 담을 방 2차원 배열 & 방에 들어가 있는 현재 인원 수 배열
		Player room[][] = new Player[p][m];
		int roomNum[] = new int[p];

		// 첫 플레이어 초기화
		st = new StringTokenizer(br.readLine());
		room[0][0] = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
		roomNum[0] = 1;

		int cnt = 1; // 방 개수
		int curLevel;
		String curNickname;
		boolean find; // 입장할 방 찾았다는 의미의 check값

		// 두번째 플레이어부터 마지막 플레이어까지 방 입장
		for (int i = 1; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			curLevel = Integer.parseInt(st.nextToken());
			curNickname = st.nextToken();
			find = false;
			// 현재 생성된 방 개수만큼 검토
			for (int j = 0; j < cnt; j++) {
				// 방의 정원이 다 차지 않음 + 방 생성자와 레벨 차이가 10이하로 나는 경우
				if (roomNum[j] < m && Math.abs(room[j][0].getLevel() - curLevel) <= 10) {
					// 플레이어 입장
					find = true;
					room[j][roomNum[j]++] = new Player(curLevel, curNickname);
					break;
				}
			}
			// 방을 찾지 못한 경우 새로운 방을 만들어서 입장
			if (!find)
				room[cnt][roomNum[cnt++]++] = new Player(curLevel, curNickname);
		}

		StringBuilder sb = new StringBuilder();
		Player temp[];
		for (int i = 0; i < cnt; i++) {
			temp = new Player[roomNum[i]];
			if (roomNum[i] == m)
				sb.append("Started!\n");
			else
				sb.append("Waiting!\n");
			for (int j = 0; j < roomNum[i]; j++)
				temp[j] = room[i][j];
			Arrays.sort(temp);

			for (int j = 0; j < roomNum[i]; j++)
				sb.append(temp[j].getLevel()).append(" ").append(temp[j].getNickname()).append("\n");
		}
		System.out.println(sb);
	}
}
