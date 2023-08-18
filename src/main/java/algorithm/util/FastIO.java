package algorithm.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class FastIO {

  private static final int BUFFER_SIZE = 1 << 16;
  private final DataInputStream in;
  private final DataOutputStream out;
  private final byte[] inBuffer;
  private final byte[] outBuffer;
  private final byte[] bytebuffer;

  private int inBufferPointer, bytesRead;
  private int outBufferPointer;

  public FastIO() {
    in = new DataInputStream(System.in);
    out = new DataOutputStream(System.out);
    inBuffer = new byte[BUFFER_SIZE];
    outBuffer = new byte[BUFFER_SIZE];
    bytesRead = outBufferPointer = 0;
    bytebuffer = new byte[10];
  }

  public String readLine() throws IOException {
    byte[] buf = new byte[64]; // line length
    int cnt = 0, c;
    while ((c = read()) != -1) {
      if (c == '\n') {
        if (cnt != 0) {
          break;
        } else {
          continue;
        }
      }
      buf[cnt++] = (byte) c;
    }
    return new String(buf, 0, cnt);
  }

  public int nextInt() throws IOException {
    int ret = 0;
    byte c = read();
    while (c <= ' ') {
      c = read();
    }

    do {
      ret = ret * 10 + c - '0';
    } while ((c = read()) >= '0' && c <= '9');
    return ret;
  }

  public long nextLong() throws IOException {
    long ret = 0;
    byte c = read();
    while (c <= ' ') {
      c = read();
    }

    boolean neg = (c == '-');
    if (neg) {
      c = read();
    }

    do {
      ret = ret * 10 + c - '0';
    } while ((c = read()) >= '0' && c <= '9');

    return neg ? -ret : ret;
  }

  public double nextDouble() throws IOException {
    double ret = 0, div = 1;
    byte c = read();
    while (c <= ' ') {
      c = read();
    }

    boolean neg = (c == '-');
    if (neg) {
      c = read();
    }

    do {
      ret = ret * 10 + c - '0';
    } while ((c = read()) >= '0' && c <= '9');

    if (c == '.') {
      while ((c = read()) >= '0' && c <= '9') {
        ret += (c - '0') / (div *= 10);
      }
    }

    return neg ? -ret : ret;
  }

  private byte read() throws IOException {
    if (inBufferPointer == bytesRead) {
      fillBuffer();
    }
    return inBuffer[inBufferPointer++];
  }

  private void fillBuffer() throws IOException {
    bytesRead = in.read(inBuffer, inBufferPointer = 0, BUFFER_SIZE);
    if (bytesRead == -1) {
      inBuffer[0] = -1;
    }
  }

  public void writelnInt(int i) {
    writeInt(i);
    writeBuffer((byte) '\n');
  }

  public void writeInt(int i) {
    if (i == 0) {
      writeBuffer((byte) '0');
      return;
    }

    if (i < 0) {
      writeBuffer((byte) '-');
      i = -i;
    }

    int index = 0;
    while (i > 0) {
      bytebuffer[index++] = (byte) ((i % 10) + '0');
      i /= 10;
    }

    while (index-- > 0) {
      writeBuffer(bytebuffer[index]);
    }
  }

  public void writelnLong(int i) {
    writeLong(i);
    writeBuffer((byte) '\n');
  }

  public void writeLong(long i) {
    if (i == 0) {
      writeBuffer((byte) '0');
      return;
    }

    if (i < 0) {
      writeBuffer((byte) '-');
      i = -i;
    }

    int index = 0;
    while (i > 0) {
      bytebuffer[index++] = (byte) ((i % 10) + '0');
      i /= 10;
    }

    while (index-- > 0) {
      writeBuffer(bytebuffer[index]);
    }
  }

  private void writeBuffer(byte b) {
    if (outBufferPointer == outBuffer.length) {
      flushBuffer();
    }
    outBuffer[outBufferPointer++] = b;
  }

  public void flushBuffer() {
    if (outBufferPointer != 0) {
      try {
        out.write(outBuffer, 0, outBufferPointer);
      } catch (Exception ignored) {
      }
    }
    outBufferPointer = 0;
  }

  public void flushAndClose() throws IOException {
    flushBuffer();
    close();
  }

  public void close() throws IOException {
    in.close();
    out.close();
  }
}
