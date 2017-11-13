package bitcamp.java100.ch14.ex2;

import java.io.IOException;
import java.io.InputStream;

public class MyBufferedInputStream2 {
    
    InputStream workor;

    byte[] buf = new byte[8192];
    int len;
    int cursor;

    public MyBufferedInputStream2(InputStream workor) {
        this.workor = workor;
    }

    public int read() throws IOException {
        if (cursor >= len) {
            cursor = 0;
            len = workor.read(buf);
            if (len == -1)
                return -1;
        }
        return buf[cursor++] & 0x000000FF;
    }
}
