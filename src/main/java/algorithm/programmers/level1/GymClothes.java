package algorithm.programmers.level1;

public class GymClothes {

  public static void main(String[] args) {

  }

  public int solution(int totalStudentCount, int[] lost, int[] reserve) {
    int answer = totalStudentCount - lost.length;

    int[] clothes = createClothes(totalStudentCount);

    for (int cloth : clothes) {

    }

    return answer;
  }

  private int[] createClothes(int totalStudentCount) {
    int[] clothOfStudent = new int[totalStudentCount];
    for (int i : clothOfStudent) {
      i = 1;
    }
    return clothOfStudent;
  }
}
