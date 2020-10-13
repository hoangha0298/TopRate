package Exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class InformationFileDocumentTxt {

    private String strUriInput;
    private LinkedHashMap<String, Integer> lhmSortReport;

    public InformationFileDocumentTxt(String strUriInput) {
        this.strUriInput = strUriInput;
        try {
            processDocument(new FileInputStream(strUriInput));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
    báo cáo tần số xuất hiện của chữ trong file document
    */
    public void reportWord() {
        System.out.println("Số lượng từ trong file : " + lhmSortReport.size() + " từ \n");
        System.out.println("danh sách từ và số lần suất hiện \n");
        printLinkedHashMap(lhmSortReport);
    }

    /*
    tìm kiếm (nhiều nhất 5 kết quả) các từ có bắt đầu là prefix có số lần xuất hiện nhiều nhất
    */
    public void searchWordByStartsWith (String prefix) {
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();

        prefix = prefix.toLowerCase();
        List<String> lKeys = new ArrayList<>(lhmSortReport.keySet());
        Iterator<String> itKey = lKeys.iterator();

        int j = 0;
        while (itKey.hasNext()) {
            String key = itKey.next();
            if (key.startsWith(prefix)) {
                result.put(key, lhmSortReport.get(key));
                j++;
                if (j == 5) break;
            }
        }
        System.out.println("Tìm thấy " + j + " kết quả.");
        printLinkedHashMap(result);
    }

    /*
    in ra nội dung LinkedHashMap theo format key dài 25 kí tự ( có thể thêm khoảng trắng cho đủ )
    */
    private void printLinkedHashMap(LinkedHashMap<String, Integer> lhm) {
        for (Map.Entry<String, Integer> entry : lhm.entrySet()) {
            String key = entry.getKey();
            for (int i=key.length(); i<25; i++) {
                key += " ";
            }
            int value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }

    /*
    tìm các từ trong tài liệu và đếm số lần xuất hiện lưu vào lhmSortReport
    */
    private void processDocument(FileInputStream fisDocument) {
        Scanner sc = new Scanner(fisDocument);
        HashMap<String, Integer> hmReport = new HashMap<String, Integer>();
//        int iLine = 1;       // Để test

        try {
            while (sc.hasNext()) {
//                System.out.println(iLine++);         // Để test
                processLine(sc.nextLine(), hmReport);
            }
            lhmSortReport = sortHashMapByValues(hmReport);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    sắp xếp hashmap theo value
    */
    private LinkedHashMap<String, Integer> sortHashMapByValues(HashMap<String, Integer> hm) {
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        List<String> lKeys = new ArrayList<>(hm.keySet());
        List<Integer> lValues = new ArrayList<>(hm.values());

        Collections.sort(lKeys);
        Collections.sort(lValues, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        Iterator<Integer> itValue = lValues.iterator();
        while (itValue.hasNext()) {
            int val1 = itValue.next();
            Iterator<String> itKey = lKeys.iterator();

            while (itKey.hasNext()) {
                String key = itKey.next();
                int val2 = hm.get(key);

                if (val2 == val1) {
                    itKey.remove();
                    sortedMap.put(key, val2);
                    break;
                }
            }
        }
        return sortedMap;
    }

    /*
    các từ cách nhau bằng khoảng trống
    nếu từ khác rỗng và chưa có trong hmReport thì thêm mới và set value = 1
    nếu từ khác rỗng và đã có trong hmReport thì  set value = value + 1
    author haduyhoang
    */
    private void processLine(String line, HashMap<String, Integer> hmReport) {
        String[] strWords = line.split(" ");
        for (String word : strWords) {
            String wordQualify = processWord(word);
            if (!wordQualify.isEmpty()) {
                if (!hmReport.containsKey(wordQualify)) {
                    hmReport.put(wordQualify, 1);
//                    System.out.println("\t\t" + wordQualify);     // Để test
                }
                else {
                    int value = hmReport.get(wordQualify);
                    hmReport.put(wordQualify, value+1);
                }
            }
        }
    }

    /*
    bỏ qua kí tự đặc biệt và số
    chữ viết hoa thì chuyển sang viết thường
    kí tự "'" nếu ở đầu hoặc cuối từ thì xóa
    author haduyhoang
    */
    private String processWord(String word) {
        String result = "";
        char[] chars = word.toCharArray();
        char c;
        for (int i=0; i<chars.length; i++) {
            c = chars[i];
            // xử lý A - Z thành a - z
            if (c>64 && c<91) {
                c += 32;
                result += c;
            }
            // xử lý a - z
            else if (c>96 && c<123) {
                result += c;
            }
            // xử lý kí tự 39 : '
            else if (c == 39) {
                result += c;
            }
        }
        // nếu "'" ở đầu hoặc cuối thì xóa
        if (!result.isEmpty()) {
            if (result.charAt(0) == 39) {
                result = result.substring(1, result.length());
            }
            if (result.length() != 0 && result.charAt(result.length() - 1) == 39) {
                result = result.substring(0, result.length()-1);
            }
        }
        return result;
    }

}
