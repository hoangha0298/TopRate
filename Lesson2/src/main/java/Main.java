import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.cloud.translate.testing.RemoteTranslateHelper;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String strSearch;
        Scanner sc = new Scanner(System.in);

        InformationFileDocumentTxt fileDocumentTxt = new InformationFileDocumentTxt("src/main/resources/input.txt");

        fileDocumentTxt.reportWord();

        while (true) {
            System.out.println("\nNhập vào từ cần tìm (muốn thoát thì nhập vào \"exit...\") và nhấn enter để tìm (thoát) . ");
            strSearch = sc.nextLine();
            if (strSearch.equals("exit...")) break;
            System.out.println("Tìm kiếm : \"" + strSearch + "\"");
            fileDocumentTxt.searchWordByStartsWith(strSearch);
        }

    }

}
