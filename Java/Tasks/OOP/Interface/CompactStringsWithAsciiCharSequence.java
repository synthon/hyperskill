public class AsciiCharSequence implements CharSequence {
    byte[] seq;
    
    public AsciiCharSequence(byte[] seq) {
        this.seq = seq;
    }
    
    public int length() {
        int len = 0;
        
        for (byte ch : seq) {
            len += 1;
        }
        
        return len;
    }
    
    public char charAt(int ch) {
        return (char) seq[ch];
    }
    
    public CharSequence subSequence(int start, int end) {
        byte[] sub = new byte[end - start];
        
        for (int i = start; i < end; i++) {
            sub[i - start] = seq[i];
        }
        
        return new AsciiCharSequence(sub);
    }
    
    public String toString() {
        return new String(seq);
    }
}
