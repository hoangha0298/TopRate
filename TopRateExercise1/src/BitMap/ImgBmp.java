package BitMap;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ImgBmp {

    private String uriInput;
    private String uriOutput;

    private short[] bOffBits;
    private short[] bWidth;
    private short[] bHeigh;
    private int iOffBits;
    private int iWidth;
    private int iHeigh;
    private int iPadding;

    private FileInputStream inputImgBmp;
    private FileOutputStream outputImgBmp;

    public ImgBmp (String uriInput, String uriOutput) {
        // khởi tạo các biến
        this.uriInput = uriInput;
        this.uriOutput = uriOutput;
        bOffBits = new short[4];
        bWidth = new short[4];
        bHeigh = new short[4];

        try {
            // mở file ảnh cần xử lý
            inputImgBmp = new FileInputStream(uriInput);
            // mỏ file để ghi kết quả
            if (uriOutput != null && !uriOutput.equals(""))
            {
                outputImgBmp = new FileOutputStream(this.uriOutput);
            }
            else {
                outputImgBmp = new FileOutputStream("output.bmp");
            }

            // bỏ qua 10 byte của header file
            inputImgBmp.skip(10);
            // đọc dịa chỉ đoạn bắt đầu data
            for (int i=0; i<4; i++) {
                bOffBits[i] = (short)inputImgBmp.read();
            }
            // bỏ qua header information image
            inputImgBmp.skip(4);
            // đọc chiều rộng
            for (int i=0; i<4; i++) {
                bWidth[i] = (short)inputImgBmp.read();
            }
            // đọc chiều cao
            for (int i=0; i<4; i++) {
                bHeigh[i] = (short)inputImgBmp.read();
            }

            iOffBits = arrayByteToInt(bOffBits);
            iWidth = arrayByteToInt(bWidth);
            iHeigh = arrayByteToInt(bHeigh);
//            iPadding = iWidth % 4;
            iPadding =  4 - iWidth * 3 % 4;
            if (iPadding == 4) iPadding = 0;

            System.out.println(Arrays.toString(bOffBits));
            System.out.println(Arrays.toString(bWidth));
            System.out.println(Arrays.toString(bHeigh));

            System.out.println(iOffBits);
            System.out.println(iWidth);
            System.out.println(iHeigh);
            System.out.println(iPadding);

            inputImgBmp.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // mảng byte có 4 phần tử
    private int arrayByteToInt (short[] bytes) {
        int result = 0;
        int base = 1;
        for (int i=0; i<bytes.length; i++) {
            if (i>0) base *= 256;
            result += bytes[i]*base;
        }
        return result;
    }

    public void printImgConvert() throws IOException {
        inputImgBmp = new FileInputStream(uriInput);

        // write header
        for (int k=0; k<iOffBits; k++) {
            int temp = inputImgBmp.read();
            outputImgBmp.write(temp);
        }

        // write data (map pixel)
        int b, g, r;
        double index;
        for (int i=0; i<iHeigh; i++) {
            for (int j=0; j<iWidth; j++) {
                b = inputImgBmp.read() + 1;
                g = inputImgBmp.read() + 1;
                r = inputImgBmp.read() + 1;

                if (r>b && r>g) {
                    index = (double)(256-r)/80 + 1.8;
//                    index = 1;
//                    index = 2;
//                    index = 4;

                    if (r/b>=index || r/g>=index) {
                        int temp = r;
                        r = g;
                        g = temp;
                    }

                }

                outputImgBmp.write(--b);
                outputImgBmp.write(--g);
                outputImgBmp.write(--r);
            }
            inputImgBmp.skip(iPadding);
            for (int j=0; j<iPadding; j++) {
                outputImgBmp.write(0);
            }
        }

        outputImgBmp.close();
    }

}
