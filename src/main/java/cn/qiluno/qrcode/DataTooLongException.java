package cn.qiluno.qrcode;

/**
 * Thrown when the supplied data does not fit any QR Code version. Ways to handle this exception include:
 * <ul>
 *   <li><p>Decrease the error correction level if it was greater than {@code Ecc.LOW}.</p></li>
 *   <li><p>If the advanced {@code encodeSegments()} function with 6 arguments or the
 *     {@code makeSegmentsOptimally()} function was called, then increase the maxVersion argument
 *     if it was less than {@link QRCode#MAX_VERSION}. (This advice does not apply to the other
 *     factory functions because they search all versions up to {@code QrCode.MAX_VERSION}.)</p></li>
 *   <li><p>Split the text data into better or optimal segments in order to reduce the number of
 *     bits required. (See {link QRSegmentAdvanced#makeSegmentsOptimally(CharSequence,QRCode.Ecc,int,int)
 *     QRSegmentAdvanced.makeSegmentsOptimally()}.)</p></li>
 *   <li><p>Change the text or binary data to be shorter.</p></li>
 *   <li><p>Change the text to fit the character set of a particular segment mode (e.g. alphanumeric).</p></li>
 *   <li><p>Propagate the error upward to the caller/user.</p></li>
 * </ul>
 * @see QRCode#encodeText(CharSequence, QRCode.Ecc)
 * @see QRCode#encodeBinary(byte[], QRCode.Ecc)
 * @see QRCode#encodeSegments(java.util.List, QRCode.Ecc)
 * @see QRCode#encodeSegments(java.util.List, QRCode.Ecc, int, int, int, boolean)
 * see QRSegmentAdvanced#makeSegmentsOptimally(CharSequence, QRCode.Ecc, int, int)
 */
public class DataTooLongException extends IllegalArgumentException{

    public DataTooLongException() {}

    public DataTooLongException(String message) {
        super(message);
    }
}
