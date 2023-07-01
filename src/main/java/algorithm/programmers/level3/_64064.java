package algorithm.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 불량 사용자
 */
public class _64064 {

  public static void main(String[] args) {
    _64064 instance = new _64064();
    System.out.println(instance.solution(new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" },
      new String[] { "fr*d*", "abc1**" }));
    System.out.println(instance.solution(new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" },
      new String[] { "*rodo", "*rodo", "******" }));
    System.out.println(instance.solution(new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" },
      new String[] { "fr*d*", "*rodo", "******", "******" }));
  }

  public int solution(String[] userIds, String[] bannedIds) {
    List<List<String>> bannedUserIdsList = new ArrayList<>();
    for (String bannedId : bannedIds) {
      Pattern pattern = Pattern.compile(bannedId.replaceAll("\\*", "."));
      ArrayList<String> bannedUserIds = new ArrayList<>();
      for (String userId : userIds) {
        if (pattern.matcher(userId).matches()) {
          bannedUserIds.add(userId);
        }
      }
      bannedUserIdsList.add(bannedUserIds);
    }

    int result = 0;
    List<String> bannedUserIds = bannedUserIdsList.get(0);
    Set<String[]> cases = new HashSet<>();
    for (String bannedUserId : bannedUserIds) {
      String[] eachCases = new String[bannedIds.length];
      eachCases[0] = bannedUserId;
      result += getAnswer(1, bannedUserIdsList, eachCases, cases);
    }

    return result;
  }

  private int getAnswer(int index, List<List<String>> userIdsByBannedIds, String[] eachCases, Set<String[]> allCases) {
    if (index == userIdsByBannedIds.size()) {
      if (eachCases.length == userIdsByBannedIds.size() && !contains(allCases, eachCases)) {
        allCases.add(eachCases);
        return 1;
      }
      return 0;
    }

    int answer = 0;
    for (String bannedUserId : userIdsByBannedIds.get(index)) {
      if (contains(eachCases, bannedUserId)) {
        continue;
      }

      String[] clone = Arrays.copyOf(eachCases, eachCases.length);
      clone[index] = bannedUserId;
      answer += getAnswer(index + 1, userIdsByBannedIds, clone, allCases);
    }

    return answer;
  }

  private boolean contains(String[] eachCases, String bannedUserId) {
    for (String eachCase : eachCases) {
      if (eachCase != null && eachCase.equals(bannedUserId)) {
        return true;
      }
    }
    return false;
  }

  private boolean contains(Set<String[]> allCases, String[] eachCases) {
    Arrays.sort(eachCases);
    for (String[] cases : allCases) {
      if (Arrays.deepEquals(cases, eachCases)) {
        return true;
      }
    }
    return false;
  }
}

/*
time complexity
n is the length of bannedIds
m is the length of userIds
k is the average length of the banned IDs.
O(n * m * k)

critical point
1. 제재 아이디 당 경우의 수를 통해 조합
2. 다른 패턴으로 동일한 아이디를 가르킬 수 있기 때문에 중복 제거 필요
   fr*d*, *****의 경우 fradi, frodo, frodoc가 중복됨
   모든 케이스를 기록하는 allCases를 인자로 넘겨서 기존 케이스와 중복되지 않는 경우에만 추가
3. 각각의 케이스는 eachCases에 저장

["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "abc1**"]	2
["frodo", "fradi", "crodo", "abc123", "frodoc"]	["*rodo", "*rodo", "******"]	2
["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "*rodo", "******", "******"]	3

reference
https://programmers.co.kr/learn/courses/30/lessons/64064
*/
