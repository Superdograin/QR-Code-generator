package cn.qiluno.qrcode;

import java.util.BitSet;
import java.util.Objects;

public final class BitBuffer implements Cloneable {
    private BitSet data;
    private int bitLength;

    public BitBuffer() {
        data = new BitSet();
        bitLength = 0;
    }

    public int bitLength() {
        assert bitLength >= 0;
        return bitLength;
    }

    public int getBit(int index) {
        if (index < 0 || index >= bitLength) {
            throw new IndexOutOfBoundsException();
        }
        return data.get(index) ? 1 : 0;
    }

    public void appendBits(int val, int len) {
        if (len < 0 || len > 31 || val >>> len != 0)
            throw new IllegalArgumentException("Value out of range");
        if (Integer.MAX_VALUE - bitLength < len)
            throw new IllegalStateException("Maximum length reached");
        for (int i = len - 1; i >= 0; i--, bitLength++)
            data.set(bitLength, ((val >>> i) & 1) != 0);
    }

    public void appendBits(BitBuffer bb) {
        Objects.requireNonNull(bb);
        if (Integer.MAX_VALUE - bitLength < bb.bitLength)
            throw new IllegalStateException("Maximum length reached");
        for (int i = 0; i < bb.bitLength; i++, bitLength++)
            data.set(bitLength, bb.data.get(i));
    }

    public BitBuffer clone() {
        try {
            BitBuffer result = (BitBuffer) super.clone();
            result.data = (BitSet) result.data.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
